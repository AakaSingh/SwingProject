import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {


    private static Scanner input;
    private static ArrayList<Burger> fridge = new ArrayList<>();

    public Restaurant()
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new MainFrame();
            }
        });
        this.prepareBurger();

    }

    public static ArrayList<Burger> sendBurgers()
    {
        return fridge;
    }

    public void prepareBurger()
    {
        Topping tomato  = new Topping("Tomato",0.6);
        Topping cheese  = new Topping("Cheese",1.2);
        Topping carrot  = new Topping("Carrot",1.1);
        Topping lettuce  = new Topping("Lettuce",0.8);
        Topping bacon = new Topping("Bacon",2.0);
        Topping olives  = new Topping("Olives",1.6);

        Burger bBurger = new BasicBurger("Basic",5.4,4);
        Burger hBurger = new HealthyBurger("Healthy",6.5,6);
        Burger dBurger = new DeluxeBurger("Deluxe",8.0,2);

        bBurger.setToppings(tomato);
        bBurger.setToppings(cheese);
        bBurger.setToppings(carrot);
        bBurger.setToppings(lettuce);

        hBurger.setToppings(tomato);
        hBurger.setToppings(cheese);
        hBurger.setToppings(carrot);
        hBurger.setToppings(lettuce);
        hBurger.setToppings(bacon);
        hBurger.setToppings(olives);

        dBurger.setToppings(tomato);
        dBurger.setToppings(olives);

        this.fridge.add(bBurger);
        this.fridge.add(hBurger);
        this.fridge.add(dBurger);

    }

}
