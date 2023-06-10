package peaksoft.service;

import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserResponses;

public interface FavoriteService {
    SimpleResponse saveFavorite();
    UserResponses getAllFavorite();

    SimpleResponse updateFavorite(Long id, UserRequest userRequest);

    UserResponses getFavoriteById(Long id);

    SimpleResponse deleteById(Long id);
}
