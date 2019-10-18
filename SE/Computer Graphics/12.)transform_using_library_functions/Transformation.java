
package transformation;
import java.awt.*;
import javax.swing.*;
public class Transformation extends JFrame {
    
    public void paint(Graphics g)
    {
        Graphics2D g2d =  (Graphics2D) g;
        
        //g2d.setBackground(Color.yellow);
        
        g2d.fillRect(100, 100, 150, 70);
        
        g2d.setColor(Color.blue);
        g2d.translate(100, 100);
        g2d.fillRect(100, 100, 150, 70);
        
        g2d.setColor(Color.CYAN);
        g2d.translate(100, 100);
        g2d.rotate(45,100,100);
        g2d.fillRect(100, 100, 150, 70);
        
        
        g2d.setColor(Color.magenta);
        g2d.translate(100, 100);
        g2d.translate(100, 100);
        g2d.scale(0.5, 0.5);
        g2d.fillRect(100, 100, 150, 70);
        
         g2d.translate(100, 100);
         g2d.translate(100, 100);
        
        g2d.setColor(Color.red);
        g2d.shear(0.5, 0.9);
        g2d.fillRect(100, 100, 150, 70);
    }

    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Transformation a=new Transformation();
        a.setSize(1000,1000);
        a.setVisible(true);
        a.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
