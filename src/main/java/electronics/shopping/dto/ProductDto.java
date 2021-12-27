package electronics.shopping.dto;

import electronics.shopping.model.Category;
import electronics.shopping.model.Product;
import electronics.shopping.service.ProductService;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class ProductDto {
    private Long id;
    private long productId;
    private String name;
    private String description;
    private double price;
//    private Product product;
    private Category category;

//    public List<ProductDto> addProduct(ProductDto productDto) {
//        List<ProductDto> productDtoList = new ArrayList<>();
//        productDtoList.add(productDto);
//        return productDtoList;
//    }

//    public ProductDto convertEntityToDto(Product product) {
//        ProductDto productDto = new ProductDto();
//        productDto = productService.convertEntityToDto(product);
//        return productDto;
//    }

    public  ProductDto(Product product){
        this.setProductId(product.getProductId());
        this.setName(product.getName());
        this.setDescription(product.getDescription());
        this.setPrice(product.getPrice());
        this.setCategory(product.getCategory());
    }

    public static class Builder{

        private long productId;
        private String name;
        private String description;
        private double price;
        private Product product;
        private Category category;


        public Builder setProductId(long productId) {
            this.productId = productId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

//        public Builder setProduct(Product product) {
//            this.product = product;
//            return this;
//        }

        public Builder setCategory(Category category) {
            this.category = category;
            return this;
        }

        public ProductDto createProductDto() {
            return new ProductDto(productId, name, description, price, category);
        }

    }

    private ProductDto(long productId, String name, String description, double price, Category category){
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
       // this.product = product;
        this.category = category;
    }


}
