package view;

import java.util.Scanner;
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

        for (int i = 0; i <= business.getTruckCount(); i++) {
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

    public void displayTruckInfo(CoffeeTruck truck) {

    }

    public void displayRestockItem(int binNo) {
        System.out.printf("Set bin #%d content: ", binNo);
    }

    public void displayRestockQuantity(int binNo) {
        System.out.printf("Set quantity for bin #%d", binNo);
    }

    public void displayTruckRestock() {
        System.out.println("============================");
        System.out.println("|   Enter 1 of the items   |");
        System.out.println("============================");
        System.out.println("[C]offee Beans");
        System.out.println("[F]ull Cream Milk");
        System.out.println("[W]ater");
        System.out.println("[S]mall Cup");
        System.out.println("[M]edium Cup");
        System.out.println("[L]arge Cup");
        System.out.println("============================");
    }

    public void displayDashboard(CoffeeBusiness business) {
        System.out.println("===== JavaJeeps Business Dashboard =====\n");
        System.out.println();
        System.out.println("Truck Summary:");
        System.out.printf(" - Total Trucks: %d\n", business.getTruckCount());
        System.out.printf(" - Regular Trucks: %d\n", business.getSpecificTruckCount("regular"));
        System.out.printf(" - Special Trucks: %d\n", business.getSpecificTruckCount("special"));
        System.out.println();
        System.out.println("Truck Locations:");
        for (int i = 0; i < business.getTruckCount(); i++) {
            System.out.printf("- %s", business.getTruck(i));
        }
    }

    public int getMenuInput() {
        System.out.print("Enter choice: ");
        return scanner.nextInt();
    }

    public String getTextInput() {
        System.out.println(">>>");
        return scanner.nextLine();
    }

    public double getNumInput() {
        return scanner.nextDouble();
    }

}
