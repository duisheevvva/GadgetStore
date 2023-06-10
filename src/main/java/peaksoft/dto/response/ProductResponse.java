package peaksoft.dto.response;

import peaksoft.enums.Category;

import java.util.List;

public class ProductResponse {
    private Long id;
    private int price;
    private List<String> images;
    private String characteristic;
    private Boolean isFavorite;
    private String madeIn;
    private Category category;
}
