package electronics.shopping.controller;


import electronics.shopping.model.CreateOrder;
import electronics.shopping.service.CreateOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class CreateOrderController{
    private final CreateOrderService createOrderService;

    public CreateOrderController(CreateOrderService createOrderService) {
        this.createOrderService = createOrderService;
    }

    @PostMapping("{cartId}")
    public CreateOrder create(@RequestBody CreateOrder createOrder){
        return createOrderService.create(createOrder);
    }


}