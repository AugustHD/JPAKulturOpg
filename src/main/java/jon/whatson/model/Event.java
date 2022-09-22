package jon.whatson.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data // ... hashCode()
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String venue;
    private Timestamp timestamp;
    //date kommer måske
    @ManyToOne
    @JsonBackReference // pga. cirkulær reference i @RestController
    @EqualsAndHashCode.Exclude // pga. hashCode() fra @Data
    private Band band;
   // @OneToMany(mappedBy = "event")
   //  private Set<Review> reviews = new HashSet<>();
}
