package demo.json.services;

import com.google.gson.Gson;
import demo.json.domain.DTOs.categories.CategoryImportWrapperDTO;
import demo.json.domain.DTOs.products.ProductImportDTO;
import demo.json.domain.DTOs.products.ProductImportWrapperDTO;
import demo.json.domain.DTOs.users.UserImportDTO;
import demo.json.domain.DTOs.categories.CategoryImportDto;
import demo.json.domain.DTOs.users.UsersImportWrapperDTO;
import demo.json.domain.entities.Category;
import demo.json.domain.entities.Product;
import demo.json.domain.entities.User;
import demo.json.repositories.CategoryRepository;
import demo.json.repositories.ProductRepository;
import demo.json.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.IntStream;

import static demo.json.constants.Paths.*;

@Service
public class SeedServiceImpl implements SeedService {

    private final Gson gson;

    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    private final CategoryRepository categoryRepository;

    private final ProductRepository productRepository;

    @Autowired
    public SeedServiceImpl(Gson gson, ModelMapper modelMapper, UserRepository userRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void seedUsers() throws IOException, JAXBException {
        if (this.userRepository.count() == 0) {
            final FileReader fileReader = new FileReader(USER_XML_PATH.toFile());

          /*  List<User> users =
                    Arrays.stream(gson.fromJson(fileReader, UserImportDTO[].class))
                            .map(u -> modelMapper.map(u, User.class)).toList();

           */

            JAXBContext userContext = JAXBContext.newInstance(UsersImportWrapperDTO.class);
            Unmarshaller unmarshaller = userContext.createUnmarshaller();


            UsersImportWrapperDTO usersDto = (UsersImportWrapperDTO) unmarshaller.unmarshal(fileReader);

            List<User> users = usersDto.getUsers()
                    .stream()
                    .map(u -> modelMapper.map(u, User.class))
                    .toList();

            this.userRepository.saveAllAndFlush(users);

            fileReader.close();
        }
    }

    @Override
    public void seedCategories() throws IOException, JAXBException {
        if (this.categoryRepository.count() == 0) {
            final FileReader fileReader = new FileReader(CATEGORIES_XML_PATH.toFile());

            /*List<Category> categories = Arrays.stream(gson.fromJson(fileReader, CategoryImportDto[].class))
                    .map(c -> modelMapper.map(c, Category.class))
                    .toList();*/

            JAXBContext context = JAXBContext.newInstance(CategoryImportWrapperDTO.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            CategoryImportWrapperDTO unmarshal = (CategoryImportWrapperDTO) unmarshaller.unmarshal(fileReader);

            List<Category> categories = unmarshal.getCategories().stream().map(c -> modelMapper.map(c, Category.class)).toList();

            this.categoryRepository.saveAllAndFlush(categories);
            fileReader.close();
        }

    }

    @Override
    public void seedProducts() throws IOException, JAXBException {
        if (productRepository.count() == 0) {
            FileReader fileReader = new FileReader(PRODUCTS_XML_PATH.toFile());

            /*List<Product> products = Arrays.stream(gson.fromJson(fileReader, ProductImportDTO[].class))
                    .map(p -> modelMapper.map(p, Product.class))
                    .map(this::setRandomSeller)
                    .map(this::setRandomBuyer)
                    .map(this::setRandomCategories)
                    .toList();*/

            JAXBContext context = JAXBContext.newInstance(ProductImportWrapperDTO.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            ProductImportWrapperDTO unmarshal = (ProductImportWrapperDTO) unmarshaller.unmarshal(fileReader);

            List<Product> products = unmarshal.getProducts()
                    .stream()
                    .map(p -> modelMapper.map(p, Product.class))
                    .map(this::setRandomSeller)
                    .map(this::setRandomBuyer)
                    .map(this::setRandomCategories)
                    .toList();

            this.productRepository.saveAllAndFlush(products);
            fileReader.close();
        }

    }

    private Product setRandomCategories(Product product) {

        Random random = new Random();

        int numberCategories = random.nextInt((int) this.categoryRepository.count());

        Set<Category> categories = new HashSet<>();

        IntStream.range(0, numberCategories).
                forEach(number -> {
                    Category category = this.categoryRepository.getRandomEntity()
                            .orElseThrow();
                    categories.add(category);
                });

        product.setCategories(categories);

        return product;
    }

    private Product setRandomBuyer(Product product) {
        if (product.getPrice().compareTo(BigDecimal.valueOf(700L)) > 0) {

            User buyer = userRepository.getRandomEntity().orElseThrow();

            while (buyer.equals(product.getSeller())) {
                buyer = userRepository.getRandomEntity().orElseThrow();
            }

            product.setBuyer(buyer);
        }

        return product;
    }

    private Product setRandomSeller(Product product) {
        User seller = userRepository.getRandomEntity().orElseThrow();
        product.setSeller(seller);
        return product;
    }
}
