package com.shopme.admin.user;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired //let spring framework inject an instance, an implementation of the UserRepository at runtime.
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> listAll(){
        return (List<User>) userRepository.findAll();
    }

    public List<Role> listRoles(){
        return (List<Role>) roleRepository.findAll();
    }

    public void save(User user) {
        encodePassword(user);
        userRepository.save(user);
    }
    private void encodePassword(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }
/**    The comparison of the userByEmail object against null here.If it returns true,
    that means the user email is unique, because userByEmail is null...
    meaning that no existing user in the database having this email.
    Otherwise, if the userByEmail object is not null that means the given email is not unique*/
    public boolean isEmailUnique(String email){
        User userByEmail = userRepository.getUserByEmail(email);
        return userByEmail==null;
    }
}
