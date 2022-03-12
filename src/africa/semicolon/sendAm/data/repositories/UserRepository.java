package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.Package;
import africa.semicolon.sendAm.data.models.User;

import java.util.List;

public interface UserRepository {

    User save (User myUser);
    void delete (User myUser);
    List<User> findAll();
    int count();

    User findByEmail(String email);
}
