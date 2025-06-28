package view;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import model.*;

/**
 * ConsoleView
 */

public class ConsoleView {

    private Scanner scanner;

    /**
     * Constructs a ConsoleView instance and initializes the Scanner
     * for reading user input from the standard input stream (System.in).
     * 
     * This Scanner will be used for all user interactions in the console-based
     * interface.
     */
    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu for the JavaJeeps coffee truck management system.
     * 
     * This menu provides the user with the following options:
     * 1. Create a new coffee truck
     * 2. Manage existing trucks
     * 3. View the business dashboard
     * 0. Exit the program
     * 
     * This method is typically invoked at the start of the program or when
     * returning to the main screen.
     */
    public void displayMainMenu() {
        System.out.println("============================");
        System.out.println("|         JavaJeeps        |");
        System.out.println("============================");
        System.out.println("[1] Create Coffee Truck");
        System.out.println("[2] Manage Existing Trucks");
        System.out.println("[3] View Business Dashboard");
        System.out.println("[0] Exit");
        System.out.println("============================");
    }

    /**
     * Displays the menu for creating a new coffee truck.
     * 
     * Provides the user with the option to create either a Regular Truck (JavaJeep)
     * or a Special Truck (JavaJeep+). Also includes an option to exit the menu.
     */
    public void displayCreateTruck() {
        System.out.println("============================");
        System.out.println("|    Select Coffee Truck   |");
        System.out.println("|         to create        |");
        System.out.println("============================");
        System.out.println("[1] Regular Truck (JavaJeep)");
        System.out.println("[2] Special Truck (JavaJeep+)");
        System.out.println("[0] Exit");
        System.out.println("============================");
    }

    /**
     * Prompts the user to enter a location for a newly created coffee truck.
     * 
     * This method outputs a single line asking the user to input a location string.
     */
    public void displaySetTruckLoc() {
        System.out.print("Enter location for this truck: ");
    }

    /**
     * Displays a list of existing coffee trucks managed by the business.
     * 
     * Each truck is listed with its corresponding index number and location.
     * The user can select a truck to manage or choose to exit the menu.
     * 
     * @param business the CoffeeBusiness instance containing the list of trucks
     */
    public void displayExistingTrucks(CoffeeBusiness business) {
        System.out.println("============================");
        System.out.println("|      Select Existing     |");
        System.out.println("|       Coffee Truck       |");
        System.out.println("============================");

        for (int i = 0; i < business.getTruckCount(); i++) {
            System.out.printf("[%d] %s\n", i + 1, business.getTruck(i).getLocation());
        }

        System.out.println("[0] Exit");
        System.out.println("============================");
    }

    /**
     * Displays the menu for available truck interactions.
     * 
     * Allows the user to:
     * 1. Simulate coffee sales with the selected truck
     * 2. View truck information including type, location, and inventory
     * 3. Restock or maintain the truck's inventory
     * 4. Update or view the price list of drinks
     * 0. Exit the truck interaction menu
     */
    public void displayTruckInteractions() {
        System.out.println("============================");
        System.out.println("| Select Truck Interaction |");
        System.out.println("============================");
        System.out.println("[1] Simulate Truck");
        System.out.println("[2] View Truck Information");
        System.out.println("[3] Restock / Maintain Truck");
        System.out.println("[4] Update / View Prices");
        System.out.println("[5] Change Truck Location");
        System.out.println("[0] Exit");
        System.out.println("============================");
    }

    /**
     * Displays the information of a specific coffee truck.
     * 
     * This includes the truck number, type, and location. It also shows the menu
     * prices
     * and the current inventory status of the truck.
     * 
     * @param business the CoffeeBusiness instance managing the truck
     * @param truck    the CoffeeTruck instance whose details are being displayed
     * @param truckNo  the numerical identifier of the truck (1-based index)
     */
    public void displayTruckInfo(CoffeeBusiness business, CoffeeTruck truck, int truckNo) {
        System.out.printf("Truck #%d\n", truckNo);
        System.out.printf("%-8s: %s\n", "Type",
                truck.getType().substring(0, 1).toUpperCase() + truck.getType().substring(1));
        System.out.printf("%-8s: %s\n\n", "Location", truck.getLocation());
        System.out.println("Menu Prices: ");
        displayPrices(business);
        displayRestockTruck(truck);
    }

