public class Main {
    public static void main(String[] args) {
        CalculateUsingMethodOverloading calc = new CalculateUsingMethodOverloading();
        System.out.println(calc.Calculate(4.0));
        System.out.println(calc.Calculate(5.0, true));
        System.out.println(calc.Calculate(12,5, true));
        System.out.println(calc.Calculate(12.5, 5.7));
    }
}

class CalculateUsingMethodOverloading{
    public double Calculate(double a){
        System.out.println("Area of a square");
        return Math.pow(a,2);
    }
    public double Calculate(double a, boolean isCircle){
        System.out.println("Area of a circle");
        isCircle = true;
        return 3.14 * Math.pow(a,2);
    }
    public double Calculate(double length, double width, boolean isRectangle ){
        System.out.println("Rectangle calculation");
        isRectangle = true;
        return length * width;
    }
    public double Calculate(double a, double b){
        System.out.println("Triangle calculation");
        return 0.5 * a * b;
    }
}

