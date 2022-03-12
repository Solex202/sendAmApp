package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.models.User;
import africa.semicolon.sendAm.data.repositories.UserRepository;
import africa.semicolon.sendAm.data.repositories.UserRepositoryImpl;
import africa.semicolon.sendAm.dtos.request.RegisterUserRequest;
import africa.semicolon.sendAm.dtos.response.FindUserResponse;
import africa.semicolon.sendAm.dtos.response.RegisterUserResponse;
import africa.semicolon.sendAm.exceptions.RegisterFailureException;
import africa.semicolon.sendAm.exceptions.UserNotFoundException;

public class UserServicesImpl implements UserServices{

    private UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public RegisterUserResponse register(RegisterUserRequest requestForm) {
        requestForm.setEmailAddress(requestForm.getEmailAddress().toLowerCase());
        if(emailExists(requestForm.getEmailAddress())) throw new RegisterFailureException("Email is not valid");
        User user = new User(requestForm.getEmailAddress(), requestForm.getLastName() + " " + requestForm.getFirstName(), requestForm.getPhoneNumber());

        user.setAddress(requestForm.getAddress());


        User savedUser = userRepository.save(user);

        RegisterUserResponse newResponse = new RegisterUserResponse();
        newResponse.setEmail(savedUser.getEmail());
        newResponse.setFullName(savedUser.getFullName());

        return newResponse;
    }

    private boolean emailExists(String emailAddress) {
        User user = userRepository.findByEmail(emailAddress);
        if (user == null) return false;
        return true;
    }

    @Override
    public UserRepository getRepository() {
        return userRepository;
    }

    @Override
    public FindUserResponse findUserByEmail(String email) {
        email = email.toLowerCase();
        User user = userRepository.findByEmail(email);
        //create response
        if(user == null) throw new UserNotFoundException("user not found");
        FindUserResponse response = new FindUserResponse();
        response.setEmail(user.getEmail());
        response.setFullName(user.getFullName());
        return response;
    }
}
