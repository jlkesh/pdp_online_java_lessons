

````java
public class DryTest {

    public static int sum(int a, int b) {
        int sum = a + b;
        System.out.printf("sum = %d %n", sum);
        return sum;
    }

    public static int average(int a, int b) {
        return sum(a, b) / 2;
    }

    public static void main(String[] args) {
        sum(12, 45);
        average(12, 45);
    }
}
````


````java
public class KISSTest {

    public static String getDay(int number) {
        return switch ( number ) {
            case 1 -> "Dushanba";
            case 2 -> "Seshanba";
            case 3 -> "Chorshanba";
            case 4 -> "Payshanba";
            case 5 -> "Juma";
            case 6 -> "Shanba";
            case 7 -> "Yakshanba";
            default -> "0";
        };
    }
    
    public static void main(String[] args) {
        System.out.println(getDay(5));
    }
}
````


````java
/**
 * @author Elmurodov Javohir
 * @time 10/20/2021 12:12:34
 * @desciption :This class is used to .......................
 */
public class DocumentYourCodeTest {

    /**
     * @description : This method is used to add two integer numbers
     * @param a is a integer param
     * @param b is a integer param
     * @return returns integer
     */
    public static int sum(int a, int b) {
        int sum = a + b;
        System.out.printf("sum = %d %n", sum);
        return sum;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static int average(int a, int b) {
        // javadoc
        return sum(a, b) / 2;
    }

    public static void main(String[] args) {

    }
}
````

# Parking version I
````java
import java.util.Scanner;

public class Parking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = {
                {"✅", "✅", "✅", "✅", "✅"},
                {"✅", "✅", "✅", "✅", "✅"},
                {"✅", "✅", "✅", "✅", "✅"}
        };
        while (true) {
            displayMenu();
            System.out.println("?:");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> displayPark(matrix);
                case "2" -> availableCellsCount(matrix);
                case "3" -> notAvailableCellsCount(matrix);
                case "4" -> in(matrix);
                case "5" -> out(matrix);
                case "q" -> {
                    System.out.println("Bye ))");
                    System.exit(0);
                }
                default -> System.out.println("Wrong choice");
            }
        }
    }


    private static void availableCellsCount(String[][] matrix) {
        String emptySign = "✅";
        int counter = 0;
        for (String[] row : matrix) {
            for (String cell : row) {
                if (cell.equals(emptySign))
                    counter++;
            }
        }
        System.out.printf("Available Cells Count is : %5d%n", counter);
    }

    private static void notAvailableCellsCount(String[][] matrix) {
        String emptySign = "✅";
        int counter = 0;
        for (String[] row : matrix) {
            for (String cell : row) {
                if (!cell.equals(emptySign))
                    counter++;
            }
        }
        System.out.printf("Not Available Cells Count is : %5d%n", counter);
    }

    private static void in(String[][] matrix) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row index : ");
        int rowIndex = scanner.nextInt();
        System.out.print("Enter column index : ");
        int columnIndex = scanner.nextInt();
        if (matrix[rowIndex][columnIndex].equals("✅"))
            matrix[rowIndex][columnIndex] = "\uD83D\uDE95";
        else {
            System.out.println("Cell already taken 😒😒");
        }

    }

    private static void out(String[][] matrix) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row index : ");
        int rowIndex = scanner.nextInt();
        System.out.print("Enter column index : ");
        int columnIndex = scanner.nextInt();
        matrix[rowIndex][columnIndex] = "✅";
    }

    private static void quit() {

    }

    private static void displayMenu() {
        System.out.println("Display Park              -> 1");
        System.out.println("Available cells count     -> 2");
        System.out.println("Not Available cells count -> 3");
        System.out.println("In                        -> 4");
        System.out.println("Out                       -> 5");
        System.out.println("Quit                      -> q");
    }

    private static void displayPark(String[][] matrix) {
        for (String[] row : matrix) {
            for (String cell : row) {
                System.out.printf("%s\t", cell);
            }
            System.out.println();
        }
    }
}
````

# Parking version II
````java
package uz.pdp.parking;

/**
 * @author Elmurodov Javohir
 * @time 11/4/2022 5:39 AM
 * @project lesson_10_1
 */

public class Car {
    private String registerNumber;

    public Car(){

    }

    public Car(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "registerNumber='" + registerNumber + '\'' +
                '}';
    }
}
````


````java
package uz.pdp.parking;

/**
 * @author Elmurodov Javohir
 * @time 11/4/2022 5:59 AM
 * @project lesson_10_1
 */

public class CarType {
    public static String EMPTY_SIGN = "✅";
    public static String POLICE_CAR = "\uD83D\uDE93";
    public static String MINIBUS = "\uD83D\uDE90";
    public static String AUTOMOBILE = "\uD83D\uDE97";
    public static String BUS = "\uD83D\uDE8C";

    public static String findCarTypeByCarTypeName(String carType) {
        return switch (carType) {
            case "POLICE_CAR" -> POLICE_CAR;
            case "MINIBUS" -> MINIBUS;
            case "AUTOMOBILE" -> AUTOMOBILE;
            case "BUS" -> BUS;
            default -> AUTOMOBILE;
        };
    }
}
````



