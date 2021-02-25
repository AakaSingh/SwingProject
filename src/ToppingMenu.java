import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ToppingMenu extends JFrame{

    public static ArrayList<Topping> toppings;
    public static ArrayList<Topping> selectedToppings = new ArrayList<>();

public ToppingMenu(Burger burger)
{
    super("Toppings Menu");
    JPanel top = new Home("images/back.jpg");
    toppings = burger.getToppings();
    selectedToppings.clear();
    top.setLayout(null);

    JButton[] toppingButtons = new JButton[toppings.size()];
    JSpinner[] spinners = new JSpinner[toppings.size()];
    JLabel[] labels = new JLabel[toppings.size()-2];

    for(int i=0; i<toppingButtons.length; i++)
    {
        toppingButtons[i] = new JButton(toppings.get(i).getName());
        toppingButtons[i].setEnabled(false);
        toppingButtons[i].setBounds(i*110 + 10, 70, 100, 70);
        toppingButtons[i].setBackground(Color.BLACK);
        toppingButtons[i].setForeground(Color.GRAY);
        toppingButtons[i].setFont(new Font("Arial Bold", Font.BOLD, 15));
        top.add(toppingButtons[i]);

        SpinnerModel value = new SpinnerNumberModel(0,0, burger.getMaxToppings(), 1);
        spinners[i]= new JSpinner(value);
        spinners[i].setFont(new Font("Arial Bold", Font.BOLD, 15));
        spinners[i].setBounds(i*110+10, 140, 100, 30 );
        top.add(spinners[i]);
    }


    JButton label = new JButton("Topping Options For "+ burger.getName());
    label.setEnabled(false);
    JButton button = new JButton("Complete Order");
    label.setFont(new Font("Arial Bold",Font.BOLD, 15) );
    label.setForeground(Color.WHITE);
    label.setBackground(Color.BLACK);
    button.setBounds(10, 300, 200, 50);
    button.setFont(new Font("Arial Bold",Font.BOLD, 20) );
    button.setBackground(Color.black);
    button.setForeground(Color.gray);

    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int totalToppings = 0;
            for(JSpinner spin: spinners)
            {
                totalToppings += (int)spin.getValue();
            }
            if(totalToppings > burger.getMaxToppings())
            {
                JOptionPane.showMessageDialog(top,"PLease Select Only "+ burger.getMaxToppings()+ " Toppings or less","Warning" +
                        "", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                for(int i=0; i < burger.getMaxToppings(); i++)
                {
                    for(int j=0; j< (int)spinners[i].getValue(); j++)
                    {
                        selectedToppings.add(toppings.get(i));
                    }
                }
                String name  = JOptionPane.showInputDialog("Enter Name");
                String contact = JOptionPane.showInputDialog("Enter Contact Number");
                new BillPage(burger, selectedToppings, name, contact );
                dispose();
            }
        }
    });

    label.setBounds(0, 10, 300, 30);
    top.add(label);
    top.add(button);

    add(top, BorderLayout.CENTER);
    setMinimumSize(new Dimension(320, 400));
    setSize(toppings.size()*110 + 20,400);
    setVisible(true);
}

}
