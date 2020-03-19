package IntroLinkedList;

import java.util.Scanner;

public class IPS_Implementation implements IPolynomialSolver{
    Double_LinkedList A = new Double_LinkedList();
    Double_LinkedList B = new Double_LinkedList();
    Double_LinkedList C = new Double_LinkedList();
    Double_LinkedList R = new Double_LinkedList();
    Double_LinkedList X = new Double_LinkedList();
    Double_LinkedList Y = new Double_LinkedList();
    @Override
    public void setPolynomial(char poly, int[][] terms) {
        X.clear();
        for (int i = 0; i < terms.length; i++)
            for (int j = 0; j < 2; j++)
                X.add(terms[i][j]);
        if(poly == 'A'){
            A = X.sublist(0, X.size()-1);
            A = sortingAndReduction(A);
            System.out.println("Polynomial "+ poly +" is Set.");
        }
        else if(poly == 'B'){
            B = X.sublist(0, X.size()-1);
            B = sortingAndReduction(B);
            System.out.println("Polynomial "+ poly +" is Set.");
        }
        else {
            C = X.sublist(0, X.size()-1);
            C = sortingAndReduction(C);
            System.out.println("Polynomial "+ poly +" is Set.");
        }
    }

    @Override
    public String print(char poly) {
        String expression = "";
        if(A.size()==0 || B.size()==0 || C.size()==0 )
            if(poly == 'A')     X = A.sublist(0,A.size()-1);
            else if(poly == 'B')    X = B.sublist(0,B.size()-1);
            else if(poly == 'C')    X = C.sublist(0,C.size()-1);
            else      X = R.sublist(0, R.size()-1);

        for (int i = 0; i < X.size()-1; i+=2) {
            // case of constants
            if ((int) X.get(i) == 0)     expression += "";
            else if ((int) X.get(i+1) == 0){
                if ((int) X.get(i) > 0  &&  i != 0)   expression += "+" + (int) X.get(i);
                else    expression += (int) X.get(i);
            }
            // case of first degree
            else if ((int) X.get(i+1) == 1){
                if (i == 0){
                    if((int) X.get(i) != 1  &&  (int) X.get(i) != -1)      expression += (int) X.get(i) + "x";
                    else if((int) X.get(i) == -1)      expression += "-" + "x";
                    else     expression += "x";
                }
                else {
                    if ((int) X.get(i) > 1)     expression += "+" + (int) X.get(i) + "x";
                    else if ((int) X.get(i) == 1)    expression += "+" + "x";
                    else if ((int) X.get(i) == -1)    expression += "-" + "x";
                    else    expression += (int) X.get(i) + "x";
                }
            }
            // case of higher degrees
            else {
                if (i == 0){
                    if((int) X.get(i) != 1  &&  (int) X.get(i) != -1)    expression += (int) X.get(i) + "x^" + (int) X.get(i+1);
                    else if((int) X.get(i) == -1)      expression += "-" + "x^" + (int) X.get(i+1);
                    else     expression += "x^" + (int) X.get(i+1) ;
                }
                else {
                    if ((int) X.get(i) > 1)     expression += "+" + (int) X.get(i) + "x^" + (int) X.get(i+1);
                    else if ((int) X.get(i) == 1)    expression += "+" + "x^" + (int) X.get(i+1);
                    else if ((int) X.get(i) == -1)    expression += "-" + "x^" + (int) X.get(i+1);
                    else    expression += (int) X.get(i) + "x^" + (int) X.get(i+1);
                }
            }
        }
        return expression;
    }

    @Override
    public void clearPolynomial(char poly) {
        if(poly == 'A')     A.clear();
        else if(poly == 'B')    B.clear();
        else if(poly == 'C')    C.clear();
        else     R.clear();
    }

    @Override
    public float evaluatePolynomial(char poly, float value) {
        if(poly == 'A')     X = A.sublist(0,A.size()-1);
        else if(poly == 'B')    X = B.sublist(0,B.size()-1);
        else if(poly == 'C')    X = C.sublist(0,C.size()-1);
        else      X = R.sublist(0, R.size()-1);

        float result = 0;
        for (int i = 0; i < X.size()-1 ; i+=2) {
            result += (float)Math.pow(value,(int) X.get(i+1)) * (int) X.get(i);
        }
        return result;
    }

    @Override
    public int[][] add(char poly1, char poly2) {
        R.clear();
        if (poly1 == 'A')   X = A.sublist(0,A.size()-1);
        else if (poly1 == 'B')   X = B.sublist(0,B.size()-1);
        else    X = C.sublist(0,C.size()-1);

        if (poly2 == 'A')   Y = A.sublist(0,A.size()-1);
        else if (poly2 == 'B')   Y = B.sublist(0,B.size()-1);
        else    Y = C.sublist(0,C.size()-1);

        R = mergeSorted(X ,Y ,true);
        int[][] result = Return(R);
        return result;
    }

    @Override
    public int[][] subtract(char poly1, char poly2) {
        R.clear();
        if (poly1 == 'A')   X = A.sublist(0,A.size()-1);
        else if (poly1 == 'B')   X = B.sublist(0,B.size()-1);
        else      X = C.sublist(0,C.size()-1);

        if (poly2 == 'A')   Y = A.sublist(0,A.size()-1);
        else if (poly2 == 'B')   Y = B.sublist(0,B.size()-1);
        else     Y = C.sublist(0,C.size()-1);

        R = mergeSorted(X ,Y ,false);
        int[][] result = Return(R);
        return result;
    }

