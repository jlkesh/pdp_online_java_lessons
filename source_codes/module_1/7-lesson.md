

````java
public class WorkingWithRandom {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(12, 23);
        // first argument/param inclusive, second argument/param exclusive
        System.out.println(randomNumber);
        boolean nextBoolean = random.nextBoolean();
        System.out.println(nextBoolean);
    }
}
````


````java
import java.util.Scanner;

public class WorkingWithArrays {
    public static void main(String[] args) {
        int[] array; // reference
        array = new int[4];
        // new -> return memory address
        // int index = 4;
        // min_index >= 0; max_index = array length - 1
        // index  bounds
        // int nthElement = array[index];
        // System.out.println(nthElement);
        /*
        int -> 0
        short -> 0
        long -> 0
        boolean -> false
        String -> null
        */
        /*

        for (int i = 0; i < 4; i++) {
            System.out.println(array[i]);
        }*/
        /*Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.print("array[" + i + "] = ");
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(array[i]);
        }*/
        /*int arrayLength = array.length;
        System.out.println(arrayLength);*/
        // new int[10]; // reinitialize
        array[0] = 90;
        array[1] = 9;
        array[2] = 19;
        array[3] = 11;

        int[] array2 = new int[10];

        System.arraycopy(array, 2, array2, 4, 2);

//        for (int i = 0; i < array.length; i++) {
//            array2[i] = array[i];
//        }
        for ( int i : array2 ) {
            System.out.println(i);
        }


        /*System.out.println(array.length);
        //int[] array2 = new int[]{3,24,5,67,90};
        int[] array3 = {3, 24, 5, 67, 90};
        *//*for (int i = 0; i < array3.length; i++) {
            System.out.println(array3[i]);
        }*//*
        for (int element : array3) {
            System.out.println(element);
        }*/
    }
}
````


````java
public class MultidementionalArray {


    public static void main(String[] args) {
        int[][] table = new int[3][6];

        for (int i = 0; i < 3; i++) {
            int[] row = table[i];
            for (int j = 0; j < 6; j++) {
                row[j] = (int) Math.round(Math.random() * 100);
            }
        }

        /*for (int i = 0; i < 3; i++) {
            int[] row = table[i];
            for (int j = 0; j < 6; j++) {
                int element = row[j];
                System.out.print(element + "\t");
            }
            System.out.println("");
        }*/

        /*for (int[] row : table) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }*/
        int[][] matrix = {
                {12, 4},// array 1
                {5, 4, 23,345, 123}, // array 2
                {9, 12}, //array 3
                {11} //array 4
        };

        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }
}
````


````java
import java.util.Arrays;

public class WorkingWithArraysClassMethods {
    public static void main(String[] args) {
        int[] array = {12, 3, 4, 5, 32, 23, 56, 78, 90};
       /* String str = "[";
        for (int i = 0; i < array.length; i++) {
            str = str + array[i];
            if (i < array.length - 1) {
                str = str + ", ";
            }
        }
        str = str + "]";
        System.out.println(str);*/

        /*String str = Arrays.toString(array);
        System.out.println(str);
        int[][] matrix = {
                {12, 4, 6},
                {90, 12, 2},
                {34, 21, 65}
        };
        System.out.println(Arrays.toString(matrix));
        System.out.println(Arrays.deepToString(matrix));*/
        System.out.println(Arrays.toString(array));
//        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));
        int index = Arrays.binarySearch(array, 12);
        System.out.println(index);

    }
}
````


````java
public class AnsiEscape {
    public static void main(String[] args) {
        String RED_BACKGROUND = "\033[41m";
        String YELLOW_BACKGROUND = "\033[43m";
        String GREEN_BACKGROUND = "\033[42m";
        String RESET = "\033[0m";
        System.out.println(RED_BACKGROUND + " Hello " + RESET);
        System.out.println(YELLOW_BACKGROUND + " Hello " + RESET);
        System.out.println(GREEN_BACKGROUND + " Hello " + RESET);
    }
}
````

