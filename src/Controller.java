
import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.List;

public class Controller {

    private static Database db= new Database();

    public static void connect()
    {
        try {
            db.connect();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void disconnect()
    {
        try {
            db.disconnect();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void saveTransaction(Bill bill)
    {
        try
        {
            db.save(bill);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static List<Bill> getOrders()
    {
        try
        {
            return db.getOrders();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
