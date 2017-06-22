package CarTracker.egen.io;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2)
//					.pathMapping("/api")
//					.useDefaultResponseMessages(false)
//					.select()
//					.apis(RequestHandlerSelectors.any())
//					.paths(PathSelectors.any())
//					.build()
//					.apiInfo(apiInfo());
//	}
//
//	private ApiInfo apiInfo() {
//		Contact contact = new Contact("admin", "https://egen.io", "developer@egen.io");
//		ApiInfo info = new ApiInfo("Spring-REST API", "A simple REST API", "1.0.0", "TnC", contact, "MIT",
//				"https://opensource.org/licenses/MIT");
//		return info;
//	}
}
