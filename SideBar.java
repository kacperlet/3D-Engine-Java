
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
public class SideBar extends JPanel implements MouseInputListener
{
    private int x = -150;
    private int y;
    private boolean inside;
    private SideBar itself;
    private Font font = new Font("Arial", Font.BOLD, 35);
    private Color color = new Color(160, 160, 160);
    public SideBar()
    {
        this.setBounds(x,y, 200, 800);
        this.setBackground(new Color(224,224,224));
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        this.setLayout(null);
        this.addMouseListener(this);
        this.setVisible(true);

        itself = this;

        JButton reset = new JButton("Reset All");
        reset.setFont(new Font("Arial", Font.PLAIN, 25));
        reset.setFocusable(false);
        reset.setBounds(10, 760, 180, 30);
        reset.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Shape3D.thetaX = 0;
                Shape3D.thetaY = 0;
                Shape3D.thetaZ = 0;
                Shape3D.x = 0;
                Shape3D.y = 0;
                Shape3D.z = 0;
            }
            
        });
        this.add(reset);

        Thread animation = new Thread(new Runnable() {

            @Override
            public void run() {
                while(itself.isVisible())
                {
                    if (inside && x < 0)
                    {
                        x += 5;
                        itself.setBounds(x,y, 200, 800);
                    }
                    else if (!inside && x > -150)
                    {
                        x -= 5;
                        itself.setBounds(x,y, 200, 800);
                    }
                    
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                
            }
            
        });
        animation.start();
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        
        g2D.draw3DRect(0, 0, 200, 45, true);

        g2D.drawRect(155, 10, 39, 5);
        g2D.drawRect(155, 20, 39, 5);
        g2D.drawRect(155, 30, 39, 5);

        g2D.setFont(font);
        g2D.drawString("MENU", 25, 36);

        g2D.setColor(color);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        inside = true;
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        inside = false;
        
    }
    @Override
    public void mouseDragged(MouseEvent e) {
      
        
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        
        
    }
}