package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import peaksoft.enums.Category;

import java.util.List;
@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(generator = "product_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "product_gen",
            sequenceName = "product_seq", allocationSize = 1)
    private Long id;
    private String name;
    private int price;
    @Lob
    private List<String>images;
    private String characteristic;
    private Boolean isFavorite;
    private String madeIn;
    private Category category;


    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private Brand brand;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Basket>baskets;

    @OneToMany(mappedBy = "product",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Favorite>favorites;

    @OneToMany(mappedBy = "product",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Comment>comments;

}
