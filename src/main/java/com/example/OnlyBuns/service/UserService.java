package com.example.OnlyBuns.service;

import com.example.OnlyBuns.dto.UserRequest;
import com.example.OnlyBuns.exception.ResourceConflictException;
import com.example.OnlyBuns.model.*;
import com.example.OnlyBuns.repository.AddressRepository;
import com.example.OnlyBuns.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final EmailService emailService;

    public UserService(UserRepository userRepository,
                       AddressRepository addressRepository,
                       PasswordEncoder passwordEncoder,
                       RoleService roleService,
                       EmailService emailService) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.emailService = emailService;
    }


    public User findById(Long id) {
        return userRepository.findById(id).orElseGet(null);
    }
    public User findByUsername(String username)  {
        return userRepository.findByUsername(username);
    }
    public User findByEmail(String email)  {
        return userRepository.findByEmail(email);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User save(UserRequest userRequest) {
        User existUser = findByUsername(userRequest.getUsername());

        if (existUser != null) {
            throw new ResourceConflictException(userRequest.getId(), "Username already exists");
        }
        existUser = findByEmail(userRequest.getEmail());

        if (existUser != null) {
            throw new ResourceConflictException(userRequest.getId(), "Email already exists");
        }

        User u = new User();

        Address address = createAddress(userRequest);

        String activationToken = UUID.randomUUID().toString();

        createUser(userRequest, u, activationToken);
        u.setAddress(address);



        String activationLink = "http://localhost:8080/auth/activate?token=" + activationToken;
        emailService.sendActivationEmail(u.getEmail(), activationLink);

        return this.userRepository.save(u);
    }

    public void activateUser(String token) {
        User user = userRepository.findByActivationToken(token)
                .orElseThrow(() -> new IllegalArgumentException("Invalid activation token"));

        user.setEnabled(true);
        user.setActivationToken(null); // Clear the token after activation
        userRepository.save(user);
    }

    private void createUser(UserRequest userRequest, User u, String activationToken) {
        u.setUsername(userRequest.getUsername());
        u.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        u.setFirstName(userRequest.getFirstname());
        u.setLastName(userRequest.getLastname());
        u.setEnabled(false);
        u.setEmail(userRequest.getEmail());

        u.setActivationToken(activationToken);

        List<Role> roles = roleService.findByName("ROLE_USER");
        u.setRoles(roles);

        u.setFollowersCount(0);
        u.setFollowers(new HashSet<>());
        u.setFollowings(new HashSet<>());
    }


    private Address createAddress(UserRequest userRequest) {
        Address address = new Address();

        address.setCountry(userRequest.getCountry());
        address.setCity(userRequest.getCity());
        address.setZipCode(userRequest.getZipCode());
        address.setStreetAddress(userRequest.getStreetAddress());

        addressRepository.save(address);
        return address;
    }

}