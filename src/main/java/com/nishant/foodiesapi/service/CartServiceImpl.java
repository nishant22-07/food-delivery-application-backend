package com.nishant.foodiesapi.service;


import com.nishant.foodiesapi.IO.CartRequest;
import com.nishant.foodiesapi.IO.CartResponse;
import com.nishant.foodiesapi.entity.CartEntity;
import com.nishant.foodiesapi.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserService userService;

    @Override
    public CartResponse addToCart(CartRequest request) {
        String loggedInUserId = userService.findByUserId();
        Optional<CartEntity> cartOptional = cartRepository.findByUserId(loggedInUserId);
        CartEntity  cart = cartOptional.orElseGet(()-> new CartEntity(loggedInUserId,new HashMap<>()));
        Map<String, Integer> cartItems =  cart.getItems();
        cartItems.put(request.getFoodId(), cartItems.getOrDefault(request.getFoodId(),0)+1);
        cart.setItems(cartItems);
        cart = cartRepository.save(cart);
        return convertToResponse(cart);



    }

    private CartResponse convertToResponse(CartEntity cartEntity) {
        return CartResponse.builder()
                .items(cartEntity.getItems())
                .userId(cartEntity.getUserId())
                .id(cartEntity.getId())
                .build();
    }

    @Override
    public CartResponse getCart(){
        String loggedInUserId = userService.findByUserId();
        CartEntity entity = cartRepository.findByUserId(loggedInUserId).orElse(new CartEntity(null,loggedInUserId,new HashMap<>()));
        return convertToResponse(entity);


    }

    @Override
    public void clearCart() {
        String loggedInUserId = userService.findByUserId();
        cartRepository.deleteByUserId(loggedInUserId);

    }

    @Override
    public CartResponse removeFromCart(CartRequest request) {
        String loggedInUserId = userService.findByUserId();
        Optional<CartEntity> cartOptional = cartRepository.findByUserId(loggedInUserId);
        CartEntity cart = cartOptional.orElseThrow(() -> new RuntimeException("Cart is not found"));
        Map<String, Integer> cartItems = cart.getItems();
        String foodId = request.getFoodId();
        int quantity = cartItems.getOrDefault(foodId, 0);

        if(quantity > 1){
            cartItems.put(foodId, quantity - 1);
        } else {
            cartItems.remove(foodId);
        }

        cart.setItems(cartItems);
        cart = cartRepository.save(cart);
        return convertToResponse(cart);
    }


}
