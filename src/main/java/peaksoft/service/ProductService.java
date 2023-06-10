package peaksoft.service;

import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserResponses;

public interface ProductService {
    SimpleResponse saveProduct();
    UserResponses getAllProduct();

    SimpleResponse updateProduct(Long id, UserRequest userRequest);

    UserResponses getProductById(Long id);

    SimpleResponse deleteById(Long id);

}
