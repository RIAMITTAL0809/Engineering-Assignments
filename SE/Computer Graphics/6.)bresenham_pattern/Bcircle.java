
package bcircle;
import java.awt.*;
import javax.swing.*;

public class Bcircle extends JFrame {

   
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
             g.fillOval((int)x,(int)y,1,1);
             x=x+dx;
             y=y+dy;
             i=i+1;
             
         }
         

    
    public void bresen(Graphics g,int xc,int yc,int r)
    {
       // int xc,yc,r;
        int x=0;
        int y=r;
        int p=3-2*r;
        do
        {
            if(p<0)
            
                p=p+4*x+6;
            
                else
                {
                        p=p+4*(x-y)+10;
                        y=y-1;
                }
                x=x+1;
                g.drawLine(xc+x, yc+y,xc+x,yc+y);
                g.drawLine(x+xc,yc-y,xc+x,yc-y);
                g.drawLine(xc-x,yc+y,xc-x,yc+y);
                g.drawLine(xc-x,yc-y,xc-x,yc-y);
                g.drawLine(xc+y,yc+x,xc+y,yc+x);
                g.drawLine(xc+y,yc-x,xc+y,yc-x);
                g.drawLine(xc-y, yc+x,xc-y,yc+x);
                g.drawLine(xc-y, yc-x,xc-y,yc-x);   
        }while(x<y);
    }

                public void paint(Graphics g)
    {
         bresen(g,450,450,60);
         bresen(g,450,450,110);

          Drawline1(g,560,510,340,510);
        Drawline1(g,450,340,340,510);
          Drawline1(g,450,340,560,510);
                
    }
    



    public static void main(String[] args) {
        // TODO code application logic here
        Bcircle a = new Bcircle();
        a.setSize(1024,768);
        a.setVisible(true);
        a.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
