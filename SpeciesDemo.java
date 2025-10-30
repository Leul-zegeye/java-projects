import java.util.*;

class Species {
    private String name;
    private int population;
    private double growthRate;

    // Set values if population and growthRate are non-negative
    public void setSpecies(String n, int p, double g) {
        if (p >= 0 && g >= 0) {
            name = n;
            population = p;
            growthRate = g;
        }
    }

    
    public int getPopulationIn10Years() {
        double projected = population * Math.pow(1 + growthRate / 100.0, 10);
        return (int)Math.round(projected);
    }

    
    public void writeOutput() {
        System.out.println("Name: " + name);
        System.out.println("Population: " + population);
        System.out.println("Growth Rate: " + growthRate);
    }
}


public class SpeciesDemo {
    public static void main(String[] args) {
        
        Species species1 = new Species();
        species1.setSpecies("Panda", 2000, 2.5);

        System.out.println("Species #1 Information:\n");
        species1.writeOutput();
        System.out.println("Projected population in 10 years: " + species1.getPopulationIn10Years());
        System.out.println();

        Species species2 = new Species();
        species2.setSpecies("Tiger", 1000, 1.0);

        System.out.println("Species #2 Information:\n");
        species2.writeOutput();
        System.out.println("Projected population in 10 years: " + species2.getPopulationIn10Years());
    }
}

