import java.util.ArrayList;

public abstract class Burger {
    private String name;
    private Double price;
    private int maxToppings;
    private ArrayList<Topping> toppings = new ArrayList<>();


    Burger(String name, Double price, int maxToppings){
        this.name = name + " Burger";
        this.price = price;
        this.maxToppings = maxToppings;
    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    public int getMaxToppings() {
        return this.maxToppings;
    }

    public ArrayList<Topping> getToppings()
    {
        return this.toppings;
    }

    public void setToppings(Topping topping)
    {
        this.toppings.add(topping);
    }

    @Override
    public String toString() {
        return String.format("%s\nCost: $%.2f\nMaximum toppings:%d",this.name,this.price,this.maxToppings);
    }
}
