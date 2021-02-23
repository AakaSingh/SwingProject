import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

public class Menu extends JFrame {

    private static ArrayList<Burger> burgerList = new ArrayList<>();
    private static String[] burgerImg = {"basic.jpg","healthy.jpg","deluxe.jpg"};

    public Menu()
    {
        JPanel menu = new Home("images/menuback.jpg");
        menu.setLayout(null);
        menu.setBackground(Color.BLUE);
        burgerList = Restaurant.sendBurgers();

        JLabel burgerMenu = new JLabel("Burger Menu");
        burgerMenu.setFont(new Font("Arial Bold",Font.BOLD,60));
        burgerMenu.setForeground(Color.WHITE);
        burgerMenu.setBounds(270, 5, 500, 65);
        menu.add(burgerMenu);

        JSeparator spt = new JSeparator();
        spt.setBounds(0, 80, 900, 10);
        menu.add(spt);

        JSeparator spt1 = new JSeparator();
        spt1.setBounds(0, 380, 900, 10);
        menu.add(spt1);

        JButton[] burgers = new JButton[burgerList.size()];

        for(int i=0; i<burgerList.size(); i++)
        {
            burgers[i] = new JButton();
            try {
                Image img = ImageIO.read(getClass().getResource("images/"+burgerImg[i]));
                burgers[i].setIcon(new ImageIcon(img));
                burgers[i].setMargin(new Insets(0,0,0,0));
            } catch (Exception ex) {
                System.out.println(ex);
            }
            burgers[i].setBounds(i*300+20,100,250,250);
            menu.add(burgers[i]);
        }

        burgers[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ToppingMenu(burgerList.get(0));
            }
        });

        burgers[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ToppingMenu(burgerList.get(1));
            }
        });

        burgers[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ToppingMenu(burgerList.get(2));
            }
        });

        add(menu);
        setSize(900,500);
        setVisible(true);
    }
}
