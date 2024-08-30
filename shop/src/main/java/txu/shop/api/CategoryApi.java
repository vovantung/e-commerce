package txu.shop.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import txu.shop.entity.CategoryEntity;
import txu.shop.service.CategoryService;

import java.util.List;
//@CrossOrigin(origins = "https://main.d229jj886cbsbs.amplifyapp.com", allowedHeaders = "*")
//@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = "*")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
@CrossOrigin(origins = "*")
public class CategoryApi {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryEntity> getAll(){
        return categoryService.getAll();
    }


}
