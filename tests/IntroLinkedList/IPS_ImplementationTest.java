package IntroLinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPS_ImplementationTest {

    @org.junit.jupiter.api.Test
    void print() {
        int[][] terms = {{4,2},{5,1},{10,0},{-2,-1}};
        IPS_Implementation S = new IPS_Implementation();
        S.setPolynomial('A',terms);
        String str = S.print('A');
        String result = "4x^2+5x+10-2x^-1";
        assertEquals(result,str);
    }

    @Test
    void evaluatePolynomial() {
        int[][] terms = {{-3,3},{4,2},{1,1},{-6,0},{-1,-1},{7,-3}};
        IPS_Implementation S = new IPS_Implementation();
        S.setPolynomial('B',terms);
        float actual = S.evaluatePolynomial('B',4.2f);
        assertEquals(-153.647613f,actual,0.0001);
    }

    @Test
    void clearPolynomial() {
        int[][] terms = {{-3,3},{4,2},{1,1},{-6,0},{-1,-1},{7,-3}};
        IPS_Implementation S = new IPS_Implementation();
        S.setPolynomial('B',terms);
        S.clearPolynomial('B');
        assertEquals(null,S.B.head);
    }

    @Test
    void add() {
        int[][] terms1 = {{-3,3},{7,-3},{4,2},{-6,0},{1,1},{-1,-1}};
        int[][] terms2 = {{3,3},{-4,1},{10,0},{-2,-1}};
        IPS_Implementation S = new IPS_Implementation();
        S.setPolynomial('A',terms1);
        S.setPolynomial('B',terms2);
        int[][] result = S.add('A','B');
        int[][] actual = {{0,3},{4,2},{-3,1},{4,0},{-3,-1},{7,-3}};
        assertArrayEquals(actual,result);
    }

    @Test
    void subtract() {
        int[][] terms1 = {{-3,3},{7,-3},{-6,0},{1,1},{-1,-1}};
        int[][] terms2 = {{3,3},{-4,1},{4,2},{10,0},{-2,-1}};
        IPS_Implementation S = new IPS_Implementation();
        S.setPolynomial('A',terms1);
        S.setPolynomial('B',terms2);
        int[][] result = S.subtract('A','B');
        int[][] actual = {{-6,3},{-4,2},{5,1},{-16,0},{1,-1},{7,-3}};
        assertArrayEquals(actual,result);
    }

    @Test
    void multiply() {
        int[][] terms1 = {{2,3},{1,2},{-12,1},{1,0}};
        int[][] terms2 = {{4,2},{-1,0},{4,-1}};
        IPS_Implementation S = new IPS_Implementation();
        S.setPolynomial('A',terms1);
        S.setPolynomial('B',terms2);
        int[][] result = S.multiply('A','B');
        int[][] actual = {{8,5},{4,4},{-50,3},{11,2},{16,1},{-49,0},{4,-1}};
        assertArrayEquals(actual,result);
    }
}