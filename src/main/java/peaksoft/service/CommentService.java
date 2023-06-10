package peaksoft.service;

import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserResponses;

public interface CommentService {
    SimpleResponse saveComment();
    UserResponses getAllComment();

    SimpleResponse updateComment(Long id, UserRequest userRequest);

    UserResponses getCommentById(Long id);

    SimpleResponse deleteById(Long id);
}
