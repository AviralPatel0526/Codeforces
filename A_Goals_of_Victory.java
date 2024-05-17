import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * A_Goals_of_Victory
 */
public class A_Goals_of_Victory {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            t--;
            int n=sc.nextInt();
            long sum=0;
            for(int i=0;i<n-1;i++){
                int o=sc.nextInt();
                sum+=o;
            }

            System.out.println(sum*(-1));
        }
    }
}