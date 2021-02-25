import javax.swing.table.AbstractTableModel;
import java.util.List;

public class OrdersTableModel extends AbstractTableModel {


    private List<Bill> orders;
    private final String[] colNames = {
            "burgerName",
            "burgerPrice",
            "noOfToppings",
            "toppingPrice",
            "tax",
            "totalPrice"
    };

    public OrdersTableModel(){}

    public void setData(List<Bill> orders){
        this.orders = orders;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public int getRowCount() {
        return orders.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Bill order = orders.get(rowIndex);

        switch (columnIndex){
            case 0:
                return order.getBurgerName();
            case 1:
                return order.getBurgerPrice();
            case 2:
                return order.getNoOfToppings();
            case 3:
                return order.getToppingTotal();
            case 4:
                return order.getTax();
            case 5:
                return order.getFinalAmount();
        }

        return null;

    }


}
