/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harry;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author com-5
 */
public class Harry extends JFrame
{
 public void paint(Graphics g)
   {
      Graphics g2d = (Graphics2D) g;
     g2d.drawOval(200, 200, 300, 300);
    // g2d.drawOval(350, 350, 200, 200);
   //  g2d.drawOval(270, 270, 150,150);
     g2d.drawOval(275, 275, 150, 150);
     
     g2d.drawLine(480, 425, 425-205, 425);
      g2d.drawLine(350,200 , 425-205, 425);
       g2d.drawLine(480, 425,350,200 );
     
            
   }
    public static void main(String[] args) {
        Harry d=new Harry();
         d.setTitle("my program");
       d.setSize(1000,1000);
       d.setVisible(true);
       d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // TODO code application logic here
    }
    
}
