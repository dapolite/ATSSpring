/*
package com.example.ats.api;

import com.example.ats.model.Users;
import com.example.ats.repository.UserRepository;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/homes")
    public String homes(){
        return "Hello9";
    }


    @RequestMapping("/home")
    public String home(){
        return "Hello9";
    }

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }


    @GetMapping("/users/{id}")
    public Users getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", userId));
    }

    @PostMapping("/users")
    public Users createUser(@Valid @RequestBody Users user) {

        final String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public Users updateUser(
            @PathVariable(value = "id") Long userId, @Valid @RequestBody Users usersDetails)
            throws ResourceNotFoundException {
        Users users =
                userRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("Users not found on :: " + userId));
        users.setEmail(usersDetails.getEmail());
        users.setPassword(usersDetails.getPassword());
        users.setPhoneno(usersDetails.getPhoneno());
        Users updatedUsers = userRepository.save(users);
        return updatedUsers;
    }


    @DeleteMapping("/user/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
        Users users =
                userRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("Users not found on :: " + userId));
        userRepository.delete(users);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
*/
