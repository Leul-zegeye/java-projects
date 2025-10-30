import java.util.*;
public class SpeciesRefLab {
private static class Species {
    private String name;
    private int population;
    private double growthRate;

    public Species(String name, int population, double growthRate) {
        this.name = name;
        this.population = population;
        this.growthRate = growthRate;
    }

    public Species() {
        this.name = "";
        this.population = 0;
        this.growthRate = 0.0;
    }

    public void set(String name, int population, double growthRate) {
        this.name = name;
        this.population = population;
        this.growthRate = growthRate;
    }

    public void writeOutput() {
        System.out.println("Name: " + name);
        System.out.println("Population: " + population);
        System.out.println("Growth rate: " + growthRate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Species)) return false;
        Species other = (Species) o;
        return this.population == other.population &&
               Double.compare(this.growthRate, other.growthRate) == 0 &&
               ((this.name == null && other.name == null) ||
                (this.name != null && this.name.equals(other.name)));
    }

    
    public void tryToChange(int x) {
        x = 9999;
    }

    public void tryToReplace(Species other) {
        other = new Species("Replaced", 2, 2.0);
    }

    public void change(Species other) {
        if (other != null) {
            other.name = this.name;
            other.population = this.population;
            other.growthRate = this.growthRate;
        }
    }
}

public static void main(String[] args) {
    Species a = new Species("Canis", 100, 2.5);
    Species b = new Species("Canis", 100, 2.5);

    System.out.println("a == b ? " + (a == b));            // should be false
    System.out.println("a.equals(b) ? " + a.equals(b));    // should be true

    Species c = a;
    c.name = "ChangedCanis";
    System.out.println("-- after alias c=a and modifying c.name --");
    System.out.print("a.name: ");
    System.out.println(a.name); // reflects new name
    System.out.print("c.name: ");
    System.out.println(c.name);

    System.out.println("a.name changed via alias\n");

    int original = 42;
    a.tryToChange(original);
    System.out.println("-- tryToChange(primitive) --");
    System.out.println("caller variable unchanged: " + original + "\n");

    Species d = new Species("Lupus", 50, 1.1);
    a.tryToReplace(d);
    System.out.println("-- tryToReplace(object reference) --");
    System.out.println("No effect on caller:");
    d.writeOutput();
    System.out.println();

    Species e = new Species("Vulpes", 30, 0.5);
    a.change(e);
    System.out.println("-- change(object fields) --");
    System.out.println("target object fields updated:");
    e.writeOutput();
}
}

