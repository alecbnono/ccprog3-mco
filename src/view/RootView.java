package view;

/**
 * The {@code RootView} class serves as the entry point to the user interface
 * by initializing the main application frame ({@code CoffeeFrame}).
 * It acts as a container or root for the entire UI.
 */
public class RootView {

    /** The main application frame that displays the GUI components. */
    private CoffeeFrame frame;

    /**
     * Constructs a new {@code RootView} and initializes the main frame.
     */
    public RootView() {
        frame = new CoffeeFrame();
    }

    /**
     * Returns the main application frame.
     *
     * @return the {@code CoffeeFrame} instance representing the main window
     */
    public CoffeeFrame getFrame() {
        return frame;
    }

}
