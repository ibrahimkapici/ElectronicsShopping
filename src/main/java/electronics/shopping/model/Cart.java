package electronics.shopping.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double totalPrice;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Entries> entries;

}
