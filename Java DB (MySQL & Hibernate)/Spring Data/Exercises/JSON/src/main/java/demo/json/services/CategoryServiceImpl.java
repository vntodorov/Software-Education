package demo.json.services;

import demo.json.domain.DTOs.categories.CategoryProductSummaryDTO;
import demo.json.domain.DTOs.categories.CategoryProductSummaryWrapperDTO;
import demo.json.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

import static demo.json.constants.Paths.CATEGORIES_BY_PRODUCTS;
import static demo.json.constants.Paths.CATEGORIES_BY_PRODUCTS_XML;
import static demo.json.constants.Utils.writeJsonIntoFile;
import static demo.json.constants.Utils.writeXmlIntoFile;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryProductSummaryDTO> getCategorySummary() throws IOException, JAXBException {
        List<CategoryProductSummaryDTO> categoryProductSummaryDTOS = this.categoryRepository.getCategorySummary().orElseThrow();

        CategoryProductSummaryWrapperDTO categoryProductSummaryWrapperDTO = new CategoryProductSummaryWrapperDTO(categoryProductSummaryDTOS);

        writeXmlIntoFile(categoryProductSummaryWrapperDTO, CATEGORIES_BY_PRODUCTS_XML);

        writeJsonIntoFile(categoryProductSummaryDTOS, CATEGORIES_BY_PRODUCTS);

        return categoryProductSummaryDTOS;
    }
}
