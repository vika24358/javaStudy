package homework6;

public class Circle {
    int radius;
    public static double pi = 3.14159;
    double area;
    double circumference;

    public Circle(int radius) {
        this.radius = radius;
    }

    public void calculateArea(){
        this.area = radius*radius*pi;
    }

    public void calculateCircumference(){
        this.circumference = 2 * pi * radius;
    }

    public void printInfo(){
        System.out.println(radius + " " + area + " "+ circumference);
    }
}
