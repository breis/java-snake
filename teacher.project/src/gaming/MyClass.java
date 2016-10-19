package gaming;


import java.util.Random;
import java.util.Scanner;

public class MyClass {

    public int getInteger() {
        Scanner myScanner;
        int number;

        myScanner = new Scanner(System.in);

        do {
            try {
                number = myScanner.nextInt();
                return number;
            } catch (java.util.InputMismatchException error) {
                System.out.println("That's not a number! Try again:");
                myScanner.next();
            }
        } while (true);
    }

    public int randomNumber(int largestPossibleNumber) {

        int number;
        Random myRandomObject;

        myRandomObject = new Random();

        number = myRandomObject.nextInt(largestPossibleNumber + 1);

        return number;
    }

    public int rangedRandomNumber(int smallestPossible, int largestPossible) {

        int number;
        Random myRandomObject;

        myRandomObject = new Random();

        number = myRandomObject.nextInt(
                (largestPossible - smallestPossible) + 1)
                + smallestPossible;

        return number;
    }

    public int randomFromInput() {

        int input;
        int random;

        System.out.println("What is the highest possible random number"
                + "that you want to see?");

        input = this.getInteger();

        random = this.randomNumber(input);

        return random;

    }

    public void sayThing(int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            System.out.println("Hello!");
        }
    }

    public void delay(double seconds) {
        
        int milliseconds;
        
        milliseconds = (int) seconds * 1000;
        
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
