/**********************************************************************
 * Name: Gage Mather
 * Assignment: Program2
**********************************************************************/

public class Program2 {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {

        /*
            logic that checks if a or b is zero as without it,
            this function returns the value "-0" if either
            of the values results in 0 being divided
            by a negative number.
        */

        if ((a == 0) || (b == 0)) return 0;
        return a * b;
    }

    public static double divide(double a, double b) {

        //returns -1 if b is zero
        if (b == 0) return -1;
        return a / b;
    }
    
    public static double sineOfAngle(double oppSide, double hyp) {

        // if the opposite side is bigger than the hypotenuse then the triangle doesn't exist
        // if the hypotenuse is less than 0 or equal to zero then the triangle also doesn't exist
        if ((oppSide > hyp) || (hyp <= 0) || (oppSide <= 0)) return -1;

        double holdResult = oppSide / hyp;
        return (double) (Math.round(holdResult * 100)) / 100;
    }

    public static double hypOfTriangle(double sideA, double sideB) {

        //returns -1 if the sides of the triangle are less than or equal to zero as this would make the triangle undefined
        if ((sideA <= 0) || (sideB <= 0)) return -1;

        //pythagorean theorem
        double Result = Math.sqrt((sideA * sideA) + (sideB * sideB));

        //returns Result rounded to two decimals
        return (double) (Math.round(Result * 100)) / 100;

    }

    public static void main(String[] args) {


        System.out.println ("bad triangle (hypotenuse): " + hypOfTriangle(0.0,1.0));
        System.out.println ("good triangle (hypotenuse): " + hypOfTriangle(3.0,1.0));
        System.out.println ("bad triangle (Sin): " + sineOfAngle(3.0,1.0));
        System.out.println ("good triangle (Sin): " + sineOfAngle(2.45,5.0));
        System.out.println ("division by zero: " + divide(-5,0));

    }
}
