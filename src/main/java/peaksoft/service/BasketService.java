package peaksoft.service;

import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserResponses;

public interface BasketService {

    SimpleResponse saveBasket();
    UserResponses getAllBasket();

    SimpleResponse updateBasket(Long id, UserRequest userRequest);

    UserResponses getBasketById(Long id);

    SimpleResponse deleteById(Long id);

}
