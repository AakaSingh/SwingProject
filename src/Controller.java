
import java.sql.SQLException;

public class Controller {

    public static void saveTransaction(Bill bill)
    {
        Database db = new Database();
        try {
            db.connect();
            db.save(bill);
            db.disconnect();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
