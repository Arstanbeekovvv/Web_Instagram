package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import peaksoft.enums.Gender;
import peaksoft.forEntities.BaseEntity;

import static jakarta.persistence.CascadeType.REFRESH;

@Entity
@Table(name = "user_infos")
@Getter
@Setter
@NoArgsConstructor
@ToString
@SequenceGenerator(name = "base_id_gen", sequenceName = "user_info_seq", allocationSize = 1)
public class UserInfo extends BaseEntity {
    @Column(name = "full_name")
    private String fullName;
    private String biography;
    private Gender gender;
    private String image;

//*********************************************
    @OneToOne(cascade = {REFRESH})
    private User user;
}
