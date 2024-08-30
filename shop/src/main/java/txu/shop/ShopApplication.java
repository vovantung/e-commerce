package txu.shop;

import com.amazonaws.HttpMethod;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import txu.common.grpc.GrpcServer;
import txu.shop.grpc.ShopGrpcService;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

@SpringBootApplication
public class ShopApplication {
	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(ShopApplication.class);
//		GrpcServer.start(ShopApplication.class, ShopGrpcService.class);
	}

//	@Bean
//	public CorsFilter corsFilter() {
//		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		final CorsConfiguration config = new CorsConfiguration();
//		config.setAllowCredentials(true);
//		config.setAllowedOrigins(Collections.singletonList("*"));
//		config.setAllowedHeaders(Collections.singletonList("*"));
//		config.setAllowedMethods(Arrays.stream(HttpMethod.values()).map(HttpMethod::name).collect(Collectors.toList()));
//		source.registerCorsConfiguration("/**", config);
//		return new CorsFilter(source);
//	}
}
