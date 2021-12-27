package electronics.shopping.controller;

import electronics.shopping.dto.ProductDto;
import electronics.shopping.model.Category;
import electronics.shopping.model.Product;
import electronics.shopping.service.CategoryService;
import electronics.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    ProductService productService;

    @GetMapping
    public List<Category> getAllCategory (){
        return categoryService.getAllCategory();
    }

    @PostMapping("/add")
    Category addCategory (@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @GetMapping("{id}")
     Optional<Category> getById(@PathVariable int id) throws Exception {
        Optional<Category> categoryOptional = categoryService.getCategoryById(id);
        if (categoryOptional.isEmpty()) {
            throw new Exception("Invalid CategoryId");
        }
        return categoryOptional;
    }





//    @GetMapping("/category")
//    public String getCat(){
//        return "category";
//    }
//    @GetMapping("/categories/add")
//    public String getCatAdd(Model model){
//        model.addAttribute("category", new Category());
//        return ;
//    }
//    @PostMapping("/categories/add")
//    public String postCatAdd(@ModelAttribute("category") Category category){
//        categeroyService.addCategory(category);
//        return "redirect:/categories/add";
//    }

}
