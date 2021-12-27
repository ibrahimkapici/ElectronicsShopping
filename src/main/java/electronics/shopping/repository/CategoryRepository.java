package electronics.shopping.repository;

import electronics.shopping.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.PublicKey;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


}
