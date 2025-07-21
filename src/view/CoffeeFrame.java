package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * CoffeeFrame
 */
public class CoffeeFrame extends JFrame implements ActionListener {

    private Color blue;
    private Color red;
    private Color cream;
    private Color brown;
    private Color textColor;
    private ArrayList<JButton> menuList = new ArrayList<JButton>();
    private JButton button;

    public CoffeeFrame() {
        blue = new Color(0x73a1fb);
        red = new Color(0xdb380e);
        cream = new Color(0xFFDBB5);
        brown = new Color(0x603F26);

        button = new JButton();

        this.setTitle("JavaJeeps Dashboard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280, 720);
        this.setVisible(true);

        ImageIcon image = new ImageIcon("../assets/logo.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(0x73a1fb));

        button.setLayout(null);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("batukam");
        }
    }

}
