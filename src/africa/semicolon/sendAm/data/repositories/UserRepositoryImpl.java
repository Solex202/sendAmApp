package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepositoryImpl implements UserRepository{

    private List<User> users = new ArrayList<>();

    @Override
    public User save(User myUser) {
        users.add(myUser);
        return myUser;
    }
    @Override
    public void delete(User myUser) {
        users.remove(myUser);
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public int count() {
        return users.size();
    }

    @Override
    public User findByEmail(String email) {
        for(User user : users){
            if(Objects.equals(user.getEmail(),email)) return user;
        }
        return null;
    }


}
