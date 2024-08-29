package txu.common.grpc;
import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import java.io.IOException;
public class GrpcServer {
    public static void start(Class springApplication, Class grpcService) throws IOException, InterruptedException {
        ApplicationContext context = SpringApplication.run(springApplication);

        GrpcConfig grpcConfig = context.getBean(GrpcConfig.class);
        BindableService grpc = (BindableService) context.getBean(grpcService);

        Server server = ServerBuilder.forPort(grpcConfig.getGrpcPort()).addService(grpc).intercept(new  GrpcExceptionHandler()).build();

        System.out.println("Starting grpc server...");
        server.start();
        System.out.println("Grpc server started in port "  + grpcConfig.getGrpcPort());
        server.awaitTermination();
    }
}
