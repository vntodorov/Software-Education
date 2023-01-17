package demo.json.services;

import demo.json.domain.DTOs.categories.CategoryProductSummaryDTO;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface CategoryService {
    List<CategoryProductSummaryDTO> getCategorySummary() throws IOException, JAXBException;
}
