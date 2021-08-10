package impl;

import domain.Cart;
import domain.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.CartService;

import java.util.ArrayList;

@Service
public class CardServiceImpl implements CartService {

    private ProductServiceImpl productService;

    public CardServiceImpl(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @Override
    public Cart takeCart(@Qualifier("clientCart") Cart cart) {
        return cart;
    }

    @Override
    public Cart insertProductToCart(long id, Cart cart) {
        ArrayList list;
        if (productService.isId(id)) {
            Product clientProduct = productService.findById(id);
            int costClientProduct = clientProduct.getCost();
            list = cart.getClientCart();
            list.add(clientProduct);
            int total = cart.getTotalCost() + costClientProduct;
            cart.setTotalCost(total);
            cart.setClientCart(list);
        }
        return cart;
    }

    @Override
    public Cart removeProductFromCart(long removeId, Cart cart) {
        if (productService.isId(removeId)) {
            ArrayList list = cart.getClientCart();
            cart.getClientCart().stream().forEach(x -> {
                long id = x.getId();
                if (id == removeId) list.remove(x);
                int total = cart.getTotalCost()-x.getCost();
                cart.setTotalCost(total);
            });
            cart.setClientCart(list);
        }
        return cart;
    }

    @Override
    public void eraseCart(Cart cart) {
        cart = null;
    }
}
