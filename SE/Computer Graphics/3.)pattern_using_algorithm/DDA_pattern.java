package dda_pattern;
import java.awt.*;
    import javax.swing.*;


public class DDA_pattern extends JFrame {
    public void Drawline1(Graphics g,double x1,double y1,double x2,double y2){
         double dx,dy,length;
         double x,y;    
         dx=Math.abs(x2-x1);
         dy=Math.abs(y2-y1);
         if(dx>=dy)
             length=dx;
         else
             length=dy;
         dx=(x2-x1)/length;
         dy=(y2-y1)/length;
         
         x=x1+0.5*Math.signum(dx);
         y=y1+0.5*Math.signum(dy);
        
         int i=1;
         while(i<=length)
         {
             g.fillOval((int)x,(int)y,2,2);
             x=x+dx;
             y=y+dy;
             i=i+1;
         }
    }
    
    public void paint(Graphics g)
    {
       Drawline1(g,100,200,500,200);
        Drawline1(g,100,200,100,500);
         Drawline1(g,100,500,500,500);
          Drawline1(g,500,200,500,500);
           Drawline1(g,300,200,100,350);
            Drawline1(g,100,350,300,500);
            Drawline1(g,300,500,500,350);
             Drawline1(g,500,350,300,200);
              Drawline1(g,200,280,200,420);
               Drawline1(g,200,420,400,420);
                Drawline1(g,400,420,400,280);
                 Drawline1(g,400,280,200,280);
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        DDA_pattern d=new DDA_pattern();
        d.setSize(800,800);
        d.setVisible(true);
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
