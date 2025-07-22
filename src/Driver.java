import controller.MasterController;
import view.RootView;
// import model.CoffeeBusiness;

/**
 * Driver
 */
public class Driver {

    public static void main(String[] args) {

        // CoffeeBusiness model = new CoffeeBusiness();

        RootView view = new RootView();

        MasterController controller = new MasterController(view);
    }
}
