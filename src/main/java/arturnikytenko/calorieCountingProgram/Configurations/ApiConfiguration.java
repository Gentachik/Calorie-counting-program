package arturnikytenko.calorieCountingProgram.Configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ApiConfiguration {
    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Calorie counting program");

        Contact myContact = new Contact();
        myContact.setName("Artur Nikytenko");
        myContact.setEmail("arturnikytenko@gmail.com");

        Info information = new Info()
                .title("Food API")
                .version("1.0")
                .description("This API exposes endpoints to manage food endpoints.")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }
}
