package electronics.shopping.repository;

import electronics.shopping.dto.ProductDto;
import electronics.shopping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
   List<ProductDto> findAllByCategory_Id(long id);
   ProductDto save (ProductDto product);
   Product save(Product product);
   Optional<Product> findById(long id);
}
