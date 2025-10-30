import java.util.*;

class Rectangle {
    private double width;
    private double height;
   //Assigns if both are positive
    public void setDimensions(double w, double h) {
        if (w > 0 && h > 0) {
            width = w;
            height = h;
        }
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }
}
public class RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter width: ");
        double width = scanner.nextDouble();

        System.out.printf("Enter height: ");
        double height = scanner.nextDouble();

        Rectangle rect = new Rectangle();
        rect.setDimensions(width, height);

        System.out.println();
        System.out.println("Area = " + rect.getArea());
        System.out.println("Perimeter = " + rect.getPerimeter());

        
    }
}

