package txu.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import txu.common.grpc.GrpcServer;
import txu.shop.grpc.ShopGrpcService;
import java.io.IOException;

@SpringBootApplication
public class ShopApplication {
	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(ShopApplication.class);
//		GrpcServer.start(ShopApplication.class, ShopGrpcService.class);
	}
}