    /**
     * Displays the current inventory status of a coffee truck.
     * 
     * For each bin in the truck, this method shows the item name, quantity, and
     * unit.
     * If the bin contains cups, the quantity is displayed without decimals.
     * Empty bins are labeled as "Empty".
     * 
     * @param truck the CoffeeTruck instance whose inventory is being displayed
     */
    public void displayRestockTruck(CoffeeTruck truck) {
        System.out.println("Total Inventory: ");
        System.out.println("============================");
        for (int i = 0; i < truck.getBinCount(); i++) {
            if (!truck.getBin(i).isEmpty()) {
                // omit decimals on cup count
                if (truck.getBin(i).getBox().getUnit().equals("pcs")) {
                    System.out.printf("[%d] %-12s %2d %-6s\n",
                            i + 1,
                            truck.getBin(i).getBox().getName(),
                            (int) truck.getBin(i).getBox().getQuantity(),
                            truck.getBin(i).getBox().getUnit());

                } else {
                    System.out.printf("[%d] %-12s %4.2f %-6s\n",
                            i + 1,
                            truck.getBin(i).getBox().getName(),
                            truck.getBin(i).getBox().getQuantity(),
                            truck.getBin(i).getBox().getUnit());
                }
            } else {
                System.out.printf("[%d] Empty\n", i + 1);
            }
        }
        System.out.println("============================\n");
    }

    /**
     * Prompts the user to set the content of a specific storage bin.
     * 
     * This message is shown during the restocking process to ask for the item type
     * to be placed in the specified bin.
     * 
     * @param binNo the bin number (1-based index) being configured
     */
    public void displayRestockItem(int binNo) {
        System.out.printf("Set bin #%d content: ", binNo);
    }

    /**
     * Prompts the user to input the quantity for a specific bin.
     * 
     * This message is shown after selecting the item to restock, asking the user
     * to input the amount of the item to be added to the bin.
     * 
     * @param binNo the bin number (1-based index) being restocked
     */
    public void displayRestockQuantity(int binNo) {
        System.out.printf("Set quantity for bin #%d", binNo);
    }

    /**
     * Displays the legend of valid input options for restocking bins.
     * 
     * This legend includes all valid item codes that the user can enter to restock
     * a bin. Each code corresponds to a specific ingredient or cup size, including:
     * - C: Coffee Beans
     * - F: Full Cream Milk
     * - W: Water
     * - S: Small Cup
     * - M: Medium Cup
     * - L: Large Cup
     * - E: Empty Box (to clear the bin)
     */
    public void displayRestockLegend() {
        System.out.println("============================");
        System.out.println("|   Enter 1 of the items   |");
        System.out.println("============================");
        System.out.println("[C]offee Beans");
        System.out.println("[F]ull Cream Milk");
        System.out.println("[W]ater");
        System.out.println("[S]mall Cup");
        System.out.println("[M]edium Cup");
        System.out.println("[L]arge Cup");
        System.out.println("[E]mpty Box");
        System.out.println("============================");
    }

