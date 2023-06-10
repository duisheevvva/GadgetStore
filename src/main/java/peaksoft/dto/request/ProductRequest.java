package peaksoft.dto.request;

import peaksoft.enums.Category;

import java.util.List;

public class ProductRequest {
    private int price;
    private List<String> images;
    private String characteristic;
    private Boolean isFavorite;
    private String madeIn;
    private Category category;

}
