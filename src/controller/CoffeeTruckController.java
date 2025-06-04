package controller;

import view.ConsoleView;

/**
 * CoffeeTruckController
 */
public class CoffeeTruckController {

    private ConsoleView view;
    private Integer mainMenuState;
    private Integer createTruckState;
    private Integer selectTruckState;

    public CoffeeTruckController(ConsoleView view) {
        this.mainMenuState = -1;
        this.createTruckState = -1;
        this.selectTruckState = -1;
        this.view = view;
    }

    public void run() {
        while (mainMenuState != 0) {
            view.displayMainMenu();

            do {
                mainMenuState = view.getMenuInput();

                if (mainMenuState < 0 || mainMenuState > 3) {
                    System.out.println("Invalid Input");
                }
            } while (mainMenuState < 0 || mainMenuState > 3);

            createTruckState = -1;
            selectTruckState = -1;

            switch (mainMenuState) {
                case 0:
                    mainMenuState = 0;
                    break;
                case 1:
                    runCreateTruck();
                    break;
                case 2:
                    view.displayExistingTrucks();
                    break;
                case 3:
                    // view.displayBusinessDashboard();
                    break;
            }
        }
    }

    public void runCreateTruck() {
        while (createTruckState != 0) {
            view.displayCreateTruck();

            do {
                createTruckState = view.getMenuInput();

                if (createTruckState < 0 || createTruckState > 3) {
                    System.out.println("Invalid Input");
                }
            } while (createTruckState < 0 || createTruckState > 3);

            mainMenuState = -1;
            selectTruckState = -1;

            switch (createTruckState) {
                case 0:
                    createTruckState = 0;
                    break;
                case 1:
                    // runCreateRegularTruck();
                    break;
                case 2:
                    // runCreateSpecialTruck();
                    break;
            }
        }
    }

    // FIX FOR DYNAMIC NUMBER OF TRUCKS
    // public void runExistingTrucks() {
    // while (selectTruckState != 0) {
    // view.displayExistingTrucks();
    //
    // do {
    // selectTruckState = view.getMenuInput();
    //
    // if (selectTruckState < 0 || selectTruckState > 3) {
    // System.out.println("Invalid Input");
    // }
    // } while (selectTruckState < 0 || selectTruckState > 3);
    //
    // createTruckState = -1;
    // mainMenuState = -1;
    //
    // switch (selectTruckState) {
    // case 0:
    // selectTruckState = 0;
    // break;
    // case 1:
    // // runCreateRegularTruck();
    // break;
    // case 2:
    // // runCreateSpecialTruck();
    // break;
    // }
    // }
    // }
}
