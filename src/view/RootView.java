package view;

/**
 * RootView
 */
public class RootView {

    // JFrame class or Main Application
    private CoffeeFrame frame;

    public RootView() {
        frame = new CoffeeFrame();
    }

    public CoffeeFrame getFrame() {
        return frame;
    }

}
