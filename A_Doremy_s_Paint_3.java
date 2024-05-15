import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * A_Doremy_s_Paint_3
 */
public class A_Doremy_s_Paint_3 {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            t--;
            int n=sc.nextInt();
            int a[]=new int[n];
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
                map.put(a[i], map.getOrDefault(a[i],0 )+1);
            }
            if(map.size() > 2){
                System.out.println("No");
            }else{
                if(map.size() == 1){
                    System.out.println("Yes");
                }
                if(map.size() == 2){
                    if(n%2 == 0){
                        int v=map.get(a[0]);
                        boolean flag=true;
                        for(Integer key : map.keySet()){
                            if(map.get(key) != v){
                                flag=false;
                                break;
                            }
                        }
                        if(flag){
                            System.out.println("Yes");
                        }else{
                            System.out.println("No");
                        }
                    }
                    if(n%2 == 1){
                        int v=map.get(a[0]);
                        boolean flag=true;

                        for(Integer key : map.keySet()){
                            if(Math.abs(map.get(key)-v) > 1){
                               flag=false;
                                break;
                            }
                        }
                        if(flag){
                            System.out.println("Yes");
                        }else{
                            System.out.println("No");
                        }
                    }
                }
            }


        }
    }
}