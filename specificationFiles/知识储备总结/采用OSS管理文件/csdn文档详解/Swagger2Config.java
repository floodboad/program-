/**
 * @Auther: csp1999
 * @Date: 2020/10/31/16:30
 * @Description: Swagger 配置类
 */
@Configuration
@EnableSwagger2// 开启swagger2
public class Swagger2Config {
 
 @Bean
 public Docket webApiConfig() {
 
 return new Docket(DocumentationType.SWAGGER_2)
 .groupName("webApi")
 .apiInfo(webApiInfo())
 .select()
 .paths(Predicates.not(PathSelectors.regex("/error.*")))
 .build();
 }
 
 private ApiInfo webApiInfo() {
 return new ApiInfoBuilder()
 .title("SpringBoot整合OSS-API文档")
 .description("阿里云OSS-文件上传下载测试")
 .version("1.0")
 .contact(new Contact("CSP", "https://blog.csdn.net/weixin_43591980", ""))
 .build();
 }
}