import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * A_Don_t_Try_to_Count
 */
public class A_Don_t_Try_to_Count {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            t--;
            int n=sc.nextInt();
            int m=sc.nextInt();
            String x=sc.next();
            String s=sc.next();
            if(x.contains(s)){
                System.out.println(0);
            }else{
                int c=0;
                boolean flag=false;
                while(!x.contains(s) && x.length() <= 100){
                    x+=x;
                    c++;
                    if(x.contains(s)){
                        flag=true;
                        break;
                    }
                }
                if(flag)
                System.out.println(c);
                else
                System.out.println(-1);
            }
        }
    }
}