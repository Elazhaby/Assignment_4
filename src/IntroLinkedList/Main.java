package IntroLinkedList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char polyName1;
        char polyName2;
        int Decision;
        int N;
        int[][] F;
        boolean done1 = false;
        boolean done2 = false;
        short count = 0;
        Scanner inputChar = new Scanner(System.in);
        Scanner inputTerms = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        IPS_Implementation S = new IPS_Implementation();
        while (true) {
            System.out.println("Please Choose an action");
            System.out.println("-----------------------");
            System.out.println("1- Set a Polynomial Variable");
            System.out.println("2- Print a Polynomial Variable");
            System.out.println("3- Add two Polynomials");
            System.out.println("4- Subtract two Polynomials");
            System.out.println("5- Multiply two Polynomials");
            System.out.println("6- Evaluate a Polynomial at some point");
            System.out.println("7- Clear a Polynomial");
            System.out.println("=========================================================");
            try {
            Scanner action = new Scanner(System.in);
            Decision = action.nextInt();

               if (Decision == 1) {
                   System.out.println("Insert the Variable name : A , B or C");
                   polyName1 = inputChar.next().charAt(0);
                   polyName1 = S.isValid(polyName1, true);
                   System.out.println("Insert the number of terms : ");
                   N = inputTerms.nextInt();
                   System.out.println("Insert the Polynomial terms in the form :\n(Coefficient , exponent)");
                   int[][] terms = new int[N][2];
                   for (int i = 0; i < N; i++)
                       for (int j = 0; j < 2; j++)
                           terms[i][j] = input.nextInt();
                   S.setPolynomial(polyName1, terms);
                   done1 = true;
                   done2 = true;
                   if ((S.A.size() == 0 && S.B.size() == 0) || (S.A.size() == 0 && S.C.size() == 0) || (S.B.size() == 0 && S.C.size() == 0))
                       done2 = false;
               } else if (Decision == 2 && done1) {
                   System.out.println("Insert the Variable name : A , B , C or R");
                   polyName1 = inputChar.next().charAt(0);
                   polyName1 = S.isValid(polyName1, false);
                   polyName1 = S.isSet(polyName1, false);
                   String expression = S.print(polyName1);
                   System.out.println("The Polynomial Terms are :\n");
                   System.out.println(expression);
               } else if ((Decision == 3 || Decision == 4 || Decision == 5) && done2) {
                   System.out.println("Insert the first operand");
                   polyName1 = inputChar.next().charAt(0);
                   polyName1 = S.isValid(polyName1, true);
                   polyName1 = S.isSet(polyName1, true);
                   System.out.println("Insert the second operand");
                   polyName2 = inputChar.next().charAt(0);
                   polyName2 = S.isValid(polyName2, true);
                   polyName2 = S.isSet(polyName2, true);
                   if (Decision == 3) {
                       F = S.add(polyName1, polyName2);
                   } else if (Decision == 4) {
                       F = S.subtract(polyName1, polyName2);
                   } else {
                       F = S.multiply(polyName1, polyName2);
                   }
               } else if (Decision == 6 && done1) {
                   System.out.println("Insert the Variable name : A , B , C or R");
                   polyName1 = inputChar.next().charAt(0);
                   polyName1 = S.isValid(polyName1, false);
                   polyName1 = S.isSet(polyName1, false);
                   float value = input.nextFloat();
                   float result = S.evaluatePolynomial(polyName1, value);
                   System.out.println("The Value of " + polyName1 + " at " + value + " is " + result + "\n");
               } else if (Decision == 7 && done1) {
                   System.out.println("Insert the Variable name : A , B , C or R");
                   polyName1 = inputChar.next().charAt(0);
                   polyName1 = S.isValid(polyName1, false);
                   S.clearPolynomial(polyName1);
                   if (S.A.size() == 0 && S.B.size() == 0 && S.C.size() == 0) done1 = false;
                   if ((S.A.size() == 0 && S.B.size() == 0) || (S.A.size() == 0 && S.C.size() == 0) || (S.B.size() == 0 && S.C.size() == 0))
                       done2 = false;
               } else if (done1 == false) {
                   System.out.println("You have to set some Polynomials");
               } else if (done2 == false) {
                   System.out.println("You have to set more than One Polynomial");
               } else {
                   System.out.println("Invalid Operation Please try again.");
               }
           }
           catch (Exception e){}
            System.out.println("=========================================================");
        }
    }
}
