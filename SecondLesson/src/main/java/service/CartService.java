package service;

import domain.Cart;


public interface CartService {

    public Cart takeCart(Cart cart);

    public Cart insertProductToCart(long id, Cart cart);

    public Cart removeProductFromCart(long id, Cart cart);

    public void eraseCart(Cart cart);

}

