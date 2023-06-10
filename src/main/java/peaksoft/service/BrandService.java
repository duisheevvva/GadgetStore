package peaksoft.service;

import peaksoft.dto.request.BrandRequest;
import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserResponses;

public interface BrandService {
    SimpleResponse saveBrand(BrandRequest brandRequest);
    UserResponses getAllBrand();

    SimpleResponse updateBrand(Long id, UserRequest userRequest);

    UserResponses getBrandById(Long id);

    SimpleResponse deleteById(Long id);
}
