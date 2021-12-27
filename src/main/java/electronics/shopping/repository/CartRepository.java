package electronics.shopping.repository;

import electronics.shopping.dto.CartDto;
import electronics.shopping.model.Cart;
import electronics.shopping.model.Entries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}

