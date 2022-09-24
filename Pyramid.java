
import java.awt.*;
public class Pyramid extends Shape3D
{
    public Pyramid(double x, double y, double z, double width, double height, double length)
    {
        points = new double[5][3];

        // base
        points[0] = new double[] {x, y + height, z};
        points[1] = new double[] {x + width, y + height, z};
        points[2] = new double[] {x + width, y + height, z + length};
        points[3] = new double[] {x, y + height, z + length};

        // tip
        points[4] = new double[] {x + width/2, y, z + length/2};
    }

    public void draw(Graphics2D g2D)
    {
        g2D.setColor(secondaryColor);
        g2D.drawLine(x(0), y(0), x(1), y(1));
        g2D.drawLine(x(1), y(1), x(2), y(2));
        g2D.drawLine(x(2), y(2), x(3), y(3));
        g2D.drawLine(x(3), y(3), x(0), y(0));

        g2D.drawLine(x(0), y(0), x(4), y(4));
        g2D.drawLine(x(1), y(1), x(4), y(4));
        g2D.drawLine(x(2), y(2), x(4), y(4));
        g2D.drawLine(x(3), y(3), x(4), y(4));

        fadeColors();
        g2D.setColor(primaryColor);

        drawTriangle(g2D, 0, 4, 1);
        drawTriangle(g2D, 1, 4, 2);
        drawTriangle(g2D, 2, 4, 3);
        drawTriangle(g2D, 3, 4, 0);

        drawTriangle(g2D, 0, 1, 2);
        drawTriangle(g2D, 0, 3, 2);
    }
}