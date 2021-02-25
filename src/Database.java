
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class Database {

    private Connection conn;

    public void connect() throws Exception {

        if (conn != null) return;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new Exception("Driver not found");
        }

        String connectionUrl = "jdbc:mysql://localhost:3306/sys?allowPublicKeyRetrieval=true&useSSL=false";
        conn = DriverManager.getConnection(connectionUrl, "root", "handsomeman1");
    }

    public  void disconnect(){
        try {
            conn.close();
        } catch (SQLException throwable) {
            System.out.println("Can't close the connection");
        }
    }

    public void save(Bill bill) throws SQLException {

        DecimalFormat df = new DecimalFormat("#.00");
        String insertSql = "INSERT INTO burgertransactions (burgerName, burgerPrice, noOfToppings, toppingPrice, tax, totalPrice) VALUES(?,?,?,?,?,?)";

        PreparedStatement insertStatement = conn.prepareStatement(insertSql);

        insertStatement.setString(1, bill.getBurger().getName());
        insertStatement.setDouble(2,Double.parseDouble(df.format(bill.getBurger().getPrice())));
        insertStatement.setInt(3,bill.getNoOfToppings());
        insertStatement.setDouble(4,Double.parseDouble(df.format(bill.getToppingTotal())));
        insertStatement.setDouble(5,Double.parseDouble(df.format(bill.getTax())));
        insertStatement.setDouble(6, Double.parseDouble(df.format(bill.getFinalAmount())));

        insertStatement.executeUpdate();

    }
}
