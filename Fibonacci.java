import java.util.Scanner; // Für input Eingabe

public class Fibonacci { // öffentliche Klasse

    /**
     * Berechne Fibonacci-Zahl
     * @param n Sequenzposition
     */
    public static int fib(int n) { // Methode zur Berechnung
        // Exceptionhandling
        if (n < 0) {
            throw new IllegalArgumentException("n darf nicht negativ sein!");
        }
        // Rekursionsanker
        if (n <= 1) return n; // für die ersten beiden FIbonacci ZAhlen 0 und 1
        return fib(n - 1) + fib(n - 2); // Rekursionsschritt
    }

    public static void main(String[] args) {
        // get input
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Gib die Position n der Fibonacci-Zahl ein: ");
        int n = scanner.nextInt();

        // FIbonacci-Zahl berechnen und ausgeben
        int result = fib(n);
        System.out.println("Die " + n + ". Fibonacci-Zahl ist: " + result);

        scanner.close(); // Interface schließen
    }
}
