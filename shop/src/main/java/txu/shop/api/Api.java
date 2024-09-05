package txu.shop.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class Api {
    @Value("${spring.datasource.url}")
    private String url_db;
    @GetMapping("/health-check")
    public String healthcheck(){
        return "tung" ;
    }
}
