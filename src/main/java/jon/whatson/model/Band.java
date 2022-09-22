package jon.whatson.model;

import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "band") // Event klassen har allerede mappet til
    // denne band klasse. Defor behøver JPA ikke have mappe fra Band til Event.
    private Set<Event> events = new HashSet<>();
}
