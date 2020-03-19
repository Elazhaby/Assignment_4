package IntroLinkedList;

import java.io.ObjectStreamException;
import java.io.*;

public class Single_LinkedList implements ILinkedList {
    Node head;



    public void add(Object element) {
        Node new_node = new Node(element);
        Node temp;
        if (this.head == null) {
            head = new_node;
        } else {
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next=new_node;
        }
    }




    public void add(int index1, Object element){
        int index=index1+1;
        Node new_node=new Node(element);
        Node temp=head;
        if(index>0) {
            if (index != 1) {
                for (int i = 0; i < index - 2; i++) {
                    if (temp.next != null) {
                        temp = temp.next;
                    } else {
                        throw new IndexOutOfBoundsException("index not found");
                    }
                }
                new_node.next = temp.next;
                temp.next = new_node;
            }
            else {new_node.next=temp;
            head=new_node;}
        }
        else {throw new IndexOutOfBoundsException("index not found");}
    }


    public Object get(int index1){
        int index=index1+1;
        if(this.head==null){
            throw new IndexOutOfBoundsException("Index Not found");
        }
        if(index!=0) {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                if (temp.next != null) {
                    temp = temp.next;
                } else {
                    throw new IndexOutOfBoundsException("Index Not found");
                }
            }

            return temp.val;
        }
        else{throw new IndexOutOfBoundsException("Index Not found");}
    }



    public void set(int index1, Object element){
        int index=index1+1;
        Node temp=head;
        if(index>0){
        for(int i=0;i<index-1;i++){
            if(temp.next==null){throw new IndexOutOfBoundsException("Index Not found");}
            temp=temp.next;

        }
        temp.val=element;}
        else {throw new IndexOutOfBoundsException("Index Not found");}
    }

    public void clear(){head=null;}


    public boolean isEmpty(){
    if(head!=null){return false;}
    else {return true;}}


    public void remove(int index1){
        int index=index1+1;
        if(this.size()==1){this.head=null;
        return;}
        Node temp=head;
        if(index>0){
            if(index==1){head=head.next;}
            else{
            for(int i=0;i<index-2;i++){
                if(temp.next==null){
                    throw new IndexOutOfBoundsException("Index Not found");
                }
                else {temp=temp.next;}
            }
            temp.next=temp.next.next;
            }
        }
        else {throw new IndexOutOfBoundsException("Index Not found");}
    }



    public int size(){
        int x=0;
        Node temp=head;
        while(temp!=null){temp=temp.next;
        x++;}
        return x;
    }



    public Single_LinkedList sublist(int fromIndex, int toIndex){
        if((fromIndex>this.size())||(toIndex>this.size())||(fromIndex<0)||(toIndex<0)){throw new NullPointerException("Wrong interval");}
        Single_LinkedList x=new Single_LinkedList();
        if(fromIndex<=toIndex) {
            int y=fromIndex;
            for (int i = 0; i <= (toIndex - fromIndex); i++) {
                x.add(this.get(y));
                y++;
            }
        }
        if(fromIndex>toIndex){
            int y=fromIndex;
            for(int i=0;i<=fromIndex-toIndex;i++){
                x.add(this.get(y));
            y--;}
        }
        return x;
    }
    public boolean contains(Object o){
        boolean x=false;
        Node temp=head;
        for(int i=0;i<this.size();i++){
            if(temp.val==o){
                x=true;
                break;
            }
            else {temp=temp.next;}
        }
        return x;
    }
    public Object[]ConvertToArray(){
        Object[]arr=new Object[this.size()];
        for(int i=0;i<this.size();i++){
            arr[i]=this.get(i);
        }
        return arr;
    }
    public void print_LinkedList(){
        Node temp=head;
        if(head==null){System.out.println("empty");}
        while (temp!=null){
            System.out.println(temp.val);
            if(temp.next==null){
            break;
            }
            else { temp=temp.next;}
        }
    }


}
