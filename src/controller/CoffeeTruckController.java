package controller;

import model.*;
import view.ConsoleView;

/**
 * CoffeeTruckController
 */
public class CoffeeTruckController {

    // Model
    private CoffeeBusiness model;

    // View
    private ConsoleView view;

    // Controller state management
    private int mainMenuState;
    private int createTruckState;
    private int selectTruckState;
    private int truckInteractionState;

    public CoffeeTruckController(ConsoleView view) {
        this.mainMenuState = -1;
        this.createTruckState = -1;
        this.selectTruckState = -1;
        this.truckInteractionState = -1;
        this.model = new CoffeeBusiness();
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

            resetState("mainMenu");

            switch (mainMenuState) {
                case 1:
                    runCreateTruck();
                    break;
                case 2:
                    runTruckInteractions();
                    break;
                case 3:
                    view.displayDashboard(model);
                    break;
            }
        }
    }

    private void resetState(String keep) {

        if (!keep.equals("mainMenu"))
            this.mainMenuState = -1;
        if (!keep.equals("createTruck"))
            this.createTruckState = -1;
        if (!keep.equals("selectTruck"))
            this.selectTruckState = -1;
        if (!keep.equals("truckInteraction"))
            this.truckInteractionState = -1;

    }

    private Item chooseItem(String input) {
        switch (input) {
            case "C":
            case "c":
                return new CoffeeBeans();
            case "F":
            case "f":
                return new Liquid("Milk");
            case "W":
            case "w":
                return new Liquid("Water");
            case "S":
            case "s":
                return new Cup("Small");
            case "M":
            case "m":
                return new Cup("Medium");
            case "L":
            case "l":
                return new Cup("Large");
            default:
                return null;
        }
    }

    private boolean linearSearch(String[] A, int n, String key) {
        for (int i = 0; i < n; i++) {
            if (key.equals(A[i])) {
                return true;
            }
        }
        return false;
    }

    private void setInventory(CoffeeTruck truck) {

        String input = null;
        double quantity = 0;
        final int MAX_INPUTS = 14;
        String[] validInputs = { "C", "c",
                "F", "f",
                "W", "w",
                "S", "s",
                "M", "m",
                "L", "l",
                "E", "e" };

        view.displayRestockLegend();

        for (int i = 0; i < truck.getBinCount(); i++) {

            do {
                System.out.printf("\n>>> Set bin #%d content: ", i + 1);
                input = view.getTextInput();
                if (!linearSearch(validInputs, MAX_INPUTS, input)) {
                    System.out.println("Invalid Input");
                }
            } while (!linearSearch(validInputs, MAX_INPUTS, input));

            if (input.equalsIgnoreCase("e")) {
                truck.getBin(i).emptyBox();

            } else {
                truck.getBin(i).setBox(chooseItem(input));

                System.out.printf("Set quantity for bin #%d (%s) capped at (%d %s): ",
                        i + 1,
                        truck.getBin(i).getBox().getUnit(),
                        (int) truck.getBin(i).getBox().getMaxQuantity(),
                        truck.getBin(i).getBox().getUnit());
                quantity = view.getNumInput();

                truck.getBin(i).restock(quantity);
            }

            input = null;
            quantity = 0;
        }
    }

    private void createTruck(String type) {
        String typeString = type.substring(0, 1).toUpperCase() + type.substring(1);
        String location;
        int binCount = 0;
        int truckNo = 0;

        System.out.println();
        view.displaySetTruckLoc();
        location = view.getTextInput();
        model.createTruck(location, type);

        truckNo = model.getTruckCount() - 1;
        binCount = model.getTruck(truckNo).getBinCount();

        System.out.println();
        System.out.printf(">>> %s Coffee Truck created at %s with %d storage bins.\n", typeString, location, binCount);
        System.out.println("Please set initial loadout.\n");

        setInventory(model.getTruck(truckNo));
    }

    private void runCreateTruck() {

        while (createTruckState != 0) {
            view.displayCreateTruck();

            do {
                createTruckState = view.getMenuInput();

                if (createTruckState < 0 || createTruckState > 2) {
                    System.out.println("Invalid Input");
                } else if (createTruckState == 2) {
                    System.out.println("Special Coffee Trucks Coming Soon");
                }
            } while (createTruckState < 0 || createTruckState > 1);

            resetState("createTruck");

            switch (createTruckState) {
                case 1:
                    createTruck("regular");
                    break;
                case 2:
                    createTruck("special");
                    break;
            }
        }
    }

    private void runTruckRestock(CoffeeTruck truck) {

        int input = -1;
        String charInput = null;
        String loop = "Y";
        String quantity;
        final int MAX_INPUTS = 14;
        String[] validInputs = { "C", "c",
                "F", "f",
                "W", "w",
                "S", "s",
                "M", "m",
                "L", "l",
                "E", "e" };

        view.displayRestockTruck(truck);

        while (loop.equalsIgnoreCase("Y")) {
            do {
                System.out.printf("\n>>> Which bin no. would you like to restock?: ");
                input = view.getIntInput();
                if (input < 0 || input > truck.getBinCount()) {
                    System.out.println("Invalid Input");
                }
            } while (input < 0 || input > truck.getBinCount());

            if (truck.getBin(input - 1).isEmpty()) {
                view.displayRestockLegend();
                do {
                    System.out.printf("\n>>> Set bin #%d content: ", input);
                    charInput = view.getTextInput();
                    if (!linearSearch(validInputs, MAX_INPUTS, charInput)) {
                        System.out.println("Invalid Input");
                    }
                } while (!linearSearch(validInputs, MAX_INPUTS, charInput));

                truck.getBin(input - 1).setBox(chooseItem(charInput));
            }

            System.out.printf("Current Item: %s\n", truck.getBin(input - 1).getBox().getName());

            do {
                System.out.printf("Add quantity or enter \"E\" to empty (Max capacity: %d %s): ",
                        (int) truck.getBin(input - 1).getBox().getMaxQuantity(),
                        truck.getBin(input - 1).getBox().getUnit());
                quantity = view.getTextInput();
                if (Double.parseDouble(quantity) < 0 || quantity.equalsIgnoreCase("E")) {
                    System.out.println("Invalid Input");
                }
            } while (Double.parseDouble(quantity) < 0 || quantity.equalsIgnoreCase("E"));

            if (quantity.equalsIgnoreCase("e")) {
                truck.getBin(input - 1).emptyBox();

            } else {
                truck.getBin(input - 1).restock(Double.parseDouble(quantity));
            }

            System.out.printf(">>> Bin #%d updated: %s - %.2f %s\n", input,
                    truck.getBin(input - 1).getBox().getName(),
                    truck.getBin(input - 1).getBox().getQuantity(),
                    truck.getBin(input - 1).getBox().getUnit());

            do {
                System.out.printf("\n>>> Restock Again? : ");
                loop = view.getTextInput();
                if (!loop.equalsIgnoreCase("Y") && !loop.equalsIgnoreCase("N")) {
                    System.out.println("Invalid Input");
                }
            } while (!loop.equalsIgnoreCase("Y") && !loop.equalsIgnoreCase("N"));

            input = -1;
            quantity = null;
        }
    }

    private int runExistingTrucks() {

        view.displayExistingTrucks(model);

        do {
            selectTruckState = view.getMenuInput();

            if (selectTruckState < 0 || selectTruckState > model.getTruckCount()) {
                System.out.println("Invalid Input");
            }
        } while (selectTruckState < 0 || selectTruckState > model.getTruckCount());

        return selectTruckState;
    }

    private void runTruckInteractions() {

        int selectedTruck;

        while (truckInteractionState != 0) {
            view.displayTruckInteractions();
            do {
                truckInteractionState = view.getMenuInput();

                if (truckInteractionState < 0 || truckInteractionState > 4) {
                    System.out.println("Invalid Input");
                }
            } while (truckInteractionState < 0 || truckInteractionState > 4);

            selectedTruck = runExistingTrucks();

            // if exit not selected then proceed
            // with truck interactions
            if (selectedTruck != 0) {
                switch (truckInteractionState) {
                    case 1:
                        // simulate truck
                        break;
                    case 2:
                        // view truck and prices
                        view.displayTruckInfo(model.getTruck(selectedTruck - 1), selectedTruck);
                        break;
                    case 3:
                        // restock truck
                        runTruckRestock(model.getTruck(selectedTruck - 1));
                        break;
                    case 4:
                        // update prices
                        break;
                    default:
                        break;
                }
            }

            resetState("truckInteraction");
        }
    }

}
