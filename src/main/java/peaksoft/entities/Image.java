package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import peaksoft.forEntities.BaseEntity;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "images")
@Getter
@Setter
@NoArgsConstructor
@ToString
@SequenceGenerator(name = "base_id_gen", sequenceName = "image_seq", allocationSize = 1)
public class Image extends BaseEntity {
    @Column(name = "image_URL", length = 2000)
    private String imageURL;

//*********************************************
    @ManyToOne(cascade = {PERSIST, MERGE, REMOVE, REFRESH})
    private Post post;

    @OneToMany(cascade = {DETACH})
    private List<User> users;
}
