package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    private UserRepository userRepository;
    @BeforeEach
    void setup(){
        userRepository = new UserRepositoryImpl();
    }

    @Test
    void saveUserTest() {
        //given that i have a user
        User user = new User("chris@gmail","adeola oladeji","090786543223");
        //when
        User savedUser = userRepository.save(user);
        //assert that user has a full name
        assertEquals("adeola oladeji",savedUser.getFullName());
        assertEquals(1,userRepository.count());
    }

    @Test
    void findUserByEmail() {
        //given
        User user = new User("chris@gmail","adeola oladeji","090786543223");
        //when
        User savedUser = userRepository.save(user);
        //assert
        assertEquals("chris@gmail",savedUser.getEmail());
    }

    @Test
    void deleteUserByNameTest() {
        //given
        User user = new User("chris@gmail","adeola oladeji","09078654322");
        User user1 = new User("malik.com","malik abdul","09067213490");
        User user2 = new User("ehiz.com","ehiz man","08130213491");
        User user3 = new User("miju@gmail","increase miju","09109213245");

        userRepository.save(user);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        //when
        userRepository.delete( user1);
       assertEquals(3, userRepository.count());
    }

    @Test
    void testDelete() {
    }

    @Test
    void findAll() {
        User user = new User("chris@gmail","adeola oladeji","09078654322");
        User user1 = new User("malik.com","malik abdul","09067213490");
        User user2 = new User("ehiz.com","ehiz man","08130213491");
        User user3 = new User("miju@gmail","increase miju","09109213245");

        userRepository.save(user);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        List<User> allUsers = userRepository.findAll();
        assertEquals(4, allUsers.size());
    }


}