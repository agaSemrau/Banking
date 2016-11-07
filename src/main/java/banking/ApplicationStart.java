package banking;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.Arrays;

@EnableSwagger2
@EnableAutoConfiguration
@SpringBootApplication
public class ApplicationStart {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(ApplicationStart.class, args);
    }
}
