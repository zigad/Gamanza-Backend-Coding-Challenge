package si.deisinger.DemoAplication.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Table(name = "Games")
@Getter
@Setter
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String players;
    private String images;
}