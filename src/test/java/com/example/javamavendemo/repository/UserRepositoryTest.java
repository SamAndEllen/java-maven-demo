package com.example.javamavendemo.repository;

import com.example.javamavendemo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveTest() {
        User user = new User();
        user.setName("John");
        user.setAge(20);
        user.setGender(User.Gender.MAN);

        userRepository.save(user);

        List<User> userList = userRepository.findAll();

        User john = userList.get(0);
        assertThat(john.getName()).isEqualTo("John");
        assertThat(john.getAge()).isEqualTo(20);
    }
}
