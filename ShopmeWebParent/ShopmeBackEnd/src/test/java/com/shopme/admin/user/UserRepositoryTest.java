package com.shopme.admin.user;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager; // it store data from database

    @Test
    public void testCreateNewUserWithOneRole(){
        Role roleAdmin = entityManager.find(Role.class,1);
        User userNamAQ = new User("AQ@gmail.com","AQ2021","Alvina","Qadeer");
        userNamAQ.addRole(roleAdmin);
        User savedUser = repo.save(userNamAQ);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateNewUserWithTwoRole(){
        User userNamNJ = new User("AJ@gmail.com","AJ2020","Nick","John");
        Role roleEditor = new Role(3);
        Role roleAssistant = new Role(5);
        userNamNJ.addRole(roleAssistant);
        userNamNJ.addRole(roleEditor);

        User savedUser = repo.save(userNamNJ);
        assertThat(savedUser.getId()).isGreaterThan(0);

    }

    @Test
    public void testListAllUsers() {
        Iterable<User> listUsers = repo.findAll();
        listUsers.forEach(user -> System.out.println(user));

    }

    @Test
    public void testGetUserById() {
        User userAQ = repo.findById(1).get();
        System.out.println(userAQ);
        assertThat(userAQ).isNotNull();
    }
}
