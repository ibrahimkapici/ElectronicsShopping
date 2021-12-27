package electronics.shopping.service;

import electronics.shopping.dto.CartDto;
import electronics.shopping.model.Cart;
import electronics.shopping.model.Entries;
import electronics.shopping.model.Product;
import electronics.shopping.repository.CartRepository;
import electronics.shopping.repository.EntriesRepository;
import electronics.shopping.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static electronics.shopping.dto.CartDto.CartDtoBuilder.aCartDto;

@Service
public class CartService {
    private final CartRepository cartRepository;
    EntriesRepository entriesRepository;
    EntriesService entriesService;
    ProductService productService;
    ProductRepository productRepository;


    public CartService(CartRepository cartRepository, EntriesService entriesService, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.entriesService = entriesService;
        this.productRepository = productRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    //    public Cart addToCart(Cart cart){
//        Entries entries = new Entries();
//        entriesService.calculatePrice(entries);
//        List<Entries> entriesList = new ArrayList<>();
//        entriesList.add(entries);
//        Cart cart1 = cartRepository.save(addToCart(entries.getCart()));
//        return cart1;
//    }
    public Cart createCart(Cart cart) {
        double totalPrice = 0.;

        for (Entries entry : cart.getEntries()) {
            Product productById = productRepository.findById(entry.getProduct().getId()).orElseThrow(RuntimeException::new);
            totalPrice += productById.getPrice() * entry.getCount();
        }

        cart.setTotalPrice(totalPrice);
        return cartRepository.save(cart);
    }

//    public CartDto createCart(CartDto cartDto){
//        Cart cart = modelMapper.map(cartDto, Cart.class);
//
//        return modelMapper.map(cartRepository.save(cart), CartDto.class);
//    }
//        Cart cart = modelMapper.map(cartDto, Cart.class);
//        cart.setEntries(entriesRepository.getById());
//        cart.setTotalPrice(entriesRepository.calculatePrice().getPrice());
//        cart.setTotalPrice(entriesRepository.calculatePrice().getPrice());
//        return modelMapper.map(cartRepository.save(cart), CartDto.class);

//        List<CartDto> cartList = cartRepository.findByCartId(cartDto.getId());
//        cartList.add(cartDto);
//        cartDto.getTotalPrice();
//        cartDto.getEntries();
//        return cartRepository.save(cartDto);

//    public CartDto createCart(CartDto cartDto){
//        List<CartDto> cartList = cartRepository.findByCartId(cartDto.getId());
//        cartList.add(cartDto);
//        cartDto.getTotalPrice();
//        cartDto.getEntries();
//        return cartRepository.save(cartDto);
//    }

//    public CartDto createCart (CartDto cartDto){
//        double totalPrice = 0;
//        List<CartDto> cartDtoList = cartRepository.findByCartId(cartDto.getId());
//        cartDtoList.add(cartDto);
//        if(cartDtoList.stream().count() >0){
//            for (CartDto num : cartDtoList){
//                double myPrice = productService.getProductById(num.getId()).orElse(null).getPrice();
//                double oneProductPrice = myPrice * num.get();
//
//            }
//        }
//        Cart cart = modelMapper.map(cartDto, Cart.class);
//        cart.setId();
//        cart.setTotalPrice(entriesService.calculatePrice());
//        cart.setEntries();
//        return modelMapper.map(cartRepository.save(cart),CartDto.class);
    //}

    public List<Cart> findByAll() {
        return cartRepository.findAll();
    }

    public CartDto findById(long id) {
        Cart cart = cartRepository.findById(id).orElseThrow(RuntimeException::new);

        return aCartDto()
                .totalPrice(cart.getTotalPrice())
                .id(cart.getId())
                .entries(cart.getEntries())
                .build();
    }

    public Cart addProductToCart(long id, long productId, int count) {
        Product productById = productRepository.findById(productId).orElseThrow(RuntimeException::new);

        Cart cart = cartRepository.findById(id).orElseThrow(RuntimeException::new);

        List<Entries> entries = cart.getEntries();
        Entries entries1 = new Entries();
        entries1.setProduct(productById);
        entries1.setCount(count);
        entries.add(entries1);
        double totalPrice = cart.getTotalPrice();
        totalPrice += productById.getPrice() * count;
        cart.setTotalPrice(totalPrice);
        cartRepository.save(cart);
        return cart;
    }

    public Cart addEntries(Cart cart) {
        return cartRepository.save(cart);
    }

//    @Override
//    public Cart createCart (Cart cart){
//        List<Cart> cartList = (List<Cart>) cartRepository.getById(cart.getId());
//        cartList.add(cart);
//        return cartRepository.save(cart);
//    }
}
