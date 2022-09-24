import java.awt.*;
public class Icosahedron extends Shape3D
{
    // TODO: CONTINUE WORKING ON
    private double goldenRatio = (1 + Math.sqrt(5.0))/2.0;

    public Icosahedron(double x, double y, double z, double edgeLength)
    {
        points = new double[12][3];

        // cartesian coordinates system d
        points[0] = new double[] {x + 0, y + edgeLength, z + goldenRatio};
        points[1] = new double[] {x + 0, y - edgeLength, z + goldenRatio};
        points[2] = new double[] {x + 0, y + edgeLength, z - goldenRatio};
        points[3] = new double[] {x + 0, y - edgeLength, z - goldenRatio};

        points[4] = new double[] {x + edgeLength, y + goldenRatio, z + 0};
        points[5] = new double[] {x - edgeLength, y + goldenRatio, z + 0};
        points[6] = new double[] {x + edgeLength, y - goldenRatio, z + 0};
        points[7] = new double[] {x - edgeLength, y - goldenRatio, z + 0};

        points[8] = new double[] {x + goldenRatio, y + 0, z + edgeLength};
        points[9] = new double[] {x - goldenRatio, y + 0, z + edgeLength};
        points[10] = new double[] {x + goldenRatio, y + 0, z - edgeLength};
        points[11] = new double[] {x - goldenRatio, y + 0, z - edgeLength};
    }

    public void draw(Graphics2D g2D)
    {
        g2D.setColor(secondaryColor);
        for (int i = 0; i < 12; i++)
        {
            g2D.fillRect(x(i), y(i), 2, 2);
        }
    }
}
