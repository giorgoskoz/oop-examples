package org.afdemp.cb6.ex01;

import java.util.List;
import java.util.ArrayList;

public class Cart {
    
    private List<Product> products;
    private User owner;

    public Cart(User owner) {
        this.owner = owner;
        products   = new ArrayList<Product>();
    }

    public void add(Product p) {
        products.add(p);
    }

    public void remove(Product p) {
        products.remove(p);
    }
    
    public void setUser(User owner) {
        this.owner = owner;
    }

    public double getTotal() {
        if (owner instanceof UserUnderLoyalty) {
            double sum = 0.0;
        for (Product p : products) {
            sum += p.getPrice();
        }
        sum -= sum * ((UserUnderLoyalty)owner).getDiscount();
        return sum;
        }
        
        double sum = 0.0;
        for (Product p : products) {
            sum += p.getPrice();
        }
        return sum;
    }

    public void checkout() {
        double total = getTotal();
        owner.withdraw(total);
        products.clear();
    }
}
