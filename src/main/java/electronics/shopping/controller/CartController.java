package electronics.shopping.controller;

import electronics.shopping.dto.CartDto;
import electronics.shopping.model.Cart;
import electronics.shopping.service.CartService;
import electronics.shopping.service.EntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
public class CartController {
    private final CartService cartService;
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @Autowired
    EntriesService entriesService;

//    @PostMapping
//    @RequestMapping("/add")
//    public CartDto createCart(CartDto cartDto){
//        return cartService.createCart(cartDto);
//    }
    @PostMapping
    @RequestMapping("/add")
    public Cart createCart(@RequestBody Cart cart){
        return cartService.createCart(cart);
    }

    @GetMapping
    @RequestMapping("{id}")
    public CartDto addCart(@PathVariable long id) {
        return cartService.findById(id);
    }

    @PostMapping
    @RequestMapping("{id}/products/{productId}/{count}")
    public Cart addProductToCart(@PathVariable long id,@PathVariable long productId, @PathVariable int count) {
        return cartService.addProductToCart(id, productId, count);
    }

//    @PostMapping
//    @RequestMapping("{id}")
//    public Cart addCart1(@RequestBody Cart cart) {
//        return cartService.createCart(cart);
//    }

}
