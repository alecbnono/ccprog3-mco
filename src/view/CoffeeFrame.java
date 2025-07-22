package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * CoffeeFrame
 */
public class CoffeeFrame extends JFrame {

    private Color blue;
    private Color red;
    private Color cream;
    private Color brown;
    private Color textColor;

    public CoffeeFrame() {
        blue = new Color(0x73a1fb);
        red = new Color(0xdb380e);
        cream = new Color(0xFFDBB5);
        brown = new Color(0x603F26);

        this.setTitle("JavaJeeps Dashboard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280, 720);
        this.setVisible(true);

        ImageIcon image = new ImageIcon("../assets/logo.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(0x73a1fb));
    }

    public void setPage(JPanel panel) {
        this.getContentPane().removeAll();
        this.getContentPane().add(panel);
        this.revalidate();
        this.repaint();
    }
}
