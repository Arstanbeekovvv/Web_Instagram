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
@Table(name = "likes")
@Getter
@Setter
@NoArgsConstructor
@ToString
@SequenceGenerator(name = "base_id_gen", sequenceName = "like_seq", allocationSize = 1)
public class Like extends BaseEntity {
    @Column(name = "is_like")
    private Boolean isLike;

//*********************************************
    @OneToOne(cascade = {DETACH})
    private User user;
//*********************************************
    @ManyToOne(cascade = {DETACH})
    private Comment comment;
//*********************************************
    @ManyToOne(cascade = {DETACH})
    private Post post;
}
