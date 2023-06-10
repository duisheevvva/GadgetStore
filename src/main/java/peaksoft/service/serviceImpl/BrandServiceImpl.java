package peaksoft.service.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import peaksoft.dto.request.BrandRequest;
import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserResponses;
import peaksoft.entity.Brand;
import peaksoft.entity.User;
import peaksoft.repository.BrandRepository;
import peaksoft.repository.UserRepository;
import peaksoft.service.BrandService;

@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final UserRepository userRepository;



    private User getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userRepository.getUserByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("User not found!"));

    }

    @Override
    public SimpleResponse saveBrand(BrandRequest brandRequest) {
        User authenticationUser = getAuthentication();
        Brand brand =Brand.builder()
                .brandName(brandRequest.getBrandName())
                .build();
        brandRepository.save(brand);
        authenticationUser.
        return null;
    }

    @Override
    public UserResponses getAllBrand() {
        return null;
    }

    @Override
    public SimpleResponse updateBrand(Long id, UserRequest userRequest) {
        return null;
    }

    @Override
    public UserResponses getBrandById(Long id) {
        return null;
    }

    @Override
    public SimpleResponse deleteById(Long id) {
        return null;
    }
}
