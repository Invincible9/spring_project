package bg.example.football.service.users;

import bg.example.football.model.entities.UserEntity;
import bg.example.football.model.service.UserLoginServiceModel;
import bg.example.football.model.service.UserRegisterServiceModel;

public interface UserService {

    void initRoles();

    void initAdmin();

    UserEntity register(UserRegisterServiceModel serviceModel);

    void login(UserLoginServiceModel userLoginServiceModel);

    boolean exist(String email);

    UserEntity findOneByEmail(String email);

    UserEntity findOneById(String id);
}
