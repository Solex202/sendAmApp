package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.dtos.request.RegisterUserRequest;
import africa.semicolon.sendAm.dtos.response.FindUserResponse;
import africa.semicolon.sendAm.dtos.response.RegisterUserResponse;
import africa.semicolon.sendAm.exceptions.SendAmAppException;
import africa.semicolon.sendAm.exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class UserServicesImplTest {

    private UserServices userServices;

    @BeforeEach
    public void testSetUp(){
            userServices = new UserServicesImpl();
    }

    @Test
    void afterRegister_repositoryContainsOneElement(){
            //given
            RegisterUserRequest registerForm = createRegisterForm();
            //when
            userServices.register(registerForm);
            //assert
            assertEquals(1, userServices.getRepository().count());
    }

    private RegisterUserRequest createRegisterForm() {
            RegisterUserRequest registerForm = new RegisterUserRequest();
            registerForm.setFirstName("lotachi");
            registerForm.setLastName("senior dave");
            registerForm.setEmailAddress("seniorDaveDevil@gmail.com");
            registerForm.setAddress("Code Cold Hell");
            registerForm.setPhoneNumber("2MillionDollars");
            return registerForm;
    }

    @Test
    public void duplicateEmail_throwsException() {
            RegisterUserRequest lotaForm = createRegisterForm();
            //when
            userServices.register(lotaForm);
            //assert
            assertThrows(SendAmAppException.class, ()-> userServices.register(lotaForm));
    }

    @Test
    public void duplicateEmailWithDifferentCase_throwsException() {
            //given
            RegisterUserRequest lotaForm = createRegisterForm();
            userServices.register(lotaForm);
            //when
            lotaForm.setEmailAddress("seniordaveDevil@gmail.com");
            //assert
            assertThrows(SendAmAppException.class, ()-> userServices.register(lotaForm));
    }

        @Test
    public void registrationReturnsCorrectResponseTest(){
            //given
            RegisterUserRequest lotaForm = createRegisterForm();
            //when
            RegisterUserResponse response = userServices.register(lotaForm);
            //assert
            assertEquals("senior dave lotachi", response.getFullName());
            assertEquals("seniordavedevil@gmail.com", response.getEmail());
        }

        @Test
    void findRegisteredUserByEmail(){
            //given
            RegisterUserRequest lotaForm = createRegisterForm();
            userServices.register(lotaForm);
            //when
            FindUserResponse result = userServices.findUserByEmail(lotaForm.getEmailAddress().toLowerCase());
            //assert
            assertEquals("senior dave lotachi", result.getFullName());
            assertEquals("seniordavedevil@gmail.com", result.getEmail());
    }

    @Test
    void findingUnregisteredEmail_throwExceptionTest(){
            //given
            RegisterUserRequest lotaForm = createRegisterForm();
            //when
            userServices.register(lotaForm);
            //assert
            assertThrows(UserNotFoundException.class, ()->userServices.findUserByEmail("emma@gmail.com"));
    }
}