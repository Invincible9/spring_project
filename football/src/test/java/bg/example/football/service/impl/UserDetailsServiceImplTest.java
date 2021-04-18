package bg.example.football.service.impl;

import bg.example.football.model.entities.UserEntity;
import bg.example.football.model.entities.UserRoleEntity;
import bg.example.football.model.entities.enums.UserRole;
import bg.example.football.repository.UserRepository;
import bg.example.football.service.users.UserDetailsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class UserDetailsServiceImplTest {

    private UserDetailsServiceImpl serviceToTest;

    @Mock
    UserRepository mockUserRepository;

    @BeforeEach
    public void setUp() {
        serviceToTest = new UserDetailsServiceImpl(mockUserRepository);
    }
    @Test
    void testUserNotFound() {
        Assertions.assertThrows(
                UsernameNotFoundException.class, () -> serviceToTest.loadUserByUsername("user_does_not_exits")
        );
    }

    @Test
    void testExistingUser() {
        // prepare data
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("admin@admin.com");
        userEntity.setPassword("admin");

        UserRoleEntity roleUser = new UserRoleEntity();
        roleUser.setRole(UserRole.USER);
        UserRoleEntity roleAdmin = new UserRoleEntity();
        roleAdmin.setRole(UserRole.ADMIN);

        userEntity.setRoles(Set.of(roleUser, roleAdmin));

        // configure mocks
        Mockito.when(mockUserRepository.findByEmail("admin@admin.com")).
                thenReturn(Optional.of(userEntity));

        // test
        UserDetails userDetails = serviceToTest.loadUserByUsername("admin@admin.com");

        Assertions.assertEquals(userEntity.getEmail(), userDetails.getUsername());
        Assertions.assertEquals(2, userDetails.getAuthorities().size());

        List<String> authorities = userDetails.
                getAuthorities().
                stream().
                map(GrantedAuthority::getAuthority).
                collect(Collectors.toList());

        Assertions.assertTrue(authorities.contains("ROLE_ADMIN"));
        Assertions.assertTrue(authorities.contains("ROLE_USER"));
    }

}
