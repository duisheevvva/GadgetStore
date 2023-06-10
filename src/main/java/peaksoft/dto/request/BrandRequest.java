package peaksoft.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrandRequest {
    private String brandName;

}
