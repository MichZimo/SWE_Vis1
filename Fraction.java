import java.lang.Math;

public class Fraction {
    private int numerator; // Instanzvariable Zaehler
    private int denominator; // Instanzvariable Nenner

    // Getter für private Variable Zaehler
    public int getNumerator() {
        return numerator;
    }

    // Getter für private Variable Nenner
    public int getDenominator() {
        return denominator;
    }

    
    // Konstruktor, der zweiten Konstruktor aufruft, um gnaze Zahlen als Bruch darzustellen
    public Fraction(int numerator){
        this(numerator, 1);
    }
    
    // Konstruktor zum Kürzen des Bruches
    public Fraction(int numerator, int denominator) {
        if (denominator==0) {
            throw new IllegalArgumentException("n darf nicht gleich 0 sein!");
        }
        // Variablen referencen
        this.numerator = numerator;
        this.denominator = denominator;

        // größten gemeinsamen Nnner finden
        int gcd = gcdAlgo(Math.abs(numerator), Math.abs(denominator)); // Negative Zahlen haendeln
        
        // Nenner und Zaehler kuerzen
        this.numerator= numerator / gcd;
        this.denominator = denominator / gcd;

    }

    // Euclidean Algo um größten gemeinsamen Divisor zu finden
    private int gcdAlgo(int a, int b) {
        while (b != 0) {
            int temp = b; // Hilfsvariable, um b zu speichern
            b = a % b; // Update b zum Rest bei der Divison von a durch b
            a = temp; // Update a zum ursprünlichen b
        }
        return a;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Methoden zur Bruchmanipulation
    // Bruch mal integer
    Fraction multiply(int factor) {
        return new Fraction(this.numerator*factor, this.denominator);
    }

    // Bruch mal Bruch
    Fraction multiply(Fraction factor) {
        return new Fraction(this.numerator*factor.numerator, this.denominator*factor.denominator);
    }

    // Bruch geteilt durch BRuch
    Fraction divide(Fraction divisor) {
        return new Fraction(this.numerator*divisor.denominator, this.denominator*divisor.numerator);
    }

    // willkürliche Anzahl an Bruechen miteinander multipliziert
    Fraction multiply(Fraction... factors) {
        int newNum = this.numerator;
        int newDenom = this.denominator;
        for(Fraction factor:factors) {
            newNum = newNum*factor.numerator;
            newDenom = newDenom*factor.denominator;
        }
        return new Fraction(newNum, newDenom);
    }
}

class FractionTest {
    // Bruch mal integer: Fraction multiply(int factor)
    private static void methode1() {
        Fraction f = new Fraction(3,4);
        Fraction expected = new Fraction(6,4);  
        Fraction actual = f.multiply(2);

        if(actual.getNumerator() == expected.getNumerator() && 
        actual.getDenominator() == expected.getDenominator()) {
            System.out.println("multiply(int) Test passed!");
        } else {
            System.out.println("multiply(int) Test FAILED!");
        }
    }

    // Bruch mal Bruch Fraction multiply(Fraction factor)
    private static void methode2() {
        Fraction f = new Fraction(3,4);
        Fraction expected = new Fraction(1,2);
        Fraction other = new Fraction(2, 3);
        Fraction actual = f.multiply(other); 

        if(actual.getNumerator() == expected.getNumerator() && 
        actual.getDenominator() == expected.getDenominator()) {
            System.out.println("multiply(Fraction) Test passed!");
        } else {
            System.out.println("multiply(Fraction) Test FAILED!");
        }
    }

    // Bruch geteilt durch BRuch Fraction divide(Fraction divisor) 
    private static void methode3() {
        Fraction f = new Fraction(3,4);
        Fraction expected = new Fraction(1,4);  
        Fraction other = new Fraction(3, 1);
        Fraction actual = f.divide(other); 

        if(actual.getNumerator() == expected.getNumerator() && 
        actual.getDenominator() == expected.getDenominator()) {
            System.out.println("divide(Fraction) Test passed!");
        } else {
            System.out.println("divide(Fraction) Test FAILED!");
        }
    }


    // willkürliche Anzahl an Bruechen miteinander multipliziert Fraction multiply(Fraction... factors)    
    private static void methode4() {
        Fraction f = new Fraction(3,4);
        Fraction expected = new Fraction(3,2);  
        Fraction other = new Fraction(2, 3);
        Fraction other2 = new Fraction(3, 1);
        Fraction actual = f.multiply(other, other2); 

        if(actual.getNumerator() == expected.getNumerator() && 
        actual.getDenominator() == expected.getDenominator()) {
            System.out.println("multiply(Fraction...) Test passed!");
        } else {
            System.out.println("multiply(Fraction...) Test FAILED!");
        }
    }

    

    public static void main(String[] args) {
        // Bruch mal integer: Fraction multiply(int factor)
        methode1();
        // Bruch mal Bruch Fraction multiply(Fraction factor)
        methode2();
        // Bruch geteilt durch BRuch Fraction divide(Fraction divisor) 
        methode3();
        // willkürliche Anzahl an Bruechen miteinander multipliziert Fraction multiply(Fraction... factors)
        methode4();
    }
}
