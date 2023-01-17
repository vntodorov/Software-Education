package demo.json;

import demo.json.services.CategoryService;
import demo.json.services.ProductService;
import demo.json.services.SeedService;
import demo.json.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CommandRunner implements CommandLineRunner {

    private final ProductService productService;

    private final UserService userService;
    private final CategoryService categoryService;


    private final SeedService seedService;

    @Autowired
    public CommandRunner(ProductService productService, UserService userService, CategoryService categoryService, SeedService seedService) {
        this.productService = productService;
        this.userService = userService;
        this.categoryService = categoryService;
        this.seedService = seedService;
    }


    @Override
    public void run(String... args) throws Exception {
        //this.seedService.seedAll();
        //this.productService.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));
        //this.userService.findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerFirstName();
        //this.categoryService.getCategorySummary();
        this.userService.usersAndProducts();
    }
}
