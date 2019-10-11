package guru.mahesh.swaggeraddressbook;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableSwagger2
public class SwaggerAddressbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerAddressbookApplication.class, args);
	}
	

	@Bean
	public Docket swaggerconfigueration()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("guru.mahesh"))
				.build()
				.apiInfo(apidetails());
	}

	private ApiInfo apidetails()
	{
		return new ApiInfo("Address Store API","Mahesh Tryout API","1.0.0","Open use",new springfox.documentation.service.Contact("Mahesh","helloworld.in", "man@man.in"),"API","helloworld.in",Collections.emptyList());
	}
	
}
