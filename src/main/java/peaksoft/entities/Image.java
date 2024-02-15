package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import peaksoft.forEntities.BaseEntity;

import java.util.List;

import static jakarta.persistence.CascadeType.DETACH;

@Entity
@Table(name = "images")
@Getter
@Setter
@NoArgsConstructor
@ToString
@SequenceGenerator(name = "base_id_gen", sequenceName = "image_seq", allocationSize = 1)
public class Image extends BaseEntity {
    @Column(name = "image_URL")
    private String imageURL;

//*********************************************
    @ManyToOne
    private Post post;

    @OneToMany(cascade = {DETACH})
    private List<User> users;
}