    @Override
    public int[][] multiply(char poly1, char poly2) {
        R.clear();
        if (poly1 == 'A')   X = A.sublist(0,A.size()-1);
        else if (poly1 == 'B')   X = B.sublist(0,B.size()-1);
        else     X = C.sublist(0,C.size()-1);

        if (poly2 == 'A')   Y = A.sublist(0,A.size()-1);
        else if (poly2 == 'B')   Y = B.sublist(0,B.size()-1);
        else     Y = C.sublist(0,C.size()-1);

        for (int i = 0; i < X.size()-1 ; i+=2) {
            for (int j = 0; j < Y.size()-1 ; j+=2) {
                R.add((int)X.get(i) * (int)Y.get(j));
                R.add((int)X.get(i+1) + (int)Y.get(j+1));
            }
        }
        R = sortingAndReduction(R);
        int[][] result = Return(R);
        return result;
    }
    public Double_LinkedList mergeSorted(Double_LinkedList list1 ,Double_LinkedList list2 ,boolean F){
        int i = 0;
        int j = 0;
        Double_LinkedList mergedList = new Double_LinkedList();
        while (i < list1.size()-1  &&  j < list2.size()-1){
            if((int)list1.get(i+1) > (int)list2.get(j+1)){
                mergedList.add((int)list1.get(i));
                mergedList.add((int)list1.get(i+1));
                i += 2;
            }
            else if((int)list1.get(i+1) < (int)list2.get(j+1)){
                mergedList.add(-1 * (int)list2.get(j));
                mergedList.add((int)list2.get(j+1));
                j += 2;
            }
            else {
                if(F == true)   mergedList.add((int)list1.get(i) + (int)list2.get(j));
                else    mergedList.add((int)list1.get(i) - (int)list2.get(j));
                mergedList.add((int)list1.get(i+1));
                i += 2;
                j += 2;
            }
        }
        while (i <list1.size()-1){
            mergedList.add((int)list1.get(i));
            mergedList.add((int)list1.get(i+1));
            i += 2;
        }
        while (j < list2.size()-1){
            mergedList.add(-1 * (int)list2.get(j));
            mergedList.add((int)list2.get(j+1));
            j += 2;
        }
        return mergedList;
    }
    public Double_LinkedList sortingAndReduction(Double_LinkedList list1){
        if(list1.size() == 2)      return list1;
        boolean flag = false;
        while (flag == false){
            flag = true;
            for (int i = 0; i < list1.size()-3 ; i+=2) {
                if((int)list1.get(i+1) < (int)list1.get(i+3)){
                    Double_Node temp1 = new Double_Node(list1.get(i));
                    list1.set(i,list1.get(i+2));
                    Double_Node temp2 = new Double_Node(list1.get(i+1));
                    list1.set(i+1,list1.get(i+3));
                    list1.set(i+2,temp1.val);
                    list1.set(i+3,temp2.val);
                    flag = false;
                }
                else if((int)list1.get(i+1) == (int)list1.get(i+3)){
                    Double_Node temp1 = new Double_Node(list1.get(i));
                    int sum = (int)list1.get(i) + (int)list1.get(i+2);
                    temp1.val = sum;
                    list1.set(i,temp1.val);
                    list1.remove(i+2);
                    i--;
                    list1.remove(i+2);
                    i--;
                    flag = false;
                }
            }
        }
        return list1;
    }
    public int[][] Return (Double_LinkedList list1){
        int[][] result = new int[list1.size()/2][2];
        int k = 0;
        for (int i = 0; i < list1.size()/2 ; i++) {
            for (int j = 0; j < 2 ; j++) {
                result[i][j] = (int)list1.get(k);
                k++;
            }
        }
        return result;
    }
    public char isValid (char poly ,boolean flag){
        Scanner inputChar = new Scanner(System.in);
        if(flag) {
            while (poly != 'A' && poly != 'B' && poly != 'C') {
                System.out.println("Invalid Input please Choose between : A , B or C.\n");
                poly = inputChar.next().charAt(0);
            }
        }
        else {
            while (poly != 'A'  &&  poly != 'B'  &&  poly != 'C'  &&  poly != 'R') {
                System.out.println("Invalid Input please Choose between : A , B , C or R.\n");
                poly = inputChar.next().charAt(0);
            }
        }
        return poly;
    }
    public char isSet(char poly ,boolean flag){
        Scanner inputChar = new Scanner(System.in);
        while (poly == 'A'  &&  A.size() == 0){
            System.out.println("Polynomial " + poly + " Unset");
            poly = inputChar.next().charAt(0);
            poly = isValid(poly,flag);
            poly = isSet(poly,flag);
        }
        while (poly == 'B'  &&  B.size() == 0){
            System.out.println("Polynomial " + poly + " Unset");
            poly = inputChar.next().charAt(0);
            poly = isValid(poly,flag);
            poly = isSet(poly,flag);
        }
        while (poly == 'C'  &&  C.size() == 0){
            System.out.println("Polynomial " + poly + " Unset");
            poly = inputChar.next().charAt(0);
            poly = isValid(poly,flag);
            poly = isSet(poly,flag);
        }
        while (poly == 'R'  &&  R.size() == 0  &&  !flag){
            System.out.println("Polynomial " + poly + " Unset");
            poly = inputChar.next().charAt(0);
            poly = isValid(poly,flag);
            poly = isSet(poly,flag);
        }
        return poly;
    }

}
