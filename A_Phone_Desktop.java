import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * A_Phone_Desktop
 */
public class A_Phone_Desktop {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            t--;
            int x=sc.nextInt();
            int y=sc.nextInt();
            int count=0;
            while(x > 0 && y > 0){
                x=x-7;
                y=y-2;
                count++;
            }
            if(y < 0){
                x=x-Math.abs(y)*4;
            }
            while(x > 0){
                x-=15;
                count++;
            }
            while(y > 0){
                y-=2;
                count++;
            }
            
            System.out.println(count);
        }
    }
}