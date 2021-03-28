package bg.example.football.service.users;

import bg.example.football.model.entities.UserEntity;
import bg.example.football.model.entities.UserRoleEntity;
import bg.example.football.model.entities.enums.UserRole;
import bg.example.football.model.service.UserLoginServiceModel;
import bg.example.football.model.service.UserRegisterServiceModel;
import bg.example.football.repository.UserRepository;
import bg.example.football.repository.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final UserDetailsServiceImpl userDetailsService;

    public UserServiceImpl(UserRoleRepository userRoleRepository,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           ModelMapper modelMapper, UserDetailsServiceImpl userDetailsService) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.userDetailsService = userDetailsService;
    }

    public void initRoles() {
        if (userRoleRepository.count() == 0) {
            UserRoleEntity adminRole = new UserRoleEntity().setRole(UserRole.ADMIN);
            UserRoleEntity userRole = new UserRoleEntity().setRole(UserRole.USER);
            userRoleRepository.saveAll(Set.of(adminRole, userRole));
        }
    }

    @Override
    public void initAdmin() {
        if (userRepository.count() == 0) {
            UserRoleEntity adminRole = this.userRoleRepository.findByRole(UserRole.ADMIN).orElseThrow();
            UserRoleEntity userRole = this.userRoleRepository.findByRole(UserRole.USER).orElseThrow();

            UserEntity admin = new UserEntity()
                    .setEmail("admin")
                    .setFullName("Admin Adminov")
                    .setPassword(passwordEncoder.encode("admin"));

            admin.setRoles(Set.of(adminRole, userRole));
            userRepository.save(admin);
        }
    }

    @Override
    public void register(UserRegisterServiceModel serviceModel) {
        LOGGER.info("Creating a new user with email [PROTECTED].");

        UserEntity newUser = modelMapper.map(serviceModel, UserEntity.class);
        newUser.setPassword(passwordEncoder.encode(serviceModel.getPassword()));

        UserRoleEntity userRole = userRoleRepository.
                findByRole(UserRole.USER).orElseThrow(
                () -> new IllegalStateException("USER role not found. Please seed the roles."));

        newUser.addRole(userRole);

        userRepository.save(newUser);
    }

    @Override
    public void login(UserLoginServiceModel userLoginServiceModel) {
        UserEntity newUser =
                this.modelMapper.map(
                        this.userRepository.findByEmail(userLoginServiceModel.getEmail()),
                        UserEntity.class);

        UserDetails principal = userDetailsService.loadUserByUsername(userLoginServiceModel.getEmail());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUser.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public boolean exist(String email) {
        return this.userRepository.findByEmail(email).isEmpty();
    }

    @Override
    public UserEntity findOneByEmail(String email) {
        return this.userRepository
                .findByEmail(email)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public UserEntity findOneById(String id) {
        return userRepository
                .findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }





}
