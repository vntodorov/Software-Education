package demo.json.services;

import demo.json.domain.DTOs.products.ProductDTO;
import demo.json.domain.DTOs.products.ProductInRangeWithNoBuyerDTO;
import demo.json.domain.DTOs.products.ProductInRangeWithNoBuyerWrapperDTO;
import demo.json.domain.entities.Product;
import demo.json.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static demo.json.constants.Paths.PRODUCTS_WITH_NO_BUYERS_IN_RANGE;
import static demo.json.constants.Paths.PRODUCTS_WITH_NO_BUYERS_IN_RANGE_XML;
import static demo.json.constants.Utils.writeJsonIntoFile;
import static demo.json.constants.Utils.writeXmlIntoFile;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper mapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductInRangeWithNoBuyerDTO> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal low, BigDecimal high) throws IOException, JAXBException {

        List<ProductInRangeWithNoBuyerDTO> products = this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(low, high).orElseThrow()
                .stream()
                .map(product -> mapper.map(product, ProductDTO.class))
                .map(ProductDTO::toProductInRangeWithNoBuyerDto).toList();

        ProductInRangeWithNoBuyerWrapperDTO ProductInRangeWithNoBuyerWrapperDTO = new ProductInRangeWithNoBuyerWrapperDTO(products);

        writeXmlIntoFile(ProductInRangeWithNoBuyerWrapperDTO, PRODUCTS_WITH_NO_BUYERS_IN_RANGE_XML);

        writeJsonIntoFile(products, PRODUCTS_WITH_NO_BUYERS_IN_RANGE);

        return products;
    }
}
