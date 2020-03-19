package IntroLinkedList;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class Double_LinkedListTest {
    @Test
    void test1_Single(){
        Double_LinkedList l=new Double_LinkedList();
        l.add(5);
        l.add(5);
        l.add(4);
        l.add(8);
        Object []x=new Object[]{5,5,4,8};
        Object []y=new Object[l.size()];
        y=l.ConvertToArray();
        assertArrayEquals(x,y);
    }
    @Test
    void test2_Single(){
        Double_LinkedList l=new Double_LinkedList();
        l.add(5);
        l.add(1,1);
        l.add(2,2);
        l.add(8);
        Object []x=new Object[]{5,1,2,8};
        Object []y=new Object[l.size()];
        y=l.ConvertToArray();
        assertArrayEquals(x,y);
    }
    @Test
    void test3_Single(){

       Double_LinkedList l=new Double_LinkedList();
        l.add(5);
        l.add(5);
        l.add(4);
        l.add(8);
        l.add(1,9);
        l.add(2,3);
        l.remove(1);
        Object []x=new Object[]{5,3,5,4,8};
        Object []y=new Object[l.size()];
        y=l.ConvertToArray();
        assertArrayEquals(x,y);
    }
    @Test
    void test4_Single() {
        //test empty
       Double_LinkedList l=new Double_LinkedList();
        l.add(5);
        l.add(5);
        l.add(4);
        l.add(8);
        l.remove(1);
        l.remove(0);
        l.remove(0);
        l.remove(0);
        Object []x=new Object[]{};
        Object []y=new Object[l.size()];
        y=l.ConvertToArray();
        assertArrayEquals(x,y);
    }
    @Test
    void test5_Single() {
        //test empty
        Double_LinkedList l=new Double_LinkedList();
        l.add(5);
        l.add(5);
        l.add(4);
        l.add(8);
        l.clear();
        assertEquals(true,l.isEmpty());
    }
    @Test
    void test6_Single() {
        //test searching an element
       Double_LinkedList l=new Double_LinkedList();
        l.add(5);
        l.add(5);
        l.add(4);
        l.add(8);
        assertEquals(true,l.contains(8));
        assertEquals(false,l.contains(0));
    }
    @Test
    void test7_Single() {
        //test replace value of element by another value
       Double_LinkedList l=new Double_LinkedList();
        l.add(5);
        l.add(5);
        l.add(4);
        l.add(8);
        l.set(0,1);
        l.set(1,2);
        l.set(2,3);
        l.set(3,4);
        Object []x=new Object[]{1,2,3,4};
        Object []y=new Object[l.size()];
        y=l.ConvertToArray();
        assertArrayEquals(x,y);
    }
    @Test
    void test8_Single() {
        //sub linked list
       Double_LinkedList l=new Double_LinkedList();
       Double_LinkedList l2=new Double_LinkedList();
        l.add(99);
        l.add(5);
        l.add(4);
        l.add(8);
        Object []x=new Object[]{99,5,4};
        l2=l.sublist(0,2);
        Object []y=new Object[l2.size()];
        y=l2.ConvertToArray();
        assertArrayEquals(x,y);
        l2=l.sublist(2,0);
        Object []x2=new Object[]{4,5,99};
        y=l2.ConvertToArray();
        assertArrayEquals(y,x2);
    }

    @Test
    void test9_Single(){
        //test all exceptions
        Double_LinkedList l=new Double_LinkedList();
        l.add(5);
        l.add(6);
        assertThrows(IndexOutOfBoundsException.class,()->{l.get(8);});
        assertThrows(IndexOutOfBoundsException.class,()->{l.remove(9);});
        assertThrows(IndexOutOfBoundsException.class,()->{l.sublist(9,8);});
        assertThrows(IndexOutOfBoundsException.class,()->{l.set(9,7);});
    }

}