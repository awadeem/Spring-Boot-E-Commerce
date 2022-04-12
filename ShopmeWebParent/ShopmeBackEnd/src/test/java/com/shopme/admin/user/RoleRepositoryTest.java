package com.shopme.admin.user;

import com.shopme.common.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest // to leverage the Data JPA test of Spring Data JPA
/** we will run the unit test method against the real database, so we need to use this annotation
 * because by default spring data JPA will run the test against an in-memory database
 * So if you want to test with real database, we need to override the default configuration
 * replace = Replace.NONE. So it will run the test against the real database
 */
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository repo;

    @Test
    public void testCreateFirstRole(){
        Role roleAdmin = new Role("Admin", "Manage everything");
        Role saveRole = repo.save(roleAdmin);
        assertThat(saveRole.getId()).isGreaterThan(0);
    }
}
