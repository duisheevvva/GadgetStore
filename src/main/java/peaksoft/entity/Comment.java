package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;



@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(generator = "comment_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "comment_gen",
            sequenceName = "comment_seq", allocationSize = 1)
    private Long id;
    private String comment;
    private ZonedDateTime createDate;


    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    private Product product;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private User user;
}
