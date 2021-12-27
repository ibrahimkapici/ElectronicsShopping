package electronics.shopping.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CreateOrder {
    @Id
    @GeneratedValue
    long id;

    private String deliveryAddress;
    private String paymentMethod;
    private String deliveryMode;

    @OneToOne
    private Cart cart;


}
