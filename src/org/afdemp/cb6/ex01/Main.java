package org.afdemp.cb6.ex01;

public class Main {

    public static void main(String[] args) {
        User user = new User("username", "Name", "Surname");
        Cart cart = new Cart(user);
        cart.add(new Product("P001", "Mouse",    12.00));
        cart.add(new Product("P002", "Keyboard", 14.00));
        System.out.println(user.getId() + " " + user.getName() + " " + user.getSurname());
        System.out.println("Total = " + cart.getTotal());
        
        user = new UserUnderLoyalty(user, 100);
        //how to update currently existing cart with updated UserUnderLoyalty user so the next 3 lines are not needed??
        cart.setUser(user);
//        cart.add(new Product("P001", "Mouse",    12.00));
//        cart.add(new Product("P002", "Keyboard", 14.00));
        System.out.println(user.getId() + " " + user.getName() + " " + user.getSurname());
        System.out.println("Total = " + cart.getTotal());
        
        User user1 = new UserUnderLoyalty("username1", "Name1", "Surname1", 200);
        Cart cart1 = new Cart(user1);
        cart1.add(new Product("P001", "Mouse",    12.00));
        cart1.add(new Product("P002", "Keyboard", 14.00));
        System.out.println(user1.getId() + " " + user1.getName() + " " + user1.getSurname());
        System.out.println("Total = " + cart1.getTotal());
    }

}
