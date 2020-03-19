package IntroLinkedList;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class Single_LinkedListTest {
    @Test
    void test1_DOUBLE(){
        Single_LinkedList l=new Single_LinkedList();
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
    void test2_DOUBLE(){
        Single_LinkedList l=new Single_LinkedList();
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
    void test3_DOUBLE(){

        Single_LinkedList l=new Single_LinkedList();
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
    void test4_DOUBLE() {
        //test empty
        Single_LinkedList l=new Single_LinkedList();
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
    void test5_DOUBLE() {
        //test empty
        Single_LinkedList l=new Single_LinkedList();
        l.add(5);
        l.add(5);
        l.add(4);
        l.add(8);
        l.clear();
        assertEquals(true,l.isEmpty());
    }
    @Test
    void test6_DOUBLE() {
        //test searching an element
        Single_LinkedList l=new Single_LinkedList();
        l.add(5);
        l.add(5);
        l.add(4);
        l.add(8);
        assertEquals(true,l.contains(8));
        assertEquals(false,l.contains(0));
    }
    @Test
    void test7_DOUBLE() {
        //test replace value of element by another value
        Single_LinkedList l=new Single_LinkedList();
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
    void test8_DOUBLE() {
        //sub linked list
        Single_LinkedList l=new Single_LinkedList();
        Single_LinkedList l2=new Single_LinkedList();
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
    void test9_DOUBLE(){
        //test all exceptions
        LinkedList l=new LinkedList();
        l.add(5);
        l.add(6);
        assertThrows(IndexOutOfBoundsException.class,()->{l.get(8);});
        assertThrows(IndexOutOfBoundsException.class,()->{l.remove(9);});
        assertThrows(IndexOutOfBoundsException.class,()->{l.subList(9,8);});
        assertThrows(IndexOutOfBoundsException.class,()->{l.set(9,7);});
    }

}