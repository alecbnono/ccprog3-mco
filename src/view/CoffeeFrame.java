package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
/**
 * CoffeeFrame with bean trail on the left side.
 */
public class CoffeeFrame extends JFrame {

    private Color lightRed = new Color(248, 218, 217);
    private JLayeredPane layeredPane;
    private JPanel contentPanel;

    public CoffeeFrame() {
        this.setTitle("JavaJeeps Dashboard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null); // center on screen

        // App icon
        ImageIcon image = new ImageIcon("src/assets/logo.png");
        this.setIconImage(image.getImage());

        // Create layered pane
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1280, 720));

        // Background panel with bean trail
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setBounds(0, 0, 1280, 720);
        layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);

        // Transparent content panel (used for switching screens)
        contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setBounds(0, 0, 1280, 720);
        contentPanel.setLayout(new BorderLayout());
        layeredPane.add(contentPanel, JLayeredPane.PALETTE_LAYER);

        this.setContentPane(layeredPane);
        this.setVisible(true);
    }

    public void setPage(JPanel panel) {
        panel.setOpaque(false); // allow transparency
        contentPanel.removeAll();
        contentPanel.add(panel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    /**
     * Custom background panel with bean trail and right-side decorations.
     */
    private static class BackgroundPanel extends JPanel {
        private final Image beanImage;
        private final List<Image> rightImages = new ArrayList<>();

        public BackgroundPanel() {
            this.setOpaque(true); // paint background
            this.setBackground(new Color(248, 218, 217)); // lightRed
            this.beanImage = new ImageIcon("src/assets/bean.png").getImage();

            // Load right-side decorative assets (add as needed)
            rightImages.add(new ImageIcon("src/assets/dahon.png").getImage());
            rightImages.add(new ImageIcon("src/assets/sprinkler.png").getImage());
            rightImages.add(new ImageIcon("src/assets/cup.png").getImage());
            rightImages.add(new ImageIcon("src/assets/bag.png").getImage());
            rightImages.add(new ImageIcon("src/assets/donut.png").getImage());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Paint background
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());

            // Draw bean trail on the left side
            int y = 0;
            int spacing = 120;
            int xOffset = -10; // further left if needed
            int beanWidth = 128;
            int beanHeight = 128;

            while (y < getHeight()) {
                g.drawImage(beanImage, xOffset, y, beanWidth, beanHeight, this);
                y += spacing;
            }

            // Draw images on the right side
            int rightX = getWidth() - 150; // distance from right edge
            int rightY = 20;
            int rightSpacing = 120;
            int imgWidth = 128;
            int imgHeight = 128;

            for (Image img : rightImages) {
                g.drawImage(img, rightX, rightY, imgWidth, imgHeight, this);
                rightY += rightSpacing;
            }
        }
    }
}