    /**
     * Displays the full business dashboard for the JavaJeeps coffee truck system.
     * 
     * This includes the following sections:
     * - Total number of trucks, including breakdown by truck type (regular and
     * special)
     * - List of truck locations
     * - Combined sales revenue from all trucks, broken down by drink type and total
     * revenue
     * - Aggregate inventory from all trucks, grouped by item name, quantity, and
     * unit
     * 
     * The method manually aggregates inventory without using hash maps by
     * maintaining
     * parallel ArrayLists for item names, quantities, and units.
     * 
     * @param business the CoffeeBusiness instance containing all trucks and
     *                 transaction data
     */
    public void displayDashboard(CoffeeBusiness business) {

        ArrayList<String> itemNames = new ArrayList<>();
        ArrayList<Double> itemQuantities = new ArrayList<>();
        ArrayList<String> itemUnits = new ArrayList<>();

        for (int i = 0; i < business.getTruckCount(); i++) {
            for (int j = 0; j < business.getTruck(i).getBinCount(); j++) {
                Item item = business.getTruck(i).getBin(j).getBox();
                if (item == null)
                    continue;

                String name = item.getName().toLowerCase();
                double qty = item.getQuantity();
                String unit = item.getUnit();

                int index = itemNames.indexOf(name);
                if (index != -1) {
                    // item already exists in list
                    itemQuantities.set(index, itemQuantities.get(index) + qty);
                } else {
                    // new item
                    itemNames.add(name);
                    itemQuantities.add(qty);
                    itemUnits.add(unit);
                }
            }
        }

        System.out.println("===== JavaJeeps Business Dashboard =====\n");
        System.out.println("============================");
        System.out.println("|       Truck Summary      |");
        System.out.println("============================");
        System.out.printf(" - Total Trucks: %d\n", business.getTruckCount());
        System.out.printf("    * Regular Trucks: %d\n", business.getSpecificTruckCount("regular"));
        System.out.printf("    * Special Trucks: %d\n", business.getSpecificTruckCount("special"));
        System.out.println("============================\n");
        System.out.println("============================");
        System.out.println("|      Truck Locations     |");
        System.out.println("============================");
        for (int i = 0; i < business.getTruckCount(); i++) {
            System.out.printf("[%d] %s\n", i + 1, business.getTruck(i).getLocation());
        }
        System.out.println("============================\n");

        System.out.println("============================");
        System.out.println("|       Sales Revenue      |");
        System.out.println("============================");

        System.out.printf("%s %.2f\n", "Cappuccino", business.getSales("cappuccino"));
        System.out.printf("%s %.2f\n", "Americano", business.getSales("americano"));
        System.out.printf("%s %.2f\n", "Latte", business.getSales("latte"));
        System.out.printf("%s %.2f\n", "Total", business.getTotalSales());

        System.out.println("============================\n");

        System.out.println("============================");
        System.out.println("|    Aggregate Inventory   |");
        System.out.println("============================");

        System.out.printf("%-18s| %-10s| %s\n", "Item", "Quantity", "Unit");
        System.out.println("------------------|-----------|--------");
        for (int i = 0; i < itemNames.size(); i++) {
            System.out.printf("%-18s| %-10.2f| %s\n", itemNames.get(i), itemQuantities.get(i), itemUnits.get(i));
        }
        System.out.println("============================\n");
    }

    /**
     * Displays the header section for the pricing table.
     * 
     * This method prints a formatted table header used in price display menus,
     * including columns for Drink, Size, and Price.
     */
    public void displayPricingHeader() {
        System.out.println("============================");
        System.out.println("|   Drink     Size   Price |");
        System.out.println("============================");
    }

    /**
     * Displays the menu for updating drink prices.
     * 
     * This method shows the list of drinks with their corresponding sizes and
     * prices,
     * prefixed with selection indices to allow user input for updating a specific
     * entry.
     * 
     * @param business the CoffeeBusiness instance containing the drink price list
     */
    public void displayUpdatePrices(CoffeeBusiness business) {
        displayPricingHeader();
        for (int i = 0; i < business.getPriceList().size(); i++) {
            System.out.printf("[%d]%11s %1s   %.2f\n", i + 1,
                    business.getPriceList().get(i).getProduct(),
                    business.getPriceList().get(i).getSize(),
                    business.getPriceList().get(i).getPrice());
        }
        System.out.println("============================\n");
    }

