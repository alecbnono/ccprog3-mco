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

    /**
     * Constructs a new CoffeeTruckController instance.
     * 
     * Initializes the controller with default state values and links it to the
     * provided ConsoleView instance for user interaction. Also initializes the
     * CoffeeBusiness model which manages all trucks and business data.
     * 
     * @param view the ConsoleView instance responsible for displaying menus and
     *             reading user input
     */
    public CoffeeTruckController(ConsoleView view) {
        this.mainMenuState = -1;
        this.createTruckState = -1;
        this.selectTruckState = -1;
        this.truckInteractionState = -1;
        this.model = new CoffeeBusiness();
        this.view = view;
    }

    /**
     * Runs the main loop of the coffee truck application.
     * 
     * Continuously displays the main menu and processes user input until the user
     * chooses to exit. Depending on the selected menu option, this method routes
     * the user to create a new truck, manage existing trucks, or view the
     * dashboard.
     */
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

    /**
     * Resets the controller state variables except for the one specified to keep.
     * 
     * Each state variable controls the flow within a specific section of the
     * application. This method resets all unused states to their default value
     * (-1),
     * while preserving the state specified by the parameter.
     * 
     * @param keep the name of the state to preserve (e.g. "mainMenu",
     *             "createTruck")
     */
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

    /**
     * Returns an Item object based on the given input code.
     * 
     * The input corresponds to a predefined item type:
     * C/c - Coffee Beans
     * F/f - Full Cream Milk
     * W/w - Water
     * S/s - Small Cup
     * M/m - Medium Cup
     * L/l - Large Cup
     * 
     * If the input does not match any known item code, the method returns null.
     * 
     * @param input the item code entered by the user
     * @return the corresponding Item instance, or null if input is invalid
     */
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

    /**
     * Performs a linear search on the given array to check for a matching string.
     * 
     * This method searches the first n elements of the array for a string equal to
     * the key.
     * 
     * @param A   the array to search
     * @param n   the number of elements to search within the array
     * @param key the string to search for
     * @return true if the key is found, false otherwise
     */
    private boolean linearSearch(String[] A, int n, String key) {
        for (int i = 0; i < n; i++) {
            if (key.equals(A[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sets the initial inventory for a given coffee truck by assigning items and
     * quantities
     * to each of its storage bins.
     * 
     * Prompts the user for each bin to select an item type or to empty the bin. If
     * an item
     * is selected, the user is also prompted to enter the quantity, which must not
     * exceed the
     * maximum capacity of the bin.
     * 
     * @param truck the CoffeeTruck instance whose bins are being initialized
     */
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

            boolean valid;

            do {
                System.out.printf("\n>>> Set bin #%d content: ", i + 1);
                input = view.getTextInput();
                valid = linearSearch(validInputs, MAX_INPUTS, input);
                if (!valid) {
                    System.out.println("Invalid Input");
                }
            } while (!valid);

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

    /**
     * Allows the user to set or update the pricing of drinks in the business.
     * 
     * Prompts the user for a valid price for each drink in the price list.
     * Prices must be greater than zero. Invalid inputs are rejected.
     */
    private void setPrices() {
        double input;

        System.out.println("\nSet Pricing: ");
        view.displayPricingHeader();

        for (int i = 0; i < model.getPriceList().size(); i++) {

            do {
                System.out.printf("  %10s   %1s : ",
                        model.getPriceList().get(i).getProduct(),
                        model.getPriceList().get(i).getSize());
                input = view.getNumInput();
                if (input <= 0) {
                    System.out.println("Invalid Input");
                }

            } while (input <= 0);

            model.getPriceList().get(i).updatePrice(input);
        }

        System.out.println("============================\n");
    }

    /**
     * Creates a new coffee truck of the specified type and sets its location,
     * inventory, and prices.
     * 
     * After creating the truck, the user is prompted to set up the truck's initial
     * inventory loadout
     * and drink pricing. The number of bins is based on the truck type.
     * 
     * @param type the type of truck to create (e.g., "regular" or "special")
     */
    private void createTruck(String type) {
        String typeString = type.substring(0, 1).toUpperCase() + type.substring(1);
        String location;
        int binCount = 0;
        int truckNo = 0;

        System.out.println();
        view.displaySetTruckLoc();
        view.getTextInput(); // input flush
        location = view.getTextInput();
        model.createTruck(location, type);

        truckNo = model.getTruckCount() - 1;
        binCount = model.getTruck(truckNo).getBinCount();

        System.out.println();
        System.out.printf(">>> %s Coffee Truck created at %s with %d storage bins.\n", typeString, location, binCount);
        System.out.println("Please set initial loadout.\n");

        setInventory(model.getTruck(truckNo));
        setPrices();
    }

    /**
     * Runs the menu for creating a new coffee truck.
     * 
     * Allows the user to choose between creating a Regular Coffee Truck or exiting.
     * Special Coffee Trucks are currently not implemented but are mentioned in the
     * menu.
     * If a valid selection is made, the truck creation process is initiated.
     */
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

    /**
     * Handles the restocking process for a specific coffee truck.
     * 
     * The user is prompted to choose a bin to restock. If the selected bin is
     * empty,
     * the user must select an item type from a list of valid item codes. Once the
     * bin
     * has a defined item, the user is prompted to enter a quantity to add or type
     * "E"
     * to empty the bin. All input is validated, and the process repeats until the
     * user
     * chooses not to continue.
     * 
     * @param truck the CoffeeTruck instance whose inventory is being restocked
     */
    private void runTruckRestock(CoffeeTruck truck) {

        int input = -1;
        String charInput = null;
        String loop = "Y";
        String quantity;
        double parsedQuantity;
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
                if (input < 1 || input > truck.getBinCount()) {
                    System.out.println("Invalid Input");
                }
            } while (input < 1 || input > truck.getBinCount());

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
                if (quantity.equalsIgnoreCase("E")) {
                    break; // valid input, will handle "empty" logic after loop
                }

                try {
                    parsedQuantity = Double.parseDouble(quantity);
                    if (parsedQuantity < 0) {
                        System.out.println("❌ Quantity cannot be negative.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ Invalid input. Enter a number or 'E'.");
                    parsedQuantity = -1; // force loop to repeat
                }
            } while (parsedQuantity < 0 && !quantity.equalsIgnoreCase("E"));

            if (quantity.equalsIgnoreCase("e")) {
                truck.getBin(input - 1).emptyBox();
                System.out.printf(">>> Bin #%d updated: Empty\n", input);

            } else {
                truck.getBin(input - 1).restock(Double.parseDouble(quantity));
                System.out.printf(">>> Bin #%d updated: %s - %.2f %s\n", input,
                        truck.getBin(input - 1).getBox().getName(),
                        truck.getBin(input - 1).getBox().getQuantity(),
                        truck.getBin(input - 1).getBox().getUnit());
            }

            do {
                System.out.printf("\n>>> Restock Again? [Y/N]: ");
                loop = view.getTextInput();
                if (!loop.equalsIgnoreCase("Y") && !loop.equalsIgnoreCase("N")) {
                    System.out.println("Invalid Input");
                }
            } while (!loop.equalsIgnoreCase("Y") && !loop.equalsIgnoreCase("N"));

            input = -1;
            quantity = null;
        }
    }

    /**
     * Displays the list of existing coffee trucks and prompts the user to select
     * one.
     * 
     * The method validates the user’s input to ensure it corresponds to a valid
     * truck
     * index. It returns the selected truck number (1-based index) or 0 if the user
     * exits.
     * 
     * @return the index of the selected truck or 0 if the user chooses to exit
     */
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

    /**
     * Allows the user to update the price of drinks in the price list.
     * 
     * The user is prompted to select an item by its number and provide a new price.
     * Input is validated to ensure the item number is within range and the new
     * price is greater than zero.
     * After updating, the user is asked if they want to update another item.
     */
    private void runTruckUpdatePrice() {

        String loop = "Y";
        int input;
        double price;

        view.displayUpdatePrices(model);

        while (loop.equalsIgnoreCase("Y")) {

            do {
                System.out.printf("\n>>> Which item would you like its price updated: ");
                input = view.getIntInput();
                if (input < 1 || input > model.getPriceList().size()) {
                    System.out.println("Invalid Input");
                }
            } while (input < 1 || input > model.getPriceList().size());

            do {
                System.out.printf("\nSet price: ");
                price = view.getNumInput();
                if (price <= 0) {
                    System.out.println("Invalid Input");
                }
            } while (price <= 0);

            model.getPriceList().get(input - 1).updatePrice(price);

            do {
                System.out.printf("\n>>> Update Price Again? [Y/N]: ");
                loop = view.getTextInput();
                if (!loop.equalsIgnoreCase("Y") && !loop.equalsIgnoreCase("N")) {
                    System.out.println("Invalid Input");
                }
            } while (!loop.equalsIgnoreCase("Y") && !loop.equalsIgnoreCase("N"));

            input = -1;
            price = -1;
        }
    }

    /**
     * Prompts the user to set a new location for the specified coffee truck.
     * 
     * The current location is displayed, and the user is asked to enter a new one.
     * The truck's location is then updated to the new input.
     * 
     * @param truck the CoffeeTruck instance whose location is to be changed
     */
    private void runChangeLocation(CoffeeTruck truck) {
        String input = null;

        System.out.println(">>> Current Truck Location - %s\n");
        System.out.printf("New Location: ");
        input = view.getTextInput();
        truck.setLocation(input);
    }

    /**
     * Simulates coffee sales for a given truck.
     * 
     * Displays the drink price list and allows the user to select a drink to order.
     * The method checks inventory availability and either serves the drink or
     * displays a cancellation message.
     * After a successful sale, the receipt is shown and sales data is recorded.
     * The user is prompted whether to place another order.
     * 
     * @param truck the CoffeeTruck instance used in the simulation
     */
    private void runTruckSimulation(CoffeeTruck truck) {

        int input;
        String coffee;
        String size;
        double price;
        boolean completeOrder;
        String loop = "Y";

        while (loop.equalsIgnoreCase("Y")) {

            completeOrder = true;
            view.displayUpdatePrices(model);

            do {
                System.out.printf("Select Drink: ");
                input = view.getIntInput();
                if (input < 1 || input > model.getPriceList().size()) {
                    System.out.println("Invalid Input");
                }
            } while (input < 1 || input > model.getPriceList().size());

            coffee = model.getPriceList().get(input - 1).getProduct().toLowerCase();
            size = model.getPriceList().get(input - 1).getSizeFull();
            price = model.getPriceList().get(input - 1).getPrice();

            if (!truck.serveCoffee(coffee, size)) {
                completeOrder = false;
            }

            if (completeOrder) {

                view.displayReceipt(model, truck, input - 1, price);
                model.addSales(coffee, price);

            } else {
                view.displayCancelledOrder();
            }

            do {
                System.out.printf("\n>>> Order Again? [Y/N]: ");
                loop = view.getTextInput();
                if (!loop.equalsIgnoreCase("Y") && !loop.equalsIgnoreCase("N")) {
                    System.out.println("Invalid Input");
                }
            } while (!loop.equalsIgnoreCase("Y") && !loop.equalsIgnoreCase("N"));

            input = -1;
        }
    }

    /**
     * Runs the truck interaction menu for managing a specific coffee truck.
     * 
     * Displays options that allow the user to:
     * 1. Simulate a coffee sale
     * 2. View truck information and prices
     * 3. Restock or maintain truck inventory
     * 4. Update drink prices
     * 5. Change the truck's location
     * 
     * The user is first prompted to choose an interaction option, followed by
     * selecting
     * a specific truck from the list. If a valid truck is selected, the
     * corresponding
     * operation is performed. The loop continues until the user selects the exit
     * option.
     */
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
                        runTruckSimulation(model.getTruck(selectedTruck - 1));
                        break;
                    case 2:
                        // view truck and prices
                        view.displayTruckInfo(model, model.getTruck(selectedTruck - 1), selectedTruck);
                        break;
                    case 3:
                        // restock truck
                        runTruckRestock(model.getTruck(selectedTruck - 1));
                        break;
                    case 4:
                        // update prices
                        runTruckUpdatePrice();
                        break;
                    case 5:
                        // change location
                        runChangeLocation(model.getTruck(selectedTruck - 1));
                        break;
                    default:
                        break;
                }
            }

            resetState("truckInteraction");
        }
    }

}
