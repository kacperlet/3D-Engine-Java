import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputListener;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
public class Panel extends JPanel implements MouseInputListener
{
    private ArrayList<Shape3D> shapes = new ArrayList<>();

    private boolean drag;
    private double x1, y1;
    private double origThetaX, origThetaY;

    private Panel itself;

    public Panel()
    {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1200, 800));
        this.setVisible(true);
        this.addMouseListener(this);
        addAssets();
        
        itself = this;

        shapes.add(new Grid(100, 1000, 50));
        //shapes.add(new RectangularPrism(-100, -100, -100, 200, 200, 200));
        shapes.add(new Pyramid(-100, -100, -100, 200, 200, 200));
        // shapes.add(new Prism(0, 0, 0, 200, 200, 200, 30));
        // shapes.add(new Equation(new double[] {2, -50, 200}, -200, 200, 3, 1));
        // shapes.add(new Equation(new double[] {3}, -200, 200, 3, 1));
        //shapes.add(new Sphere(0, 0, 0, 200));
        

        Thread loop = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true)
                {
                    if (drag)
                    {
                        double x2 = MouseInfo.getPointerInfo().getLocation().getX() - itself.getLocationOnScreen().x;
                        double y2 = MouseInfo.getPointerInfo().getLocation().getY() - itself.getLocationOnScreen().y;

                        Shape3D.thetaX = origThetaX + Math.toRadians(y1 - y2);
                        Shape3D.thetaY = origThetaY + Math.toRadians(x2 - x1);
                    }

                    repaint();
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            
        });
        loop.start();

    }


    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        // g2D.drawImage(image, 100, 100, 100, 100, null);
        // g2D.drawImage(image, 0, 0, 100, 0,0, 0, 100, 0, null);

        for (Shape3D shape : shapes)
        {
            shape.draw(g2D);
        }
    
    }

    private void addAssets()
    {
        this.add(new SideBar());

        JSlider xJSlider = new JSlider(-400, 800, 0);
        xJSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                Shape3D.x = xJSlider.getValue();
            
            }
            
        });
        xJSlider.setBounds(70, 680, 250, 20);
        this.add(xJSlider);

        JSlider yJSlider = new JSlider(-700, 600, 0);
        yJSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                Shape3D.y = yJSlider.getValue();
                
            }
            
        });
        yJSlider.setBounds(70, 710, 250, 20);
        this.add(yJSlider);

        JSlider zJSlider = new JSlider(0, 2000);
        zJSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                Shape3D.z = zJSlider.getValue();
                
            }
            
        });
        zJSlider.setBounds(70, 740, 250, 20);
        this.add(zJSlider);

        JSlider thetaXJSlider = new JSlider(0, 720);
        thetaXJSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                Shape3D.thetaX = Math.toRadians(thetaXJSlider.getValue());
                
            }
            
        });
        thetaXJSlider.setBounds(920, 680, 250, 20);
        this.add(thetaXJSlider);

        JSlider thetaYJSlider = new JSlider(0, 720);
        thetaYJSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                Shape3D.thetaY = Math.toRadians(thetaYJSlider.getValue());

                
            }
            
        });
        thetaYJSlider.setBounds(920, 710, 250, 20);
        this.add(thetaYJSlider);

        JSlider thetaZJSlider = new JSlider(0, 720);
        thetaZJSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                Shape3D.thetaZ = Math.toRadians(thetaZJSlider.getValue());

                
            }
            
        });
        thetaZJSlider.setBounds(920, 740, 250, 20);
        this.add(thetaZJSlider);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        
    }


    @Override
    public void mousePressed(MouseEvent e) {
        drag = true;
        x1 = e.getX();
        y1 = e.getY();
        origThetaX = Shape3D.thetaX;
        origThetaY = Shape3D.thetaY;
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        drag = false;
        
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}