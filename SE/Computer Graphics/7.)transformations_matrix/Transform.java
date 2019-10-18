
package transform;
import java.awt.*;
import javax.swing.*;

public class Transform extends JFrame
{
    double mat[][]={{100,100,500},{100,200,300},{1, 1, 1}};
    
    double transl[][]={{1,0,500},{0,1,100},{0,0,1}};
    double scale[][]={{2.5,0,0},{0,2.5,0},{0,0,1}};
    double rotate[][]={{0.9397,0.342,0},{-0.342,0.9397,0},{0,0,1}};
    
    double resultt[][]=new double[3][3];
    double results[][]=new double[3][3];
    double resultr[][]=new double[3][3];
    
    
    void translate(Graphics g)
    {
        int i,j,k;
        k=0;
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                resultt[i][j]=0;
                for(k=0;k<3;k++)
                {
                    resultt[i][j]=resultt[i][j]+transl[i][k]*mat[k][j];
                }
            }
        }
           g.drawLine((int)resultt[0][0],(int) resultt[1][0], (int)resultt[0][1],(int) resultt[1][1]);
        g.drawLine((int)resultt[0][1],(int) resultt[1][1],(int) resultt[0][2],(int) resultt[1][2]);
        g.drawLine((int)resultt[0][2],(int) resultt[1][2],(int) resultt[0][0],(int) resultt[1][0]);
    
    }
    
     void rotate1(Graphics g)
    {
        int i,j,k;
        k=0;
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                resultr[i][j]=0;
                for(k=0;k<3;k++)
                {
                    resultr[i][j]=resultr[i][j]+(rotate[i][k]*mat[k][j]);
                }
            }
        }
           g.drawLine((int)resultr[0][0],(int) resultr[1][0], (int)resultr[0][1],(int) resultr[1][1]);
        g.drawLine((int)resultr[0][1],(int) resultr[1][1],(int) resultr[0][2],(int) resultr[1][2]);
        g.drawLine((int)resultr[0][2],(int) resultr[1][2],(int) resultr[0][0],(int) resultr[1][0]);
    
    }
   
      void scale1(Graphics g)
    {
        int i,j,k;
        k=0;
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                results[i][j]=0;
                for(k=0;k<3;k++)
                {
                    results[i][j]=results[i][j]+scale[i][k]*mat[k][j];
                }
            }
        }
           g.drawLine((int)results[0][0],(int) results[1][0], (int)results[0][1],(int) results[1][1]);
        g.drawLine((int)results[0][1],(int) results[1][1],(int) results[0][2],(int) results[1][2]);
        g.drawLine((int)results[0][2],(int) results[1][2],(int) results[0][0],(int) results[1][0]);
    
    }
   
    
    
    public void paint(Graphics g)
    {
        g.drawLine(100, 100, 100, 200);
        g.drawLine(100, 100, 500, 300);
        g.drawLine(500, 300, 100, 200);

        translate(g);
        rotate1(g);
        scale1(g);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Transform a=new Transform();
        a.setSize(1500,1500);
        a.setVisible(true);
        a.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    
}
