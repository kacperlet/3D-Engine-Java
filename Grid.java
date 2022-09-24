import java.util.ArrayList;
import java.awt.*;
public class Grid extends Shape3D
{
    private ArrayList<double[]> xAxisPoints = new ArrayList<>();
    private ArrayList<double[]> zAxisPoints = new ArrayList<>();
    private double length;

    public Grid(double y, double length, double sectionLength)
    {
        this.length = length;
        double xStart = -length/2;
        double zStart = -length/2;

        for (double i = xStart; i <= length/2; i += sectionLength)
        {
            xAxisPoints.add(new double[] {i, y, zStart});
        }

        for (double i = zStart; i <= length/2; i += sectionLength)
        {
            zAxisPoints.add(new double[] {xStart, y, i});
        }
    }

    public void draw(Graphics2D g2D) 
    {
        g2D.setColor(Color.black);

        for (double[] d : xAxisPoints)
        {
            double[] d2 = {d[0], d[1], d[2] + length};
            g2D.drawLine(x(d), y(d), x(d2), y(d2));
        }

        for (double[] d : zAxisPoints)
        {
            double[] d2 = {d[0] + length, d[1], d[2]};
            g2D.drawLine(x(d), y(d), x(d2), y(d2));
        }
    }
}
