import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * A_United_We_Stand
 */
public class A_United_We_Stand {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            t--;
            int n=sc.nextInt();
            TreeMap<Integer,Integer> map=new TreeMap<>();
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                map.put(a,map.getOrDefault(a, 0) + 1);
            }
            if(map.size() == 1){
                System.out.println(-1);
            }else{
                int i=0;
                ArrayList<Integer> first = new ArrayList<>();
                ArrayList<Integer> second = new ArrayList<>();
                for (Integer key : map.keySet()) {
                    int k=map.get(key);
                    if(i==0){
                        for(int j=1;j<=k;j++){
                            first.add(key);
                        }
                        i++;
                    }else{
                        for(int j=1;j<=k;j++){
                           second.add(key);
                        }
                    }
                }
                System.out.println(first.size() + " " + second.size());
                for(int p=0;p<first.size();p++){
                    System.out.print(first.get(p) + " ");
                }
                System.out.println();
                for(int p=0;p<second.size();p++){
                    System.out.print(second.get(p) + " ");
                }
                System.out.println();
            }

        }
    }
}