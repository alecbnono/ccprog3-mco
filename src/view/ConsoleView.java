package view;

import java.util.Scanner;
import java.util.InputMismatchException;
import model.*;

/**
 * ConsoleView
 */

public class ConsoleView {

    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

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

    public void displaySetTruckLoc() {
        System.out.print("Enter location for this truck: ");
    }

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

    public void displayTruckInteractions() {
        System.out.println("============================");
        System.out.println("| Select Truck Interaction |");
        System.out.println("============================");
        System.out.println("[1] Simulate Truck");
        System.out.println("[2] View Truck Information");
        System.out.println("[3] Restock / Maintain Truck");
        System.out.println("[4] Update / View Prices");
        System.out.println("[0] Exit");
        System.out.println("============================");
    }

    public void displaySimulateTruck(CoffeeTruck truck) {

    }

    public void displayTruckInfo(CoffeeBusiness business, CoffeeTruck truck, int truckNo) {
        System.out.printf("Truck #%d\n", truckNo);
        System.out.printf("%-8s: %s\n", "Type",
                truck.getType().substring(0, 1).toUpperCase() + truck.getType().substring(1));
        System.out.printf("%-8s: %s\n\n", "Location", truck.getLocation());
        System.out.println("Menu Prices: ");
        displayPrices(business);
        displayRestockTruck(truck);
    }

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

    public void displayRestockItem(int binNo) {
        System.out.printf("Set bin #%d content: ", binNo);
    }

    public void displayRestockQuantity(int binNo) {
        System.out.printf("Set quantity for bin #%d", binNo);
    }

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

    public void displayDashboard(CoffeeBusiness business) {
        System.out.println("===== JavaJeeps Business Dashboard =====\n");
        System.out.println("============================");
        System.out.println("|       Truck Summary      |");
        System.out.println("============================");
        System.out.printf(" - Total Trucks: %d\n", business.getTruckCount());
        System.out.printf("    * Regular Trucks: %d\n", business.getSpecificTruckCount("regular"));
        System.out.printf("    * Special Trucks: %d\n", business.getSpecificTruckCount("special"));
        System.out.println("============================");
        System.out.println();
        System.out.println("============================");
        System.out.println("|      Truck Locations     |");
        System.out.println("============================");
        for (int i = 0; i < business.getTruckCount(); i++) {
            System.out.printf("[%d] %s", i + 1, business.getTruck(i));
        }
        System.out.println("============================");

    }

    public void displayPricingHeader() {
        System.out.println("============================");
        System.out.println("|   Drink     Size   Price |");
        System.out.println("============================");
    }

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

    public void displayCancelledOrder() {
        System.out.println("============================");
        System.out.println("|      Order Cancelled     |");
        System.out.println("|     due to incomplete    |");
        System.out.println("|        ingredients       |");
        System.out.println("============================");
        System.out.println("|      Please  Restock     |");
        System.out.println("============================");
    }

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

    public String getTextInput() {
        return scanner.nextLine();
    }

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