````java
package uz.pdp.parking;

/**
 * @author Elmurodov Javohir
 * @time 11/4/2022 5:40 AM
 * @project lesson_10_1
 */

public class Cell {
    private Car car;
    private String cellId;
    private String sign = CarType.EMPTY_SIGN;

    public Cell() {
    }

    public Cell(int cellIdAsInt) {
        this.cellId = String.valueOf(cellIdAsInt);
    }

    public Cell(Car car, String cellId) {
        this.car = car;
        this.cellId = cellId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getCellId() {
        return cellId;
    }

    public void setCellId(String cellId) {
        this.cellId = cellId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "car=" + car +
                ", cellId='" + cellId + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
````


````java
package uz.pdp.parking;

import java.util.Arrays;

/**
 * @author Elmurodov Javohir
 * @time 11/4/2022 5:41 AM
 * @project lesson_10_1
 */

public class Row {
    private Cell[] cells;
    private String rowId;

    public Row() {
    }

    public Row(int rowIdAsInt) {
        this.rowId = String.valueOf(rowIdAsInt);
    }

    /*public Row(int rowIdAsInt, int cellCount) {
        this(rowIdAsInt);
        this.cells = this.buildRow(cellCount);
    }*/

    public Row(Cell[] cells, String rowId) {
        this.cells = cells;
        this.rowId = rowId;
    }


    public Cell[] getCells() {
        return cells;
    }

    public void setCells(Cell[] cells) {
        this.cells = cells;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    @Override
    public String toString() {
        return "Row{" +
                "cells=" + Arrays.toString(cells) +
                ", rowId='" + rowId + '\'' +
                '}';
    }

    public void buildRow(int cellCount) {
        this.cells = new Cell[cellCount];
        for (int i = 0; i < cellCount; i++) {
            this.cells[i] = new Cell(i);
        }
    }
}
````



````java
package uz.pdp.parking;

import java.util.Arrays;

/**
 * @author Elmurodov Javohir
 * @time 11/4/2022 5:42 AM
 * @project lesson_10_1
 */

public class Parking {
    private Row[] rows;
    private String parkName;

    public Parking() {
    }

    public Parking(Row[] rows, String parkName) {
        this.rows = rows;
        this.parkName = parkName;
    }

    public Row[] getRows() {
        return rows;
    }

    public void setRows(Row[] rows) {
        this.rows = rows;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "rows=" + Arrays.toString(rows) +
                ", parkName='" + parkName + '\'' +
                '}';
    }

    public void buildPark(int rowCount, int cellCount) {
        rows = new Row[rowCount];
        for (int i = 0; i < rowCount; i++) {
            Row row = new Row(i);
            row.buildRow(cellCount);
            rows[i] = row;
        }
    }

    public void displayPark() {
        for (Row row : rows) {
            for (Cell cell : row.getCells()) {
                System.out.printf("%s\t", cell.getSign());
            }
            System.out.println("\n");
        }
    }

    public void park(Car car, String carType, String rowIndex, String columnIndex) {
        carType = CarType.findCarTypeByCarTypeName(carType);
        int rIndex = Integer.parseInt(rowIndex);
        int cIndex = Integer.parseInt(columnIndex);
        Row row = rows[rIndex];
        Cell[] cells = row.getCells();
        Cell cell = cells[cIndex];
        cell.setSign(carType);
        cell.setCar(car);
    }
}
````


````java
package uz.pdp.parking;

import java.util.Scanner;


/**
 * @author Elmurodov Javohir
 * @time 11/4/2022 5:42 AM
 * @project lesson_10_1
 */

public class AndroidUI {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Parking parking = new Parking();
        int rowCount = 4;
        int cellCount = 6;
        parking.buildPark(rowCount, cellCount);
        while (true) {
            displayMenu();
            String choice = readConsole("? : ");
            switch (choice) {
                case "1" -> displayPark(parking);
//                case "2" -> availableCellsCount(matrix);
//                case "3" -> notAvailableCellsCount(matrix);
                case "4" -> park(parking);
//                case "5" -> out(matrix);
                case "q" -> {
                    System.out.println("Bye ))");
                    System.exit(0);
                }
                default -> System.out.println("Wrong choice");
            }
        }


    }

    private static void park(Parking parking) {
        String registerNumber = readConsole("Register Number : ");
        String carType = readConsole("Car Type : \nPOLICE_CAR/MINIBUS/AUTOMOBILE/BUS -> ");
        String rowIndex = readConsole("Enter row index : ");
        String columnIndex = readConsole("Enter column index : ");
        Car car = new Car(registerNumber);
        parking.park(car, carType, rowIndex, columnIndex);
    }

    private static String readConsole(String hint) {
        System.out.print(hint);
        return scanner.nextLine();
    }

    private static void displayPark(Parking parking) {
        parking.displayPark();
    }


    private static void displayMenu() {
        System.out.println("Display Park              -> 1");
        System.out.println("Available cells count     -> 2");
        System.out.println("Not Available cells count -> 3");
        System.out.println("In                        -> 4");
        System.out.println("Out                       -> 5");
        System.out.println("Quit                      -> q");
    }
}
````

