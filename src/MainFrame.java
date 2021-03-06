import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class MainFrame extends JFrame {

    public MainFrame()
    {

        JPanel home = new Home("images/burgershop.gif");

        JLabel greet = new JLabel("Brampton Burgers");
        greet.setFont(new Font("Arial Bold",Font.BOLD,60));
        greet.setForeground(Color.YELLOW);

        JButton moveToMenu = new JButton("View Menu");
        moveToMenu.setFont(new Font("Arial Bold",Font.BOLD,20));
        moveToMenu.setBackground(Color.WHITE);
        moveToMenu.setForeground(Color.RED);
        moveToMenu.setToolTipText("Click to Open Menu");

        moveToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu();
                dispose();
            }
        });

        moveToMenu.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                try {
                    Image img = ImageIO.read(getClass().getResource("images/menuroll.png"));
                    moveToMenu.setIcon(new ImageIcon(img));
                    moveToMenu.setText("");
                }
                catch (Exception e1)
                {
                    System.out.println(e1.getMessage());
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                moveToMenu.setIcon(null);
                moveToMenu.setText("View Menu");
            }
        });

        JMenuBar menuBar = new JMenuBar();

        JMenu view = new JMenu("View");
        JMenuItem orders = new JMenuItem("All Orders");

        JMenu tools = new JMenu("Tools");
        JMenuItem fontCol = new JMenuItem("Font Color");
        tools.add(fontCol);
        view.add(orders);
        menuBar.add(view);
        menuBar.add(tools);

        fontCol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color initialColor=Color.YELLOW;
                Color color=JColorChooser.showDialog(home,"Select a color",initialColor);
                greet.setForeground(color);
            }
        });

        orders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrdersPage orderPage = new OrdersPage();
                orderPage.setData(Controller.getOrders());
                orderPage.setSize(600,400);
                orderPage.setVisible(true);
            }
        });


        home.setLayout(null);
        greet.setBounds(100,20, 600, 65);
        home.add(greet);

        moveToMenu.setBounds(218,350, 150, 80);
        home.add(moveToMenu);
        setJMenuBar(menuBar);
        add(home, BorderLayout.CENTER);




        setSize(800,550);
        setVisible(true);
    }


}
