import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * B_Sequence_Game
 */
public class B_Sequence_Game {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            t--;
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            ArrayList<Integer> list =new ArrayList<>();
            list.add(a[0]);
            for(int i=1;i<n;i++){
                if(a[i] < a[i-1]){
                    list.add(a[i]);
                    list.add(a[i]);
                }else{
                    list.add(a[i]);
                }
            }
            System.out.println(list.size());
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}