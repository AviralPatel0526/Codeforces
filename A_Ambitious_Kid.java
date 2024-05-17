import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * A_Ambitious_Kid
 */
public class A_Ambitious_Kid {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a[]=new int[t];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<t;i++){
            a[i]=sc.nextInt();
            min=Math.min(min, Math.abs(a[i]));
        }
        System.out.println(min);
        // while (t != 0) {
        //     t--;
        //     System.out.println();
        // }
    }
}