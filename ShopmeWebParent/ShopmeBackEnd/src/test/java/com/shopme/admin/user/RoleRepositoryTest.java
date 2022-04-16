package com.shopme.admin.user;

import com.shopme.common.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest // to leverage the Data JPA test of Spring Data JPA
/** we will run the unit test method against the real database, so we need to use this annotation
 * because by default spring data JPA will run the test against an in-memory database
 * So if you want to test with real database, we need to override the default configuration
 * replace = Replace.NONE. So it will run the test against the real database
 */
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository repo;

    @Test
    public void testCreateFirstRole() {
        Role roleAdmin = new Role("Admin", "manage everything");
        Role savedRole = repo.save(roleAdmin);

        assertThat(savedRole.getId()).isGreaterThan(0);
    }
    @Test
    public void testCreateRestRoles() {
        Role roleSalesperson = new Role("Salesperson", "manage product price, "
                + "customers, shipping, orders and sales report");

        Role roleEditor = new Role("Editor", "manage categories, brands, "
                + "products, articles and menus");

        Role roleShipper = new Role("Shipper", "view products, view orders "
                + "and update order status");

        Role roleAssistant = new Role("Assistant", "manage questions and reviews");

        repo.saveAll(List.of(roleSalesperson, roleEditor, roleShipper, roleAssistant));
    }
}
