package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import peaksoft.forEntities.BaseEntity;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.DETACH;
import static jakarta.persistence.CascadeType.REMOVE;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@ToString
@SequenceGenerator(name = "base_id_gen", sequenceName = "post_seq", allocationSize = 1)
public class Post extends BaseEntity {
    private String title;
    private String description;
    @Column(name = "created_At")
    private LocalDate createdAt = LocalDate.now();

//*********************************************
    @OneToMany(cascade = {REMOVE}, mappedBy = "post")
    private List<Comment> comments;
//*********************************************
    @OneToMany(cascade = {REMOVE}, mappedBy = "post")
    private List<Like> likes;
//*********************************************
    @OneToMany(cascade = {REMOVE}, mappedBy = "post")
    private List<Image> images;
//*********************************************
    @ManyToOne(cascade = {DETACH})
    private User user;
//*********************************************


}
