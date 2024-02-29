package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import peaksoft.forEntities.BaseEntity;

import java.util.List;

import static jakarta.persistence.CascadeType.DETACH;

@Entity
@Table(name = "followers")
@Getter
@Setter
@NoArgsConstructor
@ToString
@SequenceGenerator(name = "base_id_gen", sequenceName = "follower_seq", allocationSize = 1)
public class Follower extends BaseEntity {
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> subscribers;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> subscriptions;
//*********************************************
    @OneToOne(cascade = {DETACH}, mappedBy = "follower")
    private User user;
//*********************************************



}
