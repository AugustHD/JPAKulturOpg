package jon.whatson.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String text;
    String rating; // Ikke sikker på hvilken datatype er bedst.
    @ManyToOne
    @JsonBackReference
    private Event event;
    @ManyToOne
    @JsonBackReference
    private User user;

}