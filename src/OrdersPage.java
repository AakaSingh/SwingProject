import javax.swing.*;
import java.awt.*;
import java.util.List;

public class OrdersPage extends JFrame {

    private JTable table;
    private OrdersTableModel tableModel;

    public OrdersPage()
    {
        tableModel = new OrdersTableModel();
        table = new JTable(tableModel);

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Bill> orders){

        tableModel.setData(orders);
    }
}
