
import java.awt.*;
public class Sphere extends Shape3D
{
    public Sphere(double x, double y, double z, double radius)
    {
        points = new double[360 * 180][3];

        int index = 0;
        for (int i = 0; i < 180; i++)
        {
            double adjustedRadius = radius * Math.sin(Math.toRadians(i));
            System.out.println(adjustedRadius);
            for (int j = 0; j < 360; j++)
            {
                double xP = adjustedRadius * Math.cos(Math.toRadians(j));
                double zP = adjustedRadius * Math.sin(Math.toRadians(j));
                points[index] = new double[]{x + xP, y -radius *Math.cos(Math.toRadians(i)), z + zP};
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