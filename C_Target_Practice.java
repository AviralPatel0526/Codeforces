import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * C_Target_Practice
 */
public class C_Target_Practice {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            t--;
            int n=10;
            char a[][]=new char[n][n];
            for(int i=0;i<n;i++){
                
                a[i]=sc.next().toCharArray();
            }
            int score=0;

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    char c=a[i][j];
                    if(c == 'X'){
                        if(i == 0 || i==n-1 || j == 0 || j== n-1){
                            score+=1;
                        }else if(i == 1 || i == n-2 || j == 1 || j== n-2){
                            score+=2;
                        }else if(i == 2 || i == n-3 || j == 2 || j == n-3){
                            score+=3;
                        }else if(i == 3 || i == n-4 || j == 3 || j == n-4){
                            score+=4;
                        }else{
                            score+=5;
                        }
                    }
                    

                }
            }
            System.out.println(score);
        }
    }
}