package demo.json.constants;

import com.google.gson.Gson;
import demo.json.domain.DTOs.products.ProductInRangeWithNoBuyerWrapperDTO;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

import static demo.json.constants.Paths.PRODUCTS_WITH_NO_BUYERS_IN_RANGE;
import static demo.json.constants.Paths.PRODUCTS_WITH_NO_BUYERS_IN_RANGE_XML;

public enum Utils {
    ;

    public static void writeJsonIntoFile(List<?> objects, Path filePath) throws IOException {
        Gson gson = new Gson();

        FileWriter fileWriter = new FileWriter(filePath.toFile());

        gson.toJson(objects, fileWriter);

        fileWriter.flush();
        fileWriter.close();

    }

    public static <T> void writeJsonIntoFile(T object, Path filePath) throws IOException {
        Gson gson = new Gson();

        FileWriter fileWriter = new FileWriter(filePath.toFile());

        gson.toJson(object, fileWriter);

        fileWriter.flush();
        fileWriter.close();

    }

    public static <T> void writeXmlIntoFile(T object, Path filePath) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(object.getClass());

        Marshaller marshaller = context.createMarshaller();

        marshaller.marshal(object, filePath.toFile());
    }
}
