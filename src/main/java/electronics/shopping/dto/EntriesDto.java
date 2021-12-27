package electronics.shopping.dto;

import electronics.shopping.model.Cart;
import electronics.shopping.model.Entries;
import electronics.shopping.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntriesDto {
    private long id;
    private int count;
    private double price;
    private Product product;
    private Cart cart;

//    public EntriesDto(Entries entries){
//        this.setId(entries.getId());
//        this.setCount(entries.getCount());
//        this.setPrice(entries.getPrice());
//        this.setProduct(entries.getProduct());
//        this.setCart(entries.getCart());
//    }

    private EntriesDto(Builder builder) {
        setId(builder.id);
        setCount(builder.count);
        setPrice(builder.price);
        setProduct(builder.product);
        setCart(builder.cart);
    }

    public static final class Builder {
        private long id;
        private int count;
        private double price;
        private Product product;
        private Cart cart;

        public Builder() {
        }

        public Builder id(long val) {
            id = val;
            return this;
        }

        public Builder count(int val) {
            count = val;
            return this;
        }

        public Builder price(double val) {
            price = val;
            return this;
        }

        public Builder product(Product val) {
            product = val;
            return this;
        }

        public Builder cart(Cart val) {
            cart = val;
            return this;
        }

        public EntriesDto build() {
            return new EntriesDto(this);
        }
    }
}
