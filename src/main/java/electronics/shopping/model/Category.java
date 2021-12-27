package electronics.shopping.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private SuperCategory superCategory;

//    @JsonIgnore
//    @ManyToMany(mappedBy = "electronics"  ,fetch = FetchType.LAZY)
//    private List<Product> products = new ArrayList<>();
}
