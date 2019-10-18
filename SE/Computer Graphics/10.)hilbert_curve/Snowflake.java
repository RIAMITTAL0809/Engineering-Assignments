
package snowflake;

import java.awt.*;
import javax.swing.*;

public class Snowflake extends JApplet {

   int level=0;
   
   public void init()
   {
       String levelstr=JOptionPane.showInputDialog("enter the depth of recursion");
       level=Integer.parseInt(levelstr);
   }
   
   public void paint(Graphics g)
   {
       drawSnow(g,level,400,400,600,400);
       drawSnow(g,level,600,400,500,227);
       drawSnow(g,level,500,227,400,400);    
   }    
   
   private void drawSnow(Graphics g,int lev,int x1,int y1,int x5,int y5)
   {
       int dx,dy,x2,y2,x3,y3,x4,y4;
       if(lev==0)
       {
           g.drawLine(x1,y1,x5,y5);
       }
       else
       {
           dx=x5-x1;
           dy=y5-y1;
           x2=x1+dx/3;
           y2=y1+dy/3;
           x3=(int)(0.5*(x1+x5)+Math.sqrt(3)*(y1-y5)/6);
           y3=(int)(0.5*(y1+y5)+Math.sqrt(3)*(x5-x1)/6);
           x4=x1+2*dx/3;
           y4=y1+2*dy/3;
           
           drawSnow(g,lev-1,x1,y1,x2,y2);
            drawSnow(g,lev-1,x2,y2,x3,y3);
             drawSnow(g,lev-1,x3,y3,x4,y4);
              drawSnow(g,lev-1,x4,y4,x5,y5);
           
   }
   }   
}
