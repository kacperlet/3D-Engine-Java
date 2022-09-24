
import java.awt.*;
public class Shape3D
{
    public static double x = 0;
    public static double y = 0;
    public static double z = 0;
    public static double FOV = Math.toRadians(75);
    public static double z0 = (1200/2.0)/(Math.tan(FOV/2.0));

    public static double thetaX;
    public static double thetaY;
    public static double thetaZ;

    // color
    private int r = 255;
    private int g;
    private int b;

    protected Color primaryColor = new Color(r,g,b);
    protected Color secondaryColor = Color.black;

    protected double[][] points;

    public void draw(Graphics2D g2D) {}

    protected int x(int index)
    {
        double x = points[index][0] + Shape3D.x;
        double y = points[index][1] + Shape3D.y;
        double z = points[index][2] + Shape3D.z;

        // rotation on x axis
        double xRotated = x;
        double yRotated = y * Math.cos(thetaX) - z * Math.sin(thetaX);
        double zRotated = y * Math.sin(thetaX) + z * Math.cos(thetaX);

        // rotation on y axis
        double xRotated2 = xRotated * Math.cos(thetaY) + zRotated * Math.sin(thetaY);
        double yRotated2 = yRotated;
        double zRotated2 = -xRotated * Math.sin(thetaY) + zRotated * Math.cos(thetaY);
        
        // rotation on z axis
        double xRotated3 = xRotated2 * Math.cos(thetaZ) - yRotated2 * Math.sin(thetaZ);
        double zRotated3 = zRotated2;

        // rotation on each axis
        // double xR = x * (Math.cos(thetaZ)* Math.cos(thetaY)) + y * (Math.cos(thetaZ) * Math.sin(thetaY) * Math.sin(thetaX) - Math.sin(thetaZ) * Math.cos(thetaX)) + z * (Math.cos(thetaZ) * Math.sin(thetaY) * Math.cos(thetaX) + Math.sin(thetaZ) * Math.sin(thetaX));
        // double yR = x * (Math.sin(thetaZ) * Math.cos(thetaY)) + y * (Math.sin(thetaZ) * Math.sin(thetaY) * Math.sin(thetaX) + Math.cos(thetaZ) * Math.cos(thetaX)) + z * (Math.sin(thetaZ) * Math.sin(thetaY) * Math.sin(thetaX) - Math.cos(thetaZ) * Math.cos(thetaX));
        // double zR = x * (- Math.sin(thetaY)) + y * Math.cos(thetaY) * Math.sin(thetaX) + z * Math.cos(thetaY) * Math.cos(thetaZ);

        // projection function
        x = (xRotated3 * z0)/(zRotated3 + z0);
        
        return (int) x + 600; 
    }

    protected int y(int index)
    {
        double x = points[index][0] + Shape3D.x;
        double y = points[index][1] + Shape3D.y;
        double z = points[index][2] + Shape3D.z;

        // rotation on x axis
        double xRotated = x;
        double yRotated = y * Math.cos(thetaX) - z * Math.sin(thetaX);
        double zRotated = y * Math.sin(thetaX) + z * Math.cos(thetaX);

        // rotation on y axis
        double xRotated2 = xRotated * Math.cos(thetaY) + zRotated * Math.sin(thetaY);
        double yRotated2 = yRotated;
        double zRotated2 = -xRotated * Math.sin(thetaY) + zRotated * Math.cos(thetaY);  

        // rotation on z axis
        double yRotated3 = xRotated2 * Math.sin(thetaZ) + yRotated2 * Math.cos(thetaZ);
        double zRotated3 = zRotated2;

        // projection function
        y = (yRotated3 * z0)/(zRotated3 + z0);

        return (int) y + 400;
    }

