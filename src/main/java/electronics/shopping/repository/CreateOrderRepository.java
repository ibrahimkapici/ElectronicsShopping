package electronics.shopping.repository;

import electronics.shopping.model.CreateOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreateOrderRepository extends JpaRepository<CreateOrder, Long> {

}
