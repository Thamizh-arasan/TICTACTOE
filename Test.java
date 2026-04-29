import java.util.Scanner;

public class LargestDigitsDynamic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long num = sc.nextLong();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // Extract digits
        while (num > 0) {
            int digit = (int)(num % 10);

            
            if (index == maxDigit) {
                maxDigit += 10;

                int[] temp = new int[maxDigit];

                // Copy old elements
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }

                // Assign new array
                digits = temp;
            }

            digits[index] = digit;
            index++;

            num /= 10;
        }

        // Find largest and second largest
        int largest = -1, secondLargest = -1;

        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
    }
}
