package electronics.shopping;

import electronics.shopping.repository.CartRepository;
import electronics.shopping.repository.CategoryRepository;
import electronics.shopping.repository.EntriesRepository;
import electronics.shopping.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Bean
	public	ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private EntriesRepository entriesRepository;

	public void run(String... args) throws Exception {

	}
}
