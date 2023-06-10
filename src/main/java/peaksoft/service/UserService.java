package peaksoft.service;

import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserResponse;
import peaksoft.dto.response.UserResponses;

public interface UserService {

    public UserResponse authenticate(UserRequest userRequest);

    UserResponses getAllUser();

    SimpleResponse update(Long id, UserRequest userRequest);

    UserResponses getUserById(Long id);

    SimpleResponse deleteById(Long id);

}
