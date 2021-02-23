import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Home extends JPanel {

    private Image backgroundImage;

    public Home(String fileName)
    {
        try {
            backgroundImage = ImageIO.read(getClass().getResource(fileName));
        }
        catch(Exception e)
        {

        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }
}
