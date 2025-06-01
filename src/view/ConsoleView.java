package view;

import java.util.Scanner;

public class ConsoleView {

    private Scanner scanner = new Scanner(System.in);

    public void displayMainMenu() {
        System.out.println("============================");
        System.out.println("|         JavaJeeps        |");
        System.out.println("============================");
        System.out.println("[1] Create Coffee Truck");
        System.out.println("[2] Simulate Truck");
        System.out.println("[3] View Truck Information");
        System.out.println("[4] Restock / Maintain Truck");
        System.out.println("[5] View Business Dashboard");
        System.out.println("[6] Exit");
        System.out.println("============================");
    }

    public void displaySelectTruck() {
        System.out.println("============================");
        System.out.println("|    Select Coffee Truck   |");
        System.out.println("============================");
        System.out.println("[1] Regular Truck (JavaJeep)");
        System.out.println("[2] Special Truck (JavaJeep+)");
        System.out.println("[3] Exit");
        System.out.println("============================");
    }

    public int getMenuInput() {
        System.out.print("Enter choice: ");
        return scanner.nextInt();
    }
}
