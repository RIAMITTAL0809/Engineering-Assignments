
package pattern;
import java.awt.*;
import javax.swing.*;

public class Pattern extends JFrame {
    
    public void paint(Graphics g){
        
        g.drawLine(100,200,500,200);
        g.drawLine(100,200,100,500);
        g.drawLine(100,500,500,500);
        g.drawLine(500,200,500,500);
        g.drawLine(300,200,100,350);
        g.drawLine(100,350,300,500);
        g.drawLine(300,500,500,350);
        g.drawLine(500,350,300,200);
        g.drawLine(200,280,200,420);
        g.drawLine(200,420,400,420);
        g.drawLine(400,420,400,280);
        g.drawLine(400,280,200,280);
        
    }

    
    public static void main(String[] args) {
       Pattern d=new Pattern();
        d.setSize(800,800);
        d.setVisible(true);
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
