package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code CoffeeFrame} class represents the main window of the JavaJeeps Dashboard.
 * It uses a layered pane to display a decorative background with a bean trail and
 * provides an area for switching between different panels or views.
 */
public class CoffeeFrame extends JFrame {

    /** The background color used for the frame, a light red tone. */
    private Color lightRed = new Color(248, 218, 217);

    /** The layered pane that allows stacking of the background and content panels. */
    private JLayeredPane layeredPane;

    /** The panel used to display the currently active page or screen. */
    private JPanel contentPanel;

    /**
     * Constructs a new {@code CoffeeFrame} with a decorative background,
     * a layered pane for content, and sets frame properties such as size and icon.
     */
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

    /**
     * Sets the current page to be displayed on the content panel.
     *
     * @param panel the panel to display in the center of the frame
     */
    public void setPage(JPanel panel) {
        panel.setOpaque(false); // allow transparency
        contentPanel.removeAll();
        contentPanel.add(panel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    /**
     * A custom panel that paints a decorative background with a bean trail
     * on the left and images on the right side.
     */
    private static class BackgroundPanel extends JPanel {

        /** The image used to create the bean trail. */
        private final Image beanImage;

        /** A list of images displayed on the right side of the background. */
        private final List<Image> rightImages = new ArrayList<>();

        /**
         * Constructs the background panel with a solid background color,
         * loads the bean image and decorative images from assets.
         */
        public BackgroundPanel() {
            this.setOpaque(true); // paint background
            this.setBackground(new Color(248, 218, 217)); // lightRed
            this.beanImage = new ImageIcon("src/assets/bean.png").getImage();

            // Load right-side decorative assets
            rightImages.add(new ImageIcon("src/assets/dahon.png").getImage());
            rightImages.add(new ImageIcon("src/assets/sprinkler.png").getImage());
            rightImages.add(new ImageIcon("src/assets/cup.png").getImage());
            rightImages.add(new ImageIcon("src/assets/bag.png").getImage());
            rightImages.add(new ImageIcon("src/assets/donut.png").getImage());
        }

        /**
         * Paints the background, bean trail, and decorative images.
         *
         * @param g the Graphics context used for rendering
         */
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
