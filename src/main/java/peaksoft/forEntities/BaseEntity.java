package peaksoft.forEntities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter
public class BaseEntity {
    @Id
    @GeneratedValue(generator = "base_id_gen", strategy = GenerationType.SEQUENCE)
    private Long id;
}
