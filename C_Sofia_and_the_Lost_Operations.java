import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * C_Sofia_and_the_Lost_Operations
 */
public class C_Sofia_and_the_Lost_Operations {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            t--;
            int n=sc.nextInt();
            ArrayList<Integer> a=new ArrayList<>();
            for(int i=0;i<n;i++){
                a.add(sc.nextInt());
            }
            ArrayList<Integer> b=new ArrayList<>();
            HashSet<Integer> set=new HashSet<>();
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<n;i++){
                b.add(sc.nextInt());
                if(b.get(i)!=a.get(i)){
                    map.put(b.get(i),map.getOrDefault(b.get(i), 0)+1);
                }
                set.add(b.get(i));
            }
            int m=sc.nextInt();
            ArrayList<Integer> d=new ArrayList<>();
            for(int i=0;i<m;i++){
                d.add(sc.nextInt());
            }
            boolean flag=true;
            for(int i=0;i<m;i++){
                int x=d.get(i);
                if(set.contains(x)){
                    if(map.containsKey(x)){
                        map.put(x,map.get(x)-1);
                        if(map.get(x) == 0){
                            map.remove(x);
                        }
                    }
                    flag=true;
                }else{
                    flag=false;
                }

            }
            if(flag && map.size()==0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}