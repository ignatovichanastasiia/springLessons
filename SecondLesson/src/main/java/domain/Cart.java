package domain;


import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> clientCart;
    private int totalCost;

    public Cart() {
        this.clientCart = new ArrayList<Product>();
        this.totalCost = 0;
    }

    public ArrayList<Product> getClientCart() {
        return clientCart;
    }

    public void setClientCart(ArrayList<Product> clientCart) {
        this.clientCart = clientCart;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Cart: \n" +
                "Products: \n" + clientCart +
                "\n totalCost: \n" + totalCost + "\n";
    }
}