    /**
     * Displays the current drink prices offered by the business.
     * 
     * This method shows a formatted table of all drinks including their names,
     * sizes, and prices. It does not include selection indices.
     * 
     * @param business the CoffeeBusiness instance containing the drink price list
     */
    public void displayPrices(CoffeeBusiness business) {
        displayPricingHeader();
        for (int i = 0; i < business.getPriceList().size(); i++) {
            System.out.printf("  %10s   %1s   %.2f\n",
                    business.getPriceList().get(i).getProduct(),
                    business.getPriceList().get(i).getSize(),
                    business.getPriceList().get(i).getPrice());
        }
        System.out.println("============================\n");
    }

    /**
     * Displays a formatted receipt for a successfully completed coffee order.
     * 
     * The receipt includes the truck's location, the name and size of the drink
     * ordered,
     * and the total price of the transaction.
     * 
     * @param business the CoffeeBusiness instance containing the drink price list
     * @param truck    the CoffeeTruck instance that processed the order
     * @param input    the index of the selected drink in the price list (0-based)
     * @param total    the final price of the order to be shown on the receipt
     */
    public void displayReceipt(CoffeeBusiness business, CoffeeTruck truck, int input, double total) {
        System.out.println("============================");
        System.out.println("|      Order Complete      |");
        System.out.println("============================");
        System.out.printf("| Truck: %-18s|\n", truck.getLocation());
        System.out.printf("| Drink: %-18s|\n", business.getPriceList().get(input).getProduct());
        System.out.printf("| Size: %-18s|\n", business.getPriceList().get(input).getSize());
        System.out.printf("| Price: %-18.2f|\n", total);
        System.out.println("============================");

    }

    /**
     * Displays a cancellation message for an unsuccessful coffee order.
     * 
     * This message indicates that the order could not be completed due to missing
     * or insufficient ingredients in the truck's inventory and advises the user to
     * restock.
     */
    public void displayCancelledOrder() {
        System.out.println("============================");
        System.out.println("|      Order Cancelled     |");
        System.out.println("|     due to incomplete    |");
        System.out.println("|        ingredients       |");
        System.out.println("============================");
        System.out.println("|      Please  Restock     |");
        System.out.println("============================");
    }

    /**
     * Prompts the user to input a numeric menu option.
     * 
     * This method reads an integer input from the user, validating it to ensure
     * that
     * only numeric values are accepted. If the input is invalid, it prompts the
     * user again.
     * 
     * @return the validated integer input from the user
     */
    public int getMenuInput() {
        boolean valid = false;
        int input = 0;
        while (!valid) {
            try {
                System.out.print("Enter choice: ");
                input = scanner.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
        }
        return input;
    }

    /**
     * Reads and returns a line of text input from the user.
     * 
     * This method uses the scanner to read the next full line entered by the user.
     * 
     * @return the user input as a string
     */
    public String getTextInput() {
        return scanner.nextLine();
    }

    /**
     * Reads and returns a numeric input (double) from the user.
     * 
     * The method repeatedly prompts the user until a valid decimal number is
     * entered.
     * After reading input, it flushes the buffer to avoid input skipping issues.
     * 
     * @return the validated double value entered by the user
     */
    public double getNumInput() {
        boolean valid = false;
        double input = 0;
        while (!valid) {
            try {
                input = scanner.nextDouble();
                valid = true;
            } catch (InputMismatchException e) {
            }
            scanner.nextLine();
        }
        return input;
    }

    /**
     * Reads and returns an integer input from the user.
     * 
     * The method continues to prompt the user until a valid integer is entered.
     * After each attempt, it flushes the scanner buffer to prevent input issues.
     * 
     * @return the validated integer value entered by the user
     */
    public int getIntInput() {
        boolean valid = false;
        int input = 0;
        while (!valid) {
            try {
                input = scanner.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
            }
            scanner.nextLine();
        }
        return input;
    }
}
