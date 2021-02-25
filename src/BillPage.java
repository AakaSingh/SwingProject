import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BillPage extends JFrame {

public BillPage(Burger burger, ArrayList<Topping> toppings, String name, String contact)
{
    super("BILL");
    Bill billDb = new Bill(burger);
    JPanel bill = new JPanel();

    JLabel info = new JLabel("  Name: " + name + "                  Contact: "+ contact);

    add(info, BorderLayout.NORTH);
    bill.setLayout(null);
    Border inner = BorderFactory.createTitledBorder("Bill");
    Border outer = BorderFactory.createEmptyBorder(5,5,5,5);
    bill.setBorder(BorderFactory.createCompoundBorder(outer,inner));

    JLabel[] items = new JLabel[toppings.size()];
    JLabel[] prices = new JLabel[toppings.size()];

    JLabel label1 = new JLabel("Items");
    JLabel label2 = new JLabel("Prices");

    label1.setBounds(20,20, 100, 30);
    label2.setBounds(220, 20, 100, 30);

    JSeparator spt = new JSeparator();
    spt.setBounds(20,50, 250, 10);

    JLabel burgerName = new JLabel(burger.getName());
    JLabel burgerPrice = new JLabel("$" +burger.getPrice());

    burgerName.setBounds(20, 60, 100, 30);
    burgerPrice.setBounds(220, 60, 100, 30);

    JLabel addOn = new JLabel("Toppings:");
    addOn.setBounds(20, 80, 100, 30 );
    bill.add(addOn);
    int height = 0;
    if (toppings.size() == 0)
    {
        JLabel label = new JLabel("No Extras");
        label.setBounds(40, 100, 100, 30);

        JLabel topPrice = new JLabel("$0.00");
        topPrice.setBounds(220, 100, 100, 30);

        bill.add(label);
        bill.add(topPrice);
        height = 100;
    }
    else
    {
        for(int i=0; i<toppings.size(); i++)
        {
            items[i] = new JLabel(toppings.get(i).getName());
            items[i].setBounds(40, i*20+110, 100, 30);
            prices[i] = new JLabel(("$"+toppings.get(i).getPrice()));
            prices[i].setBounds(220, i*20+110, 100, 30);

            bill.add(items[i]);
            bill.add(prices[i]);
            height = i*20+110;
        }
    }

    height+=30;
    JSeparator spt1 = new JSeparator();
    spt1.setBounds(20,height, 250, 10);

    height+=10;
    Double total1 = calculateTotal(burger, toppings, billDb);
    Double tax = total1 * 0.15;
    billDb.setTax(tax);

    Double netTotal = total1 + tax;
    billDb.setFinalAmount(netTotal);

    Controller.saveTransaction(billDb);

    JLabel total = new JLabel("Amount :");
    total.setBounds(20, height, 100, 30 );
    JLabel totalPrice = new JLabel("$"+String.format("%.2f",total1));
    totalPrice.setBounds(220, height, 100, 30);

    height+=30;
    JLabel totalTax = new JLabel("Tax :");
    totalTax.setBounds(20, height, 100, 30 );
    JLabel totalTaxAmount = new JLabel("$"+String.format("%.2f",tax));
    totalTaxAmount.setBounds(220, height, 100, 30);

    height+=30;
    JLabel finalTotal = new JLabel("Total :");
    finalTotal.setBounds(20, height, 100, 30 );
    JLabel finalAmount = new JLabel("$"+String.format("%.2f",netTotal));
    finalAmount.setBounds(220, height, 100, 30);

    JButton back = new JButton("Back To Restaurant");
    back.setBackground(Color.BLACK);
    back.setForeground(Color.gray);
    back.setFont(new Font("Arial Bold", Font.BOLD, 15));

    back.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new Restaurant();
        }
    });

    bill.setSize(300,height+100);

    bill.add(label1);
    bill.add(label2);
    bill.add(spt);
    bill.add(burgerName);
    bill.add(burgerPrice);
    bill.add(spt1);
    bill.add(total);
    bill.add(totalPrice);
    bill.add(totalTax);
    bill.add(totalTaxAmount);
    bill.add(finalTotal);
    bill.add(finalAmount);
    add(bill,BorderLayout.CENTER);
    add(back,BorderLayout.SOUTH);
    setSize(300,height+150);
    setVisible(true);
}

    private Double calculateTotal(Burger burger, ArrayList<Topping> toppings, Bill billDb)
    {
        Double temp = 0.0;
        Double toppingPrice = 0.0;
        temp = burger.getPrice();

        for(Topping topping : toppings)
        {
            toppingPrice += topping.getPrice();
        }

        billDb.setToppingTotal(toppingPrice);
        billDb.setNoOfToppings(toppings.size());

        return temp + toppingPrice;
    }

}
