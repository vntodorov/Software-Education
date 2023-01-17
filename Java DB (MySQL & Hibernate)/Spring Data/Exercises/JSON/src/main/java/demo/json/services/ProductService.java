package demo.json.services;

import demo.json.domain.DTOs.products.ProductInRangeWithNoBuyerDTO;
import demo.json.domain.DTOs.products.ProductInRangeWithNoBuyerWrapperDTO;
import demo.json.domain.entities.Product;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductInRangeWithNoBuyerDTO> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal low, BigDecimal high) throws IOException, JAXBException;

}