    public static int x(double[] arr)
    {
        double x = arr[0] + Shape3D.x;
        double y = arr[1] + Shape3D.y;
        double z = arr[2] + Shape3D.z;

        // rotation on x axis
        double xRotated = x;
        double yRotated = y * Math.cos(thetaX) - z * Math.sin(thetaX);
        double zRotated = y * Math.sin(thetaX) + z * Math.cos(thetaX);

        // rotation on y axis
        double xRotated2 = xRotated * Math.cos(thetaY) + zRotated * Math.sin(thetaY);
        double yRotated2 = yRotated;
        double zRotated2 = -xRotated * Math.sin(thetaY) + zRotated * Math.cos(thetaY);
        
        // rotation on z axis
        double xRotated3 = xRotated2 * Math.cos(thetaZ) - yRotated2 * Math.sin(thetaZ);
        double zRotated3 = zRotated2;

        
        // projection function
        x = (xRotated3 * z0)/(zRotated3 + z0);
        
        return (int) x + 600; 
    }

    public static int y(double[] arr)
    {
        double x = arr[0] + Shape3D.x;
        double y = arr[1] + Shape3D.y;
        double z = arr[2] + Shape3D.z;

        // rotation on x axis
        double xRotated = x;
        double yRotated = y * Math.cos(thetaX) - z * Math.sin(thetaX);
        double zRotated = y * Math.sin(thetaX) + z * Math.cos(thetaX);

        // rotation on y axis
        double xRotated2 = xRotated * Math.cos(thetaY) + zRotated * Math.sin(thetaY);
        double yRotated2 = yRotated;
        double zRotated2 = -xRotated * Math.sin(thetaY) + zRotated * Math.cos(thetaY);  

        // rotation on z axis
        double yRotated3 = xRotated2 * Math.sin(thetaZ) + yRotated2 * Math.cos(thetaZ);
        double zRotated3 = zRotated2;

        // projection function
        y = (yRotated3 * z0)/(zRotated3 + z0);

        return (int) y + 400;
    }

    public static int[] project(double x, double y, double z)
    {
        x += Shape3D.x;
        y += Shape3D.y;
        z += Shape3D.z;

        // rotation on x axis
        double xRotated = x;
        double yRotated = y * Math.cos(thetaX) - z * Math.sin(thetaX);
        double zRotated = y * Math.sin(thetaX) + z * Math.cos(thetaX);

        // rotation on y axis
        double xRotated2 = xRotated * Math.cos(thetaY) + zRotated * Math.sin(thetaY);
        double yRotated2 = yRotated;
        double zRotated2 = -xRotated * Math.sin(thetaY) + zRotated * Math.cos(thetaY);
        
        // rotation on z axis
        double xRotated3 = xRotated2 * Math.cos(thetaZ) - yRotated2 * Math.sin(thetaZ);
        double yRotated3 = xRotated2 * Math.sin(thetaZ) + yRotated2 * Math.cos(thetaZ);
        double zRotated3 = zRotated2;

        // projection function
        int[] coordinates = new int[2];
        coordinates[0] = (int) ((xRotated3 * z0)/(zRotated3 + z0));
        coordinates[1] = (int) ((yRotated3 * z0)/(zRotated3 + z0));
        
        return coordinates; 
    }

    protected void drawTriangle(Graphics2D g2D, int p1, int p2, int p3)
    {
        int[] x = {x(p1), x(p2), x(p3)};
        int[] y = {y(p1), y(p2), y(p3)};
        g2D.fillPolygon(x, y, 3);
    }

    protected void drawTriangle(Graphics2D g2D, double[] p1, double[] p2, double[] p3)
    {
        int[] x = {x(p1), x(p2), x(p3)};
        int[] y = {y(p1), y(p2), y(p3)};
        g2D.fillPolygon(x, y, 3);
    }
    
    protected void fadeColors()
    {
        primaryColor = new Color(r,g,b,100);
        if(r > 0 && b == 0){
            r--;
            g++;
        }
        if(g > 0 && r == 0){
            g--;
            b++;
        }
        if(b > 0 && g == 0){
            r++;
            b--;
        }
    }
}