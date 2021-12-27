package electronics.shopping.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import electronics.shopping.dto.ProductDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public  class Product {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Long id;

    private Long productId;
    private String name;
    private String description;
    private Double price;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {

    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product(Long id, Long productId, String name, String description, Double price, Category category) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }
    private ProductDto convertEntityToDto(Product product){
        return product.convertEntityToDto(product);
    }


}




//24.12.2021
//@Data
//@Entity
//public class Product {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//
//    private Double price;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    private Category category;
//
//    private String description;
//
//    private  Long productId;
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//}

//
//@Entity
//@Data
//public class Product {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String name;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
//    private Category category;
//
//    @ManyToOne
//    private double price;
//    private long categoryId;
//    private long productId;
//    private String description;
//
//
//
//}

