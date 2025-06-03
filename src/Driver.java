import view.ConsoleView;
import controller.CoffeeTruckController;

/**
 * Driver
 */
public class Driver {

    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        CoffeeTruckController controller = new CoffeeTruckController(view);
        controller.run();
    }
}
