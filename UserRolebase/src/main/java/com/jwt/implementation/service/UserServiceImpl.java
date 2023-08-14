package com.jwt.implementation.service;

import com.jwt.implementation.model.Role;
import com.jwt.implementation.model.User;
import com.jwt.implementation.repository.RoleRepository;
import com.jwt.implementation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
        @Autowired
        private BCryptPasswordEncoder passwordEncode;
        @Autowired
        private UserRepository userRepo;

    @Autowired
    RoleRepository roleRepo;
        @Override
        public User readUser() {
            int userId = getLoggedInUser().getId();
            return userRepo.findById(userId)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found for the id:"+userId));
        }

    @Override
    public User updateUser(User user) {
        User existingUser = readUser();//get logged user
        existingUser.setUserName(user.getUserName() != null ? user.getUserName() : existingUser.getUserName());
        existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());
        existingUser.setPassword(user.getPassword() != null ? passwordEncode.encode(user.getPassword()) : existingUser.getPassword());

        Role role = new Role();

        if(user.getRole().equals("USER"))
            role = roleRepo.findByRole("ROLE_USER");
        else if(user.getRole().equals("ADMIN"))
            role = roleRepo.findByRole("ROLE_ADMIN");

        if(role != null && role.getId() != 0) {
            existingUser.setRole(role);
        }

        return userRepo.save(existingUser);
    }
    @Override
        public void deleteUser() {
            User existingUser = readUser();
            userRepo.delete(existingUser);
        }

        @Override
        public User getLoggedInUser() {
            //get logged user info from SecurityContextHolder
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            String userName = authentication.getName();

            return userRepo.findByUserName(userName);
        }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override

    public boolean emailExists(String email) {
        return userRepo.findByEmail(email) != null;
    }

}



