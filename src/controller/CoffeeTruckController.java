package controller;

import view.ConsoleView;

/**
 * CoffeeTruckController
 */
public class CoffeeTruckController {

    private ConsoleView view;
    private Integer mainMenuState;

    public CoffeeTruckController(ConsoleView view) {
        this.mainMenuState = -1;
        this.view = view;
    }

    public void run() {
        while (mainMenuState != 0) {
            this.view.displayMainMenu();

            while (mainMenuState < 0 && mainMenuState > 3) {
                mainMenuState = view.getMenuInput();
                switch (mainMenuState) {
                    case 0:
                        mainMenuState = 0;
                        break;
                    case 1:
                        // displayCreateTruck();
                        break;
                    case 2:
                        // displayExistingTrucks();
                        break;
                    case 3:
                        // displayBusinessDashboard();
                        break;
                }
            }
        }
    }

}
