package view;

import java.util.Scanner;
import java.util.ArrayList;

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
        System.out.println("[2] Select Existing Truck");
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

    public void displayExistingTrucks(/* Add Params */) {
        System.out.println("============================");
        System.out.println("|      Select Existing     |");
        System.out.println("|       Coffee Truck       |");
        System.out.println("============================");

        // for (int i = 0; i <= truckList.length(); i++) {
        // CoffeeTruck truck = truckList.get(i);
        // System.out.printf("[%d] %s", i + 1, truck.getname());
        // }

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
        System.out.println("[0] Exit");
        System.out.println("============================");
    }

    public int getMenuInput() {
        System.out.print("Enter choice: ");
        return scanner.nextInt();
    }

}
