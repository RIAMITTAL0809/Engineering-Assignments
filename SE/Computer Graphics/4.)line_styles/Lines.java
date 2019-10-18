package lines;
import java.awt.*;
import static java.lang.Math.abs;
import javax.swing.JFrame;
import static java.lang.Math.round;
import java.util.Scanner;


public class Lines extends JFrame{
  Scanner sc=new Scanner(System.in);
    public void dda(Graphics g,int x1,int y1,int x2,int y2)
    {
        float X,Y,dx,dy,x,y,span;
        x=x2-x1;
        y=y2-y1;
        if ( Math.abs(x) >= Math.abs(y))
         span = Math.abs(x);
        else
          span =Math.abs(y);
        dx=x/span;
        dy=y/span;
        X=x1;
        Y=y1;
        for(int i=1;i<=span;i++)
        {
            g.fillOval(round(X), round(Y), 1, 1);
            X=X+dx;
            Y=Y+dy;
        }
    }
    public void dot(Graphics g,int x1,int y1,int x2,int y2)
    { int temp,temp1;
    float dx,dy,m;
        if(x1>x2)
        {
            temp=x1;
            x1=x2;
            x2=temp;
            temp1=y1;
            y1=y2;
            y2=temp1;
        
     
            }
        dx=x2-x1;
        dy=y2-y1;
        m=dy/dx;
        if(dx>dy)
        {
            while(x1<=x2)
            {
                g.fillOval(round(x1),round(y1),1,1);
                x1=x1+5;
                y1=y1+round(m);
                
            }
        
        }
        else
        {
            while(y1<=y2)
            {
                g.fillOval(round(x1),round (y1), 1, 1);
                y1=y1+5;
                x1=(x1+round(1/m));
                
            } 
    }
    }
    public void dashdot(Graphics g,int x1,int x2,int y1,int y2)
    {
        float dx,dy,len,xi,yi;
        float x,y;
        int i;
        dx=Math.abs(x2-x1);
        dy=Math.abs(y2-y1);
        if(dx>=dy)
        len=dx;
        else
         len=dy;
        dx=(x2-x1)/len;
        dy=(y2-y1)/len;
        x=(float) (x1 + 0.5);
        y=(float) (y1 + 0.5);
        g.fillOval(round(x1),round(y1) , 3, 3);
        g.fillOval(round(x2),round(y2) , 3, 3);
        for(i=0;i<=len;i++)
        {
            if(i%9<2)
            {
                
            }
            else if(i%9<6)
                g.fillOval(round(x), round(y), 3, 3);
            else if(i%9==7)
            {
                
            }
            else
            g.fillOval(round(x), round(y), 3, 3);
               x+=dx;
               y+=dy;
          
        }
        
    }
    public void dash(Graphics g,int x1,int y1,int x2,int y2)
    {
        int dx,dy,xend,p,x,y,cnt=0;
        float m;
        dx=Math.abs(x2-x1);
        dy=Math.abs(y2-y1);
        p=2*dy-dx;
        if(abs(dx)>abs(dy))
            xend=abs(dx);
        else
            xend=abs(dy);
        m=dy/(float)dx;
        if(x2>x1)
        {
          x=x1;
          y=y1;
        }
        else
        {
            x=x2;
            y=y2;
        }
        g.fillOval(round(x),round (y), 1, 1);
        while(x<xend)
        {
            x=x+1;
            if((cnt/5)%2==0)
                g.fillOval(x, y, 2, 2);
            if(p<0)
            {
                p=p+2*dy;
            }
            else
            {
                if(m>=0&&m<=1)
                    y=y+1;
                else
                {
                    if(dx==0)
                        x--;y--;
                }
                p=p+2*(dy-dx);
            }
          
            cnt++;
        }
               
    }
    public void thick(Graphics g,int x1,int y1,int x2,int y2,int thick)
    {
        int temp1,temp2,dx,dy;
        float m;
        if(x1>x2)
        {
            temp1=x1;
            x1=x2;
            x2=temp1;
            temp2=y1;
            y1=y2;
            y2=temp2;
        
        }
        dx=x2-x1;
        dy=y2-y1;
        m=dy/dx;
        if(dx>dy)
        {
            while(x1<=x2)
            {
                g.fillOval(x1, y1,1,1 );
                x1=x1+1;
                y1=(int) (y1+m);
               
            }
        }
        else
        {
            while(y1<=y2)
            {
                for(int j=0;j<thick;j++)
                {
                    g.fillOval(x1+j, y1,1, 1);
                }
                y1=y1+1;
                x1=(int) (x1+(1/m));
               
                        
            }
        }
    }
     public void paint(Graphics g)
    { 
    
        
            dda(g,50,50,200,50);
            dash(g,50,100,200,100);
            dot(g,50,150,200,150);
            dashdot(g,50,200,200,200);
            thick(g,500,250,200,250,5);
            
        }
        
       
        
        
        
        
    
    
    public static void main(String[] args) {
        // TODO code application logic here
       Lines l=new Lines();
    
        
        //Scanner in=new Scanner(System.in);
        
        l.setSize(500,500);
    l.setVisible(true);
    l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }    
}
