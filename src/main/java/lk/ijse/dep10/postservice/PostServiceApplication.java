package lk.ijse.dep10.postservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PostServiceApplication {

    @Bean
	public ModelMapper modelMapper(){ return new ModelMapper();}

    public static void main(String[] args) {
        SpringApplication.run(PostServiceApplication.class, args);
    }
}
