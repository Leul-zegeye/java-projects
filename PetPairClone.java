public class PetPairClone {

    // --- Pet class with constructors, setters/getters, validation, writeOutput, and clone ---
     public static class Pet {
        private String name;
        private int age;
        private double weight;

        public Pet() {
            this("unknown");
        }

        public Pet(String name) {
            this(name, 0, 0.0);
        }

        public Pet(String name, int age, double weight) {
            set(name, age, weight);
        }

        public Pet(Pet original) {
            if (original == null) {
                set("unknown", 0, 0.0);
            } else {
                set(original.name, original.age, original.weight);
            }
        }

        private void set(String n, int a, double w) {
            this.name = (n != null) ? n : "unknown";
            this.age = (a >= 0) ? a : 0;
            this.weight = (w >= 0) ? w : 0.0;
        }

        public void setName(String name) {
            if (name != null) this.name = name;
        }

        public void setAge(int age) {
            if (age >= 0) this.age = age;
        }

        public void setWeight(double weight) {
            if (weight >= 0) this.weight = weight;
        }

        public String getName() { return name; }
        public int getAge() { return age; }
        public double getWeight() { return weight; }

        // Deep copy
        public Pet clone() {
            return new Pet(this);
        }

        public void writeOutput() {
            System.out.println("Pet: " + name + ", Age: " + age + ", Weight: " + weight);
        }
    }

    // --- Unsafe version for illustration (returns internal reference) ---
    public static class PetPairShallow {
        private Pet first, second;

        public PetPairShallow(Pet a, Pet b) {
            first = a;
            second = b;
        }

        public Pet getFirst() { return first; } // returns actual object (unsafe)
        public Pet getSecond() { return second; }
    }

    // --- PetPairClone pair implementation ---
    private Pet first, second;

    public PetPairClone(Pet a, Pet b) {
        first = (a != null) ? a.clone() : null;
        second = (b != null) ? b.clone() : null;
    }

    public Pet getFirst() { return (first != null) ? first.clone() : null; }
    public Pet getSecond() { return (second != null) ? second.clone() : null; }

    public static void main(String[] args) {

        // -- Pet constructors demo --
        System.out.println("[Initial objects]");
        Pet pet1 = new Pet();
        Pet pet2 = new Pet("Jane");
        Pet pet3 = new Pet("Coco", 3, 4.2);
        System.out.print("#1 "); pet1.writeOutput();
        System.out.print("#2 "); pet2.writeOutput();
        System.out.print("#3 "); pet3.writeOutput();

        // Modify pets using setters
        pet1.setName("Toto"); pet1.setAge(2); pet1.setWeight(1.5);
        pet2.setAge(5); pet2.setWeight(10.3);
        pet3.setName("Lucky"); pet3.setWeight(5.2);

        System.out.println("[After setters]");
        System.out.print("#1 "); pet1.writeOutput();
        System.out.print("#2 "); pet2.writeOutput();
        System.out.print("#3 "); pet3.writeOutput();

        // -- PetPairClone vs. PetPairShallow demo --

        Pet pA = new Pet("Faithful Guard Dog", 7, 30.2);
        Pet pB = new Pet("Loyal Companion", 5, 15.6);

        // (A) Shallow test (unsafe)
        PetPairShallow pairShallow = new PetPairShallow(pA, pB);
        System.out.println("[Shallow Pair: original]");
        pairShallow.getFirst().writeOutput();
        pairShallow.getSecond().writeOutput();

        // "Hacker" modifies second pet directly
        Pet hackPet = pairShallow.getSecond();
        hackPet.setName("Mischievous Cat");
        hackPet.setWeight(1.1);

        System.out.println("[Shallow Pair after hacker changes]");
        pairShallow.getFirst().writeOutput();
        pairShallow.getSecond().writeOutput(); // changes reflected in internal data

        // (B) PetPairClone - Safe
        PetPairClone pairSafe = new PetPairClone(pA, pB);
        System.out.println("[Safe PetPairClone: original]");
        pairSafe.getFirst().writeOutput();
        pairSafe.getSecond().writeOutput();

        // Try to "hack" by modifying the 'cloned' result
        Pet attackPet = pairSafe.getSecond();
        attackPet.setName("Hacker Impossible!");
        attackPet.setAge(999);

        System.out.println("[Safe PetPairClone after hacker tries]");
        pairSafe.getFirst().writeOutput();
        pairSafe.getSecond().writeOutput(); // no internal change

    }
}