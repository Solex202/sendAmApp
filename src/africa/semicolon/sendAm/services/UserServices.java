package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.repositories.PackageRepository;
import africa.semicolon.sendAm.data.repositories.UserRepository;
import africa.semicolon.sendAm.dtos.request.RegisterUserRequest;
import africa.semicolon.sendAm.dtos.response.FindUserResponse;
import africa.semicolon.sendAm.dtos.response.RegisterUserResponse;

public interface UserServices {

    RegisterUserResponse register(RegisterUserRequest requestForm);

    UserRepository getRepository();

    FindUserResponse findUserByEmail(String email);
}
