import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
public class B_Subtract_Operation {

    // GCD Method
    static long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
    
    // LCM Method
    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
    
    static FastReader in = new FastReader();
    // input of int array
    static int[] ai(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = in.nextInt();
        return arr;
    }
    
    // input of long array
    static long[] al(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = in.nextLong();
        return arr;
    }
    
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
    
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
    
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    
        int nextInt() {
            return Integer.parseInt(next());
        }
    
        long nextLong() {
            return Long.parseLong(next());
        }
    
        double nextDouble() {
            return Double.parseDouble(next());
        }
    
        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int n=in.nextInt();
            long k=in.nextLong();
            long a[]=al(n);
            // Arrays.sort(a);
            boolean flag=false;
            if(n==1){
                if(a[0] == k){
                    flag=true;
                }
            }else{
                // int i=0;
                // int j=1;
                // while(j<n && i<n){
                //     if(a[i]+k == a[j]){
                //         flag=true;
                //         break;
                //     }else if(a[i]+k < a[j]){
                //         i++;
                //     }else{
                //         j++;
                //     }
                // }
                HashMap<Long,ArrayList<Integer>> map=new HashMap<>();
                for(int i=0;i<n;i++){
                    if(map.containsKey(a[i])){
                        map.get(a[i]).add(i);
                    }else{
                        ArrayList<Integer> temp=new ArrayList<>();
                        temp.add(i);
                        map.put(a[i],temp);
                    }
                }
                outer : for(int i=0;i<n;i++){
                    if(map.containsKey(a[i]+k)){
                        for(int j=0;j<map.get(a[i]+k).size();j++){
                            if(map.get(a[i]+k).get(j) != i){
                                flag=true;
                                break outer;
                            }
                        }
                    }
                }
            }
            
            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }
}