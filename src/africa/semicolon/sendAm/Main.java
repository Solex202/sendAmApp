package africa.semicolon.sendAm;

import africa.semicolon.sendAm.controllers.PackageController;
import africa.semicolon.sendAm.controllers.UserController;
import africa.semicolon.sendAm.dtos.request.RegisterUserRequest;
import africa.semicolon.sendAm.dtos.response.RegisterUserResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
@SpringBootApplication
public class Main {
    public static UserController userController = new UserController();
    public static PackageController PackageController = new PackageController();
    public static void main(String[] args) {
        //load options
//        loadOptions();
        SpringApplication.run(Main.class, args);
        //if option is register
        //load form
        //print output
        //load option

        //if option is search bt email
        //ask for email
        //show
        //load options
    }

    private static void loadOptions() {
        String options = """
                -> A for register
                -> B for find by email
                 """;
//        display(options);
        String input = collectStringInput(options);
        switch(input.toLowerCase()){
            case "a" -> loadRegisterForm();
            case "b" -> askUserForEmail();
            default -> {
                display("get sense");
                loadOptions();
            }
        }
    }

    private static void askUserForEmail() {
        String userEmail= collectStringInput("Enter the email you want to search");
        var response  = userController.getUserByEmail(userEmail);
        display(response.toString());
    }

    private static void loadRegisterForm(){
        RegisterUserRequest form = new RegisterUserRequest();
        form.setFirstName(collectStringInput("Enter your first name"));
        form.setLastName(collectStringInput("Enter your last name"));
        form.setEmailAddress(collectStringInput("Enter your email address"));
        form.setPhoneNumber(collectStringInput("Enter your phone number"));
        form.setAddress(collectStringInput("Enter your address name"));
        RegisterUserResponse response = userController.registerNewUser(form);
        display(response.toString());
        loadOptions();
    }

    private static String collectStringInput(String message) {
        Scanner scanner = new Scanner(System.in);
        display(message);
        return scanner.nextLine();
    }

    private static void display(String message){
        System.out.println(message);
    }
}
