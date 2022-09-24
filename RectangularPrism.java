
import java.awt.*;
public class RectangularPrism extends Shape3D
{

    public RectangularPrism(double x, double y, double z, double width, double height, double length)
    {
        points = new double[8][3];

        points[0] = new double[] {x, y, z};
        points[1] = new double[] {x+width, y, z};
        points[2] = new double[] {x+width, y+height, z};
        points[3] = new double[] {x, y+height, z};

        points[4] = new double[] {x, y+height, z+length};
        points[5] = new double[] {x+width, y+height, z+length};
        points[6] = new double[] {x+width, y, z+length};
        points[7] = new double[] {x, y, z+length};
    }

    public void draw(Graphics2D g2D)
    {
        g2D.setColor(primaryColor);
        drawTriangle(g2D, 0, 1, 2);
        drawTriangle(g2D, 0, 3, 2);

        drawTriangle(g2D, 2, 5, 6);
        drawTriangle(g2D, 2, 1, 6);

        drawTriangle(g2D, 0, 7, 6);
        drawTriangle(g2D, 0, 1, 6);

        drawTriangle(g2D, 3, 2, 5);
        drawTriangle(g2D, 3, 4, 5);

        drawTriangle(g2D, 7, 6, 5);
        drawTriangle(g2D, 7, 4, 5);

        drawTriangle(g2D, 0, 7, 4);
        drawTriangle(g2D, 0, 3, 4);

        g2D.setColor(secondaryColor);
        g2D.drawLine(x(0), y(0), x(1), y(1));
        g2D.drawLine(x(1), y(1), x(2), y(2));
        g2D.drawLine(x(2), y(2), x(3), y(3));
        g2D.drawLine(x(3), y(3), x(0), y(0));

        g2D.drawLine(x(7), y(7), x(6), y(6));
        g2D.drawLine(x(6), y(6), x(5), y(5));
        g2D.drawLine(x(5), y(5), x(4), y(4));
        g2D.drawLine(x(4), y(4), x(7), y(7));

        g2D.drawLine(x(0), y(0), x(7), y(7));
        g2D.drawLine(x(1), y(1), x(6), y(6));
        g2D.drawLine(x(2), y(2), x(5), y(5));
        g2D.drawLine(x(3), y(3), x(4), y(4));
        
    }
}