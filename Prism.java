
import java.awt.*;
public class Prism extends Shape3D
{
    private int n;
    private double[] center;
    private double[] center2;

    public Prism(double x, double y, double z, double width, double height, double length, int n)
    {
        points = new double[n * 2][3];

        this.n = n;
        center = new double[] {x,y,z};
        center2 = new double[] {x,y,z+ length};
        double theta = 360/ n;

        for (int i = 0; i < n; i++)
        {
            double xP = x + width * Math.cos(Math.toRadians(theta * i));
            double yP = y + height * Math.sin(Math.toRadians(theta * i));
            points[i] = new double[] {xP, yP, z};
            points[i + n] = new double[] {xP, yP, z + length};
        }
    }

    public void draw(Graphics2D g2D)
    {
        g2D.setColor(secondaryColor);
        for (int i = 1; i < n; i++)
        {
            g2D.drawLine(x(i-1), y(i-1), x(i), y(i));
            g2D.drawLine(x(i-1+n), y(i-1+n), x(i+n), y(i+n));
            g2D.drawLine(x(i-1), y(i-1), x(i-1+n), y(i-1+n));

        }
        g2D.drawLine(x(n-1), y(n-1), x(0), y(0));
        g2D.drawLine(x(2*n-1), y(2*n-1), x(n), y(n));
        g2D.drawLine(x(n-1), y(n-1), x(2*n-1), y(2*n-1));

        fadeColors();
        g2D.setColor(primaryColor);

        for (int i = 0; i < n-1; i++)
        {
            // rectangular sides
            drawTriangle(g2D, i, i+1, i+n+1);
            drawTriangle(g2D, i, i+n, i+n+1);

            // regular polygonal faces
            drawTriangle(g2D, points[i], center, points[i+1]);
            drawTriangle(g2D, points[i + n], center2, points[i+1 + n]);
        }
        // rectangular sides
        drawTriangle(g2D, n-1, 2*n-1, n);
        drawTriangle(g2D, n-1, 0, n);

        // regular polygonal faces
        drawTriangle(g2D, points[n-1], center, points[0]);
        drawTriangle(g2D, points[2 * n-1], center2, points[n]);
    }
}