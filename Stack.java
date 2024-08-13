public class Stack<T> {
    static class Node<T>{
        T data;
        Node next;
        Node(T data){
            this.data=data;
            this.next=null;
        }
    }
    private int size=0;
    private Node head=null;
    void push(T data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
        
    }
    Node pop(){
        Node x=head;
        head=head.next;
        return x;
    }
    public static void main(String[] args) {
        Stack<Character> st=new Stack<>();
        st.push('a');
        st.push('b');
        System.out.println(st.pop().data);
    }
}
