package com.shopme.admin.user;


import com.shopme.common.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//user package is for user management module
@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {
}
