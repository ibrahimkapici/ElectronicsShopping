package electronics.shopping.service;


import electronics.shopping.model.Category;
import electronics.shopping.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    public  CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    public List<Category> getAllCategory(Category category){
        return categoryRepository.findAll();
    }
    public Category addCategory (Category category){
        return categoryRepository.save(category);
    }
    public Optional<Category> getCategoryById(long id){
        return categoryRepository.findById(id);
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }
}
