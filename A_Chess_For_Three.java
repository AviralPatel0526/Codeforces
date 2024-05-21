import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * A_Chess_For_Three
 */
public class A_Chess_For_Three {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            t--;
            int p1=sc.nextInt();
            int p2=sc.nextInt();
            int p3=sc.nextInt();
            int tot=p1+p2+p3;
            if(tot % 2 != 0){
                System.out.println(-1);
            }else{
                
                    if(p1+p2 <= p3){
                        System.out.println(p1+p2);
                    }else{
                        System.out.println(p3 + (p1+p2-p3)/2);
                    }
                
            }
        }
    }
}