package electronics.shopping.service;

import electronics.shopping.dto.ProductDto;
import electronics.shopping.model.Product;
import electronics.shopping.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    private   ModelMapper modelMapper;



    public List<ProductDto> getAllProduct(){
        return productRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

//    public ProductDto convertEntityToDto(Product product) {
//        ProductDto productDto = new ProductDto();
//        productDto = modelMapper.map(product, ProductDto.class);
//        return productDto;
//
//    }
    public ProductDto convertEntityToDto(Product product) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        ProductDto productDto = new ProductDto();
        productDto = modelMapper.map(product, ProductDto.class);
        return productDto;

    }

//    public ProductDto addProduct (ProductDto product) {
//
//        return productRepository.save(product);
//    }
    public Product addProduct (Product product) {

        return productRepository.save(product);
    }

    public Product convertDtoToEntity(ProductDto productDto) {
        Product product = new Product();
        product = modelMapper.map(productDto, Product.class);
        return product;

    }
//        ProductDto productDto = new ProductDto (product);
//        productDto.setProductId(product.getId());
//        productDto.setName(product.getName());
//        productDto.setCategory(product.getCategory());
//        productDto.setDescription(product.getDescription());
//        productDto.setPrice(product.getPrice());
//        return productDto;


//    public ProductDto addProductDto(ProductDto productDto){
//        return productRepository.save(productDto);
//    }

   // public ProductDto addProductDto(ProductDto productDto){
       //return productRepository.save(productDto);
     //   return productRepository.save(convertEntityToDto((productDto)));
        //  return productRepository.convertEntityToDto((addProduct(convertDtoToEntity(productDto))));
  //  }

//        ProductDto productDto = new ProductDto.Builder().setProductId().setName()
//                        .setDescription()
//                        .setPrice()
//                        .setProduct()
//                        .setCategory();
//        return new ProductDto.Builder().setProductId().setName()
//                .setDescription()
//                .setPrice()
//                .setProduct()
//                .createProductDto();



//    public ProductDto getByProductId(long id){
//        return productRepository.
//    }

//    public ProductDto addProduct(ProductDto productDto){
//       return productRepository.save(new ProductDto.Builder());
//    }
    public void removeProductById(long id){
        productRepository.deleteById(id);
    }

    public ProductDto getProductById(long id){
        Optional<Product> byId = productRepository.findById(id);
        return modelMapper.map(byId.get(), ProductDto.class);
    }
    public List<ProductDto> getAllProductsByCategoryId(int id){
      return  productRepository.findAllByCategory_Id(id);
    }
}
//    public void getAllProductsByCategory(){
//        productRepository.findAllByCategory_Id();
//
//    }
