import java.util.Scanner;

public class SecondMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your number: ");
        int number = scanner.nextInt();

        if (number > 1000) {
            System.out.println(number + " is greater than 1000");
        } else if (number < 0) {
            System.out.println(number + " is negative");
        } else {
            int counter = 0;
            for (int i = 1; i <= number; i++) {
                if (isPrime(i)) {
                    int reversed = reversedNumber(i);
                    if (isPrime(reversed)) {
                        System.out.println("Number " + i + ": " + reversed);
                        counter++;
                    }
                }
            }
            System.out.println(counter + " prime numbers");
            scanner.close();
        }
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int counter = 2; counter < number; counter++) {
            if (number % counter == 0) {
                return false;
            }
        }
        return true;
    }

    public static int reversedNumber(int number) {
        int reversedNumber = 0;
        int originalNumber = number;
        while (originalNumber > 0) {
            reversedNumber = reversedNumber * 10 + originalNumber % 10;
            originalNumber /= 10;
        }
        return number = reversedNumber;
    }
}