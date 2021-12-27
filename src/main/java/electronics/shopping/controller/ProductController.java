package electronics.shopping.controller;

import electronics.shopping.dto.ProductDto;
import electronics.shopping.model.Category;
import electronics.shopping.model.Product;
import electronics.shopping.repository.ProductRepository;
import electronics.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController{
    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProduct (){
        return productService.getAllProduct();
    }

    @PostMapping("/add")
    Product addProduct (@RequestBody Product product){
        return productService.addProduct(product);
    }

//    @PostMapping("/add")
//    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto product){
//        ProductDto resultProduct = productService.addProduct(product);
//        return ResponseEntity.ok(resultProduct);
//    }


//    @PostMapping("add")
//    ProductDto addProduct (@RequestBody ProductDto productDto) {
//        return productService.addProductDto(productDto);
//    }

//       Product product = new Product();
//       productService.addProduct(product);
//       List<ProductDto> productDtoList = new ArrayList<>();
//       productDtoList.add(productService.product.conver);
//        return productService.addProductDto(productDto);

/*
    ProductDto productDto = new ProductDto();
    productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
  */

    @GetMapping("{id}")
    ProductDto getById(@PathVariable long id) {
        return productService.getProductById(id);
    }
}

//@RestController
//public class ProductController {
//    @Autowired
//    private ProductService productService;
//
//    @GetMapping(value = "/products")
//    public ResponseEntity<List<Product>> getAllProduct() {
//        List<Product> products = productService.getAllProduct();
//        if (!products.isEmpty()) {
//            return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
//        }
//        return new ResponseEntity<List<Product>>(products, HttpStatus.NOT_FOUND);
//    }

//    @GetMapping(value = "/products", params = "id")
//    List<Product> products = productService.getAllProductsByCategoryId(id);

//
//    @PostMapping("/product/{product_id}")
//    Product electronicsToProduct(@PathVariable Long productId) {
//        Product product = productService.getByProductId(productId);
//        return productService.addProduct(product);
//    }
//}

//    @GetMapping("/product")
//    public List<Product> retrieveAllCategories(@PathVariable int id) {
//        Optional<Category> categoryOptional = categoryService.getCategoryById(id);
//        return categoryOp
//    }
//    @GetMapping("/products")
//    public List<Product> getProduct(){
//        return productService.getAllProduct();
//    }
//
//    @GetMapping("/category/{id}/product")
//    public List<Product> retrieveAllCategories(@PathVariable int id) {
//        Optional<Category> categoryOptional = categoryService.getCategoryById(id);
//        return categoryOptional.get().getProduct();
//    }
//
//    @PostMapping("/category/{id}/product")
//    public ResponseEntity<Object> createProduct(@PathVariable int id, @RequestBody ProductDto productDto) {
//        Optional<Category> categoryOptional = categoryService.getCategoryById(id);
//        Category category = categoryOptional.get();
//        Product product = new Product();
//
//        product.setCategory(category);
//        productService.addProduct(product);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                .buildAndExpand(product.getProductId()).toUri();
//        return ResponseEntity.created(location).build();
//    }

//    @PostMapping("/product/add")
//    public ResponseEntity<Product>  addProduct(@RequestBody ProductDto productDto) {
//     Optional <Category> categoryOptional = categoryService.getCategoryById(productDto.getCategoryId());
//
//        return new ResponseEntity<>();
//
//
//        }
//    @PostMapping("/products/add")
//    public String addProduct(@ModelAttribute ("productDTO")ProductDto productDto){
//        Product product = new Product();
//        product.setId(productDto.getId());
//        product.setName(productDto.getName());
//        product.setCategory(categoryService.getCategoryById(productDto.getCategoryId()).get());
//        product.setPrice(productDto.getPrice());
//        product.setProductId(productDto.getProductId());
//        product.setDescription(productDto.getDescription());
//        productService.addProduct(product);
//        return "redirect:/products";
//    }

