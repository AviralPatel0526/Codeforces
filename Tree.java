import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * Tree
 */
public class Tree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    static int idx=-1;
    static Node f(int a[]){
        idx++;
        if(a[idx] == -1){
            return null;
        }
        Node newNode=new Node(a[idx]);
        newNode.left=f(a);
        newNode.right=f(a);
        return newNode;
    }
    static void f(Node head){
        if(head == null){
            return;
        }
        System.out.print(head.data+" ");
        f(head.left);
        f(head.right);
    }
    static void lot(Node head){
        Queue<Node> q=new LinkedList<>();
        q.add(head);
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=1;i<=n;i++){
                Node curr=q.poll();
                System.out.print(curr.data+" ");
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int a[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node head=f(a);
        System.out.println(head.data);
        // f(head);
        lot(head);
    }
}