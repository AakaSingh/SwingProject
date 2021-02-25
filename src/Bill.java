import java.util.ArrayList;

public class Bill {


    private Burger burger;
    private int noOfToppings;

    private double toppingTotal;
    private double tax;
    private double finalAmount;

    public Bill(Burger burger)
    {
        this.burger = burger;
    }

    public int getNoOfToppings() {
        return noOfToppings;
    }

    public void setNoOfToppings(int noOfToppings) {
        this.noOfToppings = noOfToppings;
    }

    public double getToppingTotal() {
        return toppingTotal;
    }

    public void setToppingTotal(double toppingTotal) {
        this.toppingTotal = toppingTotal;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public Burger getBurger()
    {
        return burger;
    }

}
