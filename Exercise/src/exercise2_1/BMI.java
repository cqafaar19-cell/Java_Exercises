package exercise2_1;

/**
 * Exercise 2.1: BMI class.
 * Models a person's Body Mass Index (BMI) using name, age,
 * weight (in pounds), and height (in inches).
 */
public class BMI {

    // ---------- Data fields ----------
    private String name;    // name of the person
    private int age;        // age of the person
    private double weight;  // weight in pounds
    private double height;  // height in inches

    // ---------- Constructors ----------

    /** Creates a BMI object with the specified name, age, weight, and height. */
    public BMI(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    /** Creates a BMI object with the specified name, weight, and height, and a default age of 20. */
    public BMI(String name, double weight, double height) {
        this(name, 20, weight, height);
    }

    // ---------- Methods ----------

    /** Returns the BMI: weight (pounds) * 703 / height (inches)^2. */
    public double getBMI() {
        return weight * 703 / (height * height);
    }

    /** Returns the BMI status as a String based on the BMI value. */
    public String getStatus() {
        double bmi = getBMI();

        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25.0)   // 18.5 <= bmi < 25.0
            return "Normal";
        else if (bmi < 30.0)   // 25.0 <= bmi < 30.0
            return "Overweight";
        else                   // bmi >= 30.0
            return "Obese";
    }

    // ---------- Getters (provided but omitted from the UML diagram) ----------

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

}
class test{
    // ---------- Simple test ----------
    public static void main(String[] args) {
        BMI person1 = new BMI("Ali", 18, 145, 70);
        System.out.println("The BMI for " + person1.getName() + " is "
                + String.format("%.2f", person1.getBMI()) + " " + person1.getStatus());

        BMI person2 = new BMI("Sara", 215, 70);   // default age 20
        System.out.println("The BMI for " + person2.getName() + " (age " + person2.getAge() + ") is "
                + String.format("%.2f", person2.getBMI()) + " " + person2.getStatus());
    }
}
