package electronics.shopping.controller;

import electronics.shopping.model.Cart;
import electronics.shopping.model.Entries;
import electronics.shopping.service.CartService;
import electronics.shopping.service.EntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class EntriesController {
    @RestController
    @RequestMapping("entry")
    public class CartController {
        @Autowired
        CartService cartService;
        EntriesService entriesService;

        @PostMapping
        @RequestMapping
        public Entries addCart(@RequestBody Entries entries) {
            return entriesService.save(entries);
        }
    }
}

