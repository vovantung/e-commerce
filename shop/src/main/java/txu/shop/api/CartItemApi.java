package txu.shop.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import txu.shop.base.BaseApi;
import txu.shop.dto.CartDto;
import txu.shop.dto.CartItemDto;
import txu.shop.entity.CartItemEntity;
import txu.shop.service.CartItemService;
//import txu.shop.util.BaseApi;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
//@CrossOrigin(origins = "https://main.d229jj886cbsbs.amplifyapp.com", allowedHeaders = "*")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = "*")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/cartitem")
public class CartItemApi extends BaseApi {

    private final CartItemService cartItemService;

    @CrossOrigin(origins = "*")
    @PostMapping(consumes = "application/json")
    public CartItemEntity create(@RequestBody CartItemDto cartItemDto){
        return cartItemService.create(cartItemDto);
    }

    @CrossOrigin(origins = "*")
    @GetMapping()
    public CartItemEntity getByUserIdProductId(String userId, String productId){
        return cartItemService.getByUerIdProductId(userId, productId);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{userId}")
    public List<CartItemEntity> getByUserId(@PathVariable String userId){
         return cartItemService.getByUerId(userId);

    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("{userId}")
    public int deleteByUserId(@PathVariable String userId){
       return cartItemService.deleteByUserId(userId);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{userId}/{productId}")
    public int deleteByUserIdAndProductId(@PathVariable String userId, @PathVariable String productId){
         return cartItemService.deleteByUserIdAndProductId(userId, productId);
    }


    @CrossOrigin(origins = "*")
    @PostMapping(value = "/update-quantity", consumes = "application/json")
    public CartItemEntity updateQuantity(@RequestBody CartDto cartDto){
        return cartItemService.updateQuantity(cartDto.getUserId(), cartDto.getProductId(), cartDto.getQuantity());
    }
//
//    @PostMapping(value = "/quantity-minus", consumes = "application/json")
//    public CartItemEntity quantityMinus(@RequestBody CartDto cartDto){
//        return cartItemService.quantityMinus(cartDto.getId());
//    }
}
