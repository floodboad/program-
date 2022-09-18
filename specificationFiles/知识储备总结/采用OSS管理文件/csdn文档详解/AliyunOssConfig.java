/**
 * @Auther: csp1999
 * @Date: 2020/10/31/13:33
 * @Description: 阿里云 OSS 基本配置
 */
// 声明配置类，放入Spring容器
@Configuration
// 指定配置文件位置
@PropertySource(value = {"classpath:application-aliyun-oss.properties"})
// 指定配置文件中自定义属性前缀
@ConfigurationProperties(prefix = "aliyun")
@Data// lombok
@Accessors(chain = true)// 开启链式调用
public class AliyunOssConfig {
 private String endPoint;// 地域节点
 private String accessKeyId;
 private String accessKeySecret;
 private String bucketName;// OSS的Bucket名称
 private String urlPrefix;// Bucket 域名
 private String fileHost;// 目标文件夹
 
 // 将OSS 客户端交给Spring容器托管
 @Bean
 public OSS OSSClient() {
 return new OSSClient(endPoint, accessKeyId, accessKeySecret);
 }
}