package electronics.shopping.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Entries {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Product product;

    private Integer count;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "cart_id")
//    private Cart cart;
    //relationu productid ile kur
//    private Product products;



}