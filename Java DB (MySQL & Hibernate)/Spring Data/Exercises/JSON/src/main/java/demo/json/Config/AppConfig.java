package demo.json.Config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public ModelMapper createModelMapper(){
        return new ModelMapper();
    }

    @Bean
    public Gson createGson(){
        return new GsonBuilder().setPrettyPrinting().create();
    }

}
