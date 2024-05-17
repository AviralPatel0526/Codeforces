import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * A_How_Much_Does_Daytona_Cost
 */
public class A_How_Much_Does_Daytona_Cost {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            t--;
            int n=sc.nextInt();
            int k=sc.nextInt();
            int a[]=new int[n];
            boolean flag=false;
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
                if(a[i] == k){
                    flag=true;
                }
            }
            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}