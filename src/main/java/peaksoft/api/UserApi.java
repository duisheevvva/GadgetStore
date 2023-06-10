package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.UserResponse;
import peaksoft.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserApi {

    private final UserService userService;


    @PostMapping("/login")
    public UserResponse saveAdmin(@RequestBody UserRequest userRequest){
        return userService.authenticate(userRequest);
    }


    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Long id){
        return null;
    }

}