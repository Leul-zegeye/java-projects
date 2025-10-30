import java.util.Scanner;
public class CurrencyFormatter {
    public static void writeln(double amount) {
        if (amount >= 0) {
            writePositive(amount);
        } else {
            writeNegative(amount);
        }
    }
    private static void writePositive(double amount) {
        long roundedCents = Math.round(amount * 100);
        long dollars = roundedCents / 100;
        long cents = Math.abs(roundedCents % 100);

        System.out.print("$" + dollars + ".");
        if (cents < 10) {
            System.out.print("0");
        }
        System.out.println(cents);
    }

    private static void writeNegative(double amount) {
        System.out.print("$-");
        writePositive(-amount);
    }

    public static class Species {
        private String name;
        private int population;
        private double growthRate;

        public Species() {
            this("", 0, 0.0);
        }

        public Species(String name, int population, double growthRate) {
            this.name = name;
            this.population = population;
            this.growthRate = growthRate;
        }

        public void set(String name, int population, double growthRate) {
            this.name = name;
            this.population = population;
            this.growthRate = growthRate;
        }

        public void writeOutput() {
            System.out.println("Name: " + name + ", Population: " + population + ", Growth Rate: " + growthRate);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Species)) return false;
            Species other = (Species) obj;
            return this.name.equals(other.name) &&
                   this.population == other.population &&
                   Math.abs(this.growthRate - other.growthRate) < 1e-9;
        }

        public void tryToChange(int x) {
            x = 1000000;
        }

        public void tryToReplace(Species other) {
            other = new Species("Other", 1, 2.0);
        }

        public void change(Species other) {
            other.name = this.name;
            other.population = this.population;
            other.growthRate = this.growthRate;
        }
    }
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double input;
        do {
            System.out.print("Enter a dollar value (0 to quit): ");
            input = in.nextDouble();
            if (input == 0) break;
            writeln(input);
        } while (input != 0);
        System.out.println("Goodbye.");

        Species a = new Species("dog", 10, 2.5);
        Species b = new Species("dog", 10, 2.5);

        System.out.println("a == b ? " + (a == b)); // false

        System.out.println("a.equals(b) ? " + a.equals(b)); // true

        Species c = a;
        c.name = "wolf";
        System.out.println("-- after alias c=a and modifying c.name --");
        System.out.print("a: ");
        a.writeOutput(); 
        System.out.print("c: ");
        c.writeOutput(); 

        int val = 7;
        a.tryToChange(val);
        System.out.println("-- tryToChange(primitive) --");
        System.out.println("val (unchanged): " + val); 

        Species d = new Species("d", 1, 1.0);
        a.tryToReplace(d);
        System.out.println("-- tryToReplace(object reference) --");
        System.out.print("d after tryToReplace: ");
        d.writeOutput(); 

        Species e = new Species("cat", 50, 12.0);
        a.change(e);
        System.out.println("-- change(object fields) --");
        System.out.print("e after a.change(e): ");
        e.writeOutput(); 
    }
}
