import java.util.*;
import java.lang.*;
import java.io.*;

public class A_Game_with_Integers {
    static long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    static long pow(long base, int exp) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result *= base;
            }
            base *= base;
            exp /= 2;
        }
        return result;
    }
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t!=0) {
            t--;
            int n=sc.nextInt();
            if((n-1)%3 == 0 || (n+1)%3 == 0){
                System.out.println("First");
            }else{
                System.out.println("Second");
            }
        }
    }
}