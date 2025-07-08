package bg.softuni._15_springmapping.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class Config {

    @Bean
    public ModelMapper createModelMapper() {
        // addMapping
//        Converter<LocalDate, String> conv = new Converter<LocalDate, String>() {
//            @Override
//            public String convert(MappingContext<LocalDate, String> context) {
//                return null;
//            }
//        }

//        Converter<LocalDate, String> conv = context -> null;

        return new ModelMapper();
    }
}
