import java.util.*;
public class PetRegistry {
    private static class Pet {
    private String name;
    private int age;
    private double weight;

    // Default constructor
    public Pet() {
        this("unknown");
    }

    // One-parameter constructor
    public Pet(String n) {
        this(n, 0, 0.0);
    }

    // Three-parameter constructor
    public Pet(String n, int a, double w) {
        set(n, a, w);
    }

    // Information hiding: validation happens here
    private void set(String n, int a, double w) {
        this.name = n != null ? n : "unknown";
        this.age = (a >= 0) ? a : 0;
        this.weight = (w >= 0.0) ? w : 0.0;
    }

    // Setters
    public void setName(String n) {
        set(n, this.age, this.weight);
    }

    public void setAge(int a) {
        set(this.name, a, this.weight);
    }

    public void setWeight(double w) {
        set(this.name, this.age, w);
    }

    public void writeOutput() {
        System.out.println(name + ", " + age + ", " + weight);
    }
}

public static void main(String[] args) {
    // [Initial objects]
    Pet pet1 = new Pet();
    Pet pet2 = new Pet("Jane");
    Pet pet3 = new Pet("Coco", 3, 4.2);

    System.out.println("[Initial objects]");
    System.out.print("#1 "); pet1.writeOutput();
    System.out.print("#2 "); pet2.writeOutput();
    System.out.print("#3 "); pet3.writeOutput();
    System.out.println();

    // Use setters to modify objects
    pet1.setName("Toto");
    pet1.setAge(2);
    pet1.setWeight(1.5);

    pet2.setAge(5);
    pet2.setWeight(8.7);

    pet3.setName("Rex");
    pet3.setAge(6);
    pet3.setWeight(9.9);

    System.out.println("[After setters]");
    System.out.print("#1 "); pet1.writeOutput();
    System.out.print("#2 "); pet2.writeOutput();
    System.out.print("#3 "); pet3.writeOutput();
}
}
