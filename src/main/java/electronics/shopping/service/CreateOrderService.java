package electronics.shopping.service;

import electronics.shopping.model.CreateOrder;
import electronics.shopping.repository.CreateOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderService {

    private final CreateOrderRepository createOrderRepository;

    public CreateOrderService(CreateOrderRepository createOrderRepository) {
        this.createOrderRepository = createOrderRepository;
    }
    public CreateOrder create(CreateOrder createOrder){
       return createOrderRepository.save(createOrder);
    }
}
