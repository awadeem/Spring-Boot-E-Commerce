package com.shopme.admin.user;

import com.shopme.common.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User,Integer> {
    /**@Param annotation, with the param name is email; and then a variable of type String... email...
     * and we use the @Query annotation here
     * to specify a custom JPA query.*/
    @Query("SELECT u FROM User u WHERE u.email = :email")
    public  User getUserByEmail(@Param("email") String email);

}
