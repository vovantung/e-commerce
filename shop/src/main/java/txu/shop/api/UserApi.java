package txu.shop.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import txu.shop.entity.UserEntity;
import txu.shop.service.UserSevice;
//@CrossOrigin(origins = "https://main.d229jj886cbsbs.amplifyapp.com", allowedHeaders = "*")
//@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserApi {

    private final UserSevice userSevice;

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/register")
    public UserEntity register(@RequestBody UserEntity userEntity){
        return userSevice.createUser(userEntity);
    }

//    @GetMapping
//    public UserEntity getByUsername(String username){
//        return userSevice.getByUsername(username);
//    }
}
