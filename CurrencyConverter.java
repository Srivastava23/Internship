import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Conversion rates (for demonstration purposes)
        double usdToInr = 72.93;
        double eurToInr = 86.79;
        double gbpToInr = 100.43;

        System.out.println("Welcome to Currency Converter!");
        System.out.println("Available currencies: USD, EUR, GBP");
        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter the currency to convert from (e.g., USD): ");
        String fromCurrency = scanner.nextLine().toUpperCase();

        double result;
        switch (fromCurrency) {
            case "USD":
                result = amount * usdToInr;
                break;
            case "EUR":
                result = amount * eurToInr;
                break;
            case "GBP":
                result = amount * gbpToInr;
                break;
            default:
                result = amount;
                break;
        }

        System.out.println(amount + " " + fromCurrency + " = " + result + " INR");
        scanner.close();
    }
}
