package txu.shop.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import txu.shop.base.BaseApi;
import txu.shop.dto.PlaceOrderRequest;
import txu.shop.dto.*;
import txu.shop.entity.OrderEntity;
import txu.shop.entity.OrderItemEntity;
import txu.shop.service.OrderItemsService;
import txu.shop.service.OrderService;

import java.util.Date;
import java.util.List;
//@CrossOrigin(origins = "https://main.d229jj886cbsbs.amplifyapp.com", allowedHeaders = "*")
//@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = "*")

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderApi  extends BaseApi {

    private final OrderService orderService;
    private final OrderItemsService orderItemsService;

    @CrossOrigin(origins = "*")
    @GetMapping("/{userId}/{from}/{to}/{isAllOrder}")
    public List<OrderEntity> getByUserId(@PathVariable String userId, @PathVariable Date from, @PathVariable Date to,@PathVariable boolean isAllOrder){
        return orderService.getByUserId(userId,from,to, isAllOrder);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/statistical/{from}/{to}")
    public List<StatisticalDTO> statistical(@PathVariable Date from, @PathVariable Date to){
        return orderService.statistical( from,  to);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/items/{orderId}")
    public List<OrderItemEntity> getOrderItems(@PathVariable String orderId){
        return orderService.getOrderItems(orderId);
    }

    @CrossOrigin(origins = "*")
    @PostMapping()
    public OrderEntity placeOrder(@RequestBody PlaceOrderRequest placeOrderRequest){
        return orderService.placeOrder(placeOrderRequest.getUsername(), placeOrderRequest.getNote());
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/note")
    public void updateNote(@RequestBody UpdateNoteRequest updateNoteRequest){
        orderService.updateNote(updateNoteRequest.getOrderId(), updateNoteRequest.getNote());
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/paided")
    public void updatePaided(@RequestBody UpdatePaidedRequest updatePaidedRequest){
        orderService.updatePaided(updatePaidedRequest.getOrderId(), updatePaidedRequest.getPaided());
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/delivered")
    public void updateDelivered(@RequestBody UpdateDeliveredRequest updateDeliveredRequest){
        orderService.updateDelivered(updateDeliveredRequest.getOrderId(), updateDeliveredRequest.getDelivered());
    }

    @CrossOrigin(origins = "*")
    @PutMapping()
    public void updateOrder(@RequestBody UpdateOrderRequest updateOrderRequest){
        orderService.updateOrder(updateOrderRequest.getOrderId(), updateOrderRequest.getUsername());
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping
    public void deleteOrder(@RequestBody DeleteOrderRequest deleteOrderRequest){
        orderService.deleteOrder(deleteOrderRequest.getOrderId());
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/item/{orderId}/{productId}")
    public void removeOrderItem(@PathVariable String orderId, @PathVariable String productId){
        orderItemsService.removeByOrderIdProductId(orderId, productId);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "item/update-quantity", consumes = "application/json")
    public OrderItemEntity updateQuantity(@RequestBody UpdateQuantityOrderItemRequest updateQuantityOrderItemRequest){
        return orderItemsService.updateQuantity(updateQuantityOrderItemRequest.getOrderId(),
                updateQuantityOrderItemRequest.getProductId(), updateQuantityOrderItemRequest.getQuantity());
    }

}
