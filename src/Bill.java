import java.util.ArrayList;

public class Bill {


    private Burger burger;
    private String burgerName;
    private double burgerPrice;
    private int noOfToppings;
    private double toppingTotal;
    private double tax;
    private double finalAmount;

    public Bill(String burgerName, double burgerPrice, int noOfToppings, double toppingTotal, double tax, double finalAmount) {
        this.burgerName = burgerName;
        this.burgerPrice = burgerPrice;
        this.noOfToppings = noOfToppings;
        this.toppingTotal = toppingTotal;
        this.tax = tax;
        this.finalAmount = finalAmount;
    }

    public Bill(Burger burger)
    {
        this.burger = burger;
    }

    public String getBurgerName() {
        return burgerName;
    }

    public void setBurgerName(String burgerName) {
        this.burgerName = burgerName;
    }

    public double getBurgerPrice() {
        return burgerPrice;
    }

    public void setBurgerPrice(double burgerPrice) {
        this.burgerPrice = burgerPrice;
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
