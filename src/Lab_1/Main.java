package Lab_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your number: ");
        int number = scanner.nextInt();

        if (number > 1000) {
            System.out.println(number + " is greater than 1000");
        } else if (number < 0) {
            System.out.println(number + " is negative");
        } else {
            //System.out.println("Your number is: " + number);
            int counter = 0;
            for(int i = 1; i <= number; i++){
                if(isTruncatablePrime(i)){
                    counter++;
                    System.out.println("Number " + i);
                }
            }
            System.out.println("Counter: " + counter);
            scanner.close();
        }
    }

    public static boolean isPrime(int number){
        if (number < 2) {
            return false;
        }
        for(int counter = 2; counter < number; counter++){
            if(number % counter == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isTruncatablePrime(int number){
        while (number > 0){
            if(isPrime(number)){
                number = number/10;
            } else {
                return false;
            }
        }
        return true;
    }
}

