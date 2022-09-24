import javax.swing.*;
public class Frame extends JFrame
{
    private Panel panel;

    public Frame()
    {
        panel = new Panel();
        this.add(panel);
        panel.setVisible(true);

        this.setSize(1200,800);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }


}