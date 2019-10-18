


package bresenhem;
import java.awt.*;
import javax.swing.*;
public class Bresenhem extends JFrame {
    
    public void bresen(Graphics g,int xc,int yc,int r)
    {
       
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
         bresen(g,450,450,110);         
    }
    



    public static void main(String[] args) {
        Bresenhem a = new Bresenhem();
        a.setSize(1024,768);
        a.setVisible(true);
        a.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
                                                        
}
