package peaksoft.service.serviceImpl;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.config.JwtService;
import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserResponse;
import peaksoft.dto.response.UserResponses;
import peaksoft.entity.User;
import peaksoft.enums.Role;
import peaksoft.repository.UserRepository;
import peaksoft.service.UserService;

import java.time.ZonedDateTime;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostConstruct
    public void init() {
        String email = "admin@gmail.com";
        if (!userRepository.existsByEmail(email)) {
            User user = new User();
            user.setFirstName("Aizat");
            user.setLastName("Duisheeva");
            user.setEmail(email);
            user.setCreateDate(ZonedDateTime.now());
            user.setPassword(passwordEncoder.encode("admin123"));
            user.setRole(Role.ADMIN);
            userRepository.save(user);
        }
    }


    @Override
    public UserResponse authenticate(UserRequest userRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getEmail(), userRequest.getEmail()));

        User user = userRepository.getUserByEmail(userRequest.getEmail())
                .orElseThrow(() -> new NoSuchElementException(String.format("User with email: %s doesn't exists", userRequest.getEmail())));

        String token = jwtService.generateToken(user);

        return UserResponse.builder().email(user.getEmail()).token(token).build();
    }



    @Override
    public UserResponses getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public SimpleResponse update(Long id, UserRequest userRequest) {
        User user = jwtService.getAuthentication();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setRole(userRequest.getRole());
        userRepository.save(user);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .massage("Updated")
                .build();
    }

    @Override
    public UserResponses getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NullPointerException("not found"));
        return  new UserResponses(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole()
        );
    }

    @Override
    public SimpleResponse deleteById(Long id) {
         userRepository.findById(id).orElseThrow(() -> new NullPointerException("not found"));
        userRepository.deleteById(id);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .massage("Deleted!")
                .build();
    }
}