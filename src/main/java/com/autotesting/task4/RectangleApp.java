package com.autotesting.task4;

import java.util.Scanner;

public class RectangleApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RectangleGeometryService service = new RectangleGeometryService();

        System.out.println("=== Rectangle Position Checker ===");
        System.out.println("Rectangle is bounded by lines x = +/-3 and y = +/-4 (inclusive)");

        try {
            System.out.print("Enter X coordinate (integer): ");
            int x = scanner.nextInt();

            System.out.print("Enter Y coordinate (integer): ");
            int y = scanner.nextInt();

            Point point = new Point(x, y);
            RectanglePosition position = service.determinePosition(point);

            System.out.println("\n--- Result ---");
            System.out.println("Point: " + point);
            if (position != null) {
                System.out.println("Position: " + position.getDescription());
            } else {
                System.out.println("Position: ");
            }
        } catch (Exception e) {
            System.err.println("Invalid input. Please provide valid integer numbers.");
        } finally {
            scanner.close();
        }
    }
}
