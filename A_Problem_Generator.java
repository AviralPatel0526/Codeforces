import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * A_Problem_Generator
 */
public class A_Problem_Generator {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            t--;
            int n=sc.nextInt();
            int m=sc.nextInt();
            String s=sc.next();
            HashMap<Character,Integer> map=new HashMap<>();
            for(int i=0;i<n;i++){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0)+1);
            }
            int ans=0;
            for (Character key:map.keySet()){
                int val=map.get(key);
                if(val < m){
                    ans+=m-val;
                }
            }
            ans+=(7-map.size())*m;
            System.out.println(ans);
        }
    }
}