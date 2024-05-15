import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * A_Jagged_Swaps
 */
public class A_Jagged_Swaps {

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
            if(a[0]==1){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}