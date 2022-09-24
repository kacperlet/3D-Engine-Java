
import java.awt.*;
public class RegularPolyhedra extends Shape3D
{
    public RegularPolyhedra(double x, double y, double z, double radius, int n)
    {
        n = 5;
        points = new double[20][3];
        double theta = 360/ n;
        int index = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                double xP = x + radius * Math.cos(Math.toRadians(theta * i));
                double yP = y + radius * Math.sin(Math.toRadians(theta * i));
                double zP = z + radius * Math.cos(Math.toRadians(theta * j));

                points[index] = new double[] {xP, yP, zP};
                index++;
            }
        }
    }

    public void draw(Graphics2D g2D)
    {
        for (int i = 0; i < points.length; i++)
        {
            g2D.fillRect(x(i), y(i), 3, 3);
        }
    }
}