````java
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {


    static String chooseTurn() {
        Random random = new Random();
        return random.nextBoolean() ? "X" : "O";
    }

    static String[] fillBoard() {
        String[] strings = new String[10];
        for (int i = 0; i < 10; i++) {
            strings[i] = String.valueOf(i); // 1 -> "1"
        }
        return strings;
    }

    static void printBoard(String[] board) {
        getSlot(board, 1);
        System.out.println(getSlot(board, 1) + " | " + getSlot(board, 2) + " | " + getSlot(board, 3));
        System.out.println("---------");
        System.out.println(getSlot(board, 4) + " | " + getSlot(board, 5) + " | " + getSlot(board, 6));
        System.out.println("---------");
        System.out.println(getSlot(board, 7) + " | " + getSlot(board, 8) + " | " + getSlot(board, 9));
    }

    static String getSlot(String[] board, int slotNumber) {
        return board[slotNumber];
    }

    public static void main(String[] args) {
        String[] board = fillBoard();
        String turn = chooseTurn();
        printBoard(board);
        System.out.println(turn + " Player first ");
        Scanner scanner = new Scanner(System.in);
        while (!isBoardFull(board)) {
            printBoard(board);
            System.out.print(turn + " enter slot number : ");
            int slotNumber = scanner.nextInt();
            if (!board[slotNumber].equals(String.valueOf(slotNumber))) {
                System.out.println("Slot already taken");
                continue;
            }
            board[slotNumber] = turn;
            if (checkWin(board, turn)) {
                System.out.println("Player " + turn + " win )) 😊😊😊");
                return;
            } else {
                turn = turn.equals("X") ? "O" : "X";
            }
        }
        System.out.println("Draw 😒👌😂");
    }

    private static boolean checkWin(String[] board, String turn) {
        String[] winCases = {
                board[1] + board[2] + board[3],
                board[4] + board[5] + board[6],
                board[7] + board[8] + board[9],

                board[1] + board[4] + board[7],
                board[2] + board[5] + board[8],
                board[3] + board[6] + board[9],

                board[1] + board[5] + board[9],
                board[3] + board[5] + board[7]
        };

        for (String winCase : winCases) {
            if (winCase.equals(turn.repeat(3)))
                return true;
        }
        return false;
    }

    private static boolean isBoardFull(String[] board) {
        for (int i = 1; i < board.length; i++) {
            if (board[i].equals(String.valueOf(i)))
                return false;
        }
        return true;
    }
}
````


````java
import java.util.Random;
import java.util.Scanner;

public class TicTakToe2 {


    static String chooseTurn() {
        Random random = new Random();
        return random.nextBoolean() ? "X" : "O";
    }

    static String[] fillBoard() {
        String[] strings = new String[10];
        for (int i = 0; i < 10; i++) {
            strings[i] = String.valueOf(i); // 1 -> "1"
        }
        return strings;
    }

    static void printBoard(String[] board) {
        System.out.println(getSlot(board[1]) + " " + getSlot(board[2]) + " " + getSlot(board[3]));
        System.out.println();
        System.out.println(getSlot(board[4]) + " " + getSlot(board[5]) + " " + getSlot(board[6]));
        System.out.println();
        System.out.println(getSlot(board[7]) + " " + getSlot(board[8]) + " " + getSlot(board[9]));
    }

    static String getSlot(String slot) {
        String RED_BACKGROUND = "\033[41m ";
        String YELLOW_BACKGROUND = "\033[43m ";
        String GREEN_BACKGROUND = "\033[42m ";
        String RESET = " \033[0m";
        if (slot.equals("X"))
            return RED_BACKGROUND + slot + RESET;
        if (slot.equals("O"))
            return YELLOW_BACKGROUND + slot + RESET;
        return GREEN_BACKGROUND + slot + RESET;
    }

    public static void main(String[] args) {
        String[] board = fillBoard();
        String turn = chooseTurn();
        printBoard(board);
        System.out.println(turn + " Player first ");
        Scanner scanner = new Scanner(System.in);
        while (!isBoardFull(board)) {
            printBoard(board);
            System.out.print(turn + " enter slot number : ");
            int slotNumber = scanner.nextInt();
            if (!board[slotNumber].equals(String.valueOf(slotNumber))) {
                System.out.println("Slot already taken");
                continue;
            }
            board[slotNumber] = turn;
            if (checkWin(board, turn)) {
                printBoard(board);
                System.out.println("Player " + turn + " win )) 😊😊😊");
                return;
            } else {
                turn = turn.equals("X") ? "O" : "X";
            }
        }
        System.out.println("Draw 😒👌😂");
    }

    private static boolean checkWin(String[] board, String turn) {
        String[] winCases = {
                board[1] + board[2] + board[3],
                board[4] + board[5] + board[6],
                board[7] + board[8] + board[9],

                board[1] + board[4] + board[7],
                board[2] + board[5] + board[8],
                board[3] + board[6] + board[9],

                board[1] + board[5] + board[9],
                board[3] + board[5] + board[7]
        };

        for (String winCase : winCases) {
            if (winCase.equals(turn.repeat(3)))
                return true;
        }
        return false;
    }

    private static boolean isBoardFull(String[] board) {
        for (int i = 1; i < board.length; i++) {
            if (board[i].equals(String.valueOf(i)))
                return false;
        }
        return true;
    }
}
````