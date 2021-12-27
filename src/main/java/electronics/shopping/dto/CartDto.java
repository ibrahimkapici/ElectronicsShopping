package electronics.shopping.dto;

import electronics.shopping.model.Entries;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartDto {
    private Long id;
    private Double totalPrice;
    private List<Entries> entries;


    public static final class CartDtoBuilder {
        private Long id;
        private Double totalPrice;
        private List<Entries> entries;

        private CartDtoBuilder() {
        }

        public static CartDtoBuilder aCartDto() {
            return new CartDtoBuilder();
        }

        public CartDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CartDtoBuilder totalPrice(Double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public CartDtoBuilder entries(List<Entries> entries) {
            this.entries = entries;
            return this;
        }

        public CartDto build() {
            CartDto cartDto = new CartDto();
            cartDto.setId(id);
            cartDto.setTotalPrice(totalPrice);
            cartDto.setEntries(entries);
            return cartDto;
        }
    }
}
