
import java.awt.*;
import java.util.ArrayList;
public class Equation extends Shape3D
{
    public Equation(double[] expression, int min, int max)
    {
        points = new double[Math.abs(min)+max][3];
        for (int i = 0; i < points.length; i++)
        {
            points[i] = new double[] {i+min, calculateExpression(i+min, expression) * -1, 0};
            System.out.println(points[i][0] + " " + points[i][1]);
        }
    }

    public Equation(double[] expression, int min, int max, double xScaleFactor, double yScaleFactor)
    {
        points = new double[Math.abs(min)+max][3];
        for (int i = 0; i < points.length; i++)
        {
            points[i] = new double[] {(i+min) * xScaleFactor, calculateExpression(i+min, expression) * -1 * yScaleFactor, 0};
        }
    }

    public Equation(int min, int max)
    {
        ArrayList<Double[]> points2 = new ArrayList<>();
        for (int i = min; i < max; i++)
        {
            points2.add(new Double[] {(double) i, Math.sin(Math.toRadians(i)), 0.0});
        }
    }

    public void draw(Graphics2D g2D)
    {
        for (int i = 0; i < points.length-1; i++)
        {
            g2D.drawLine(x(i), y(i), x(i+1), y(i+1));
            g2D.fillRect(x(i), y(i), 1, 1);
        }
    }

    public static double calculateExpression(double x, double[] expression)
    {
        double y = 0;
        for (int i = 0; i < expression.length; i++)
        {
            y += expression[i] * Math.pow(x, expression.length-1 - i);
        }
        return y;
    }
}