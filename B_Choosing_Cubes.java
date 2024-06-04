import java.util.*;
import java.lang.*;
import java.io.*;

public class B_Choosing_Cubes {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            t--;
            int n = sc.nextInt();
            int f = sc.nextInt();
            int k = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }
            int num = list.get(f-1);
            Collections.sort(list, Collections.reverseOrder());
            int st=0;
            int en=n-1;
            for(int i=0;i<n;i++){
                if(list.get(i) == num){
                    st=i;
                    break;
                }
            }
            for(int i=n-1;i>=0;i--){
                if(list.get(i) == num){
                    en=i;
                    break;
                }
            }
            if(st+1 <= k && en+1 <= k){
                System.out.println("YES");
            }else if(st+1 > k){
                System.out.println("NO");
            }else{
                System.out.println("MAYBE");
            }
        }
        sc.close();
    }
}
