package jon.whatson.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;

@Data
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String text;
    String rating; // Ikke sikker på hvilken datatype er bedst.
    // Nedenunder ser ikke særlig godt ud.
    @ManyToOne
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Event event;
    @ManyToOne
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private User user;

}