import java.util.*;
import java.lang.*;
import java.io.*;
public class C_Virus {

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
            int m=in.nextInt();
            int a[]=ai(m);
            ArrayList<Integer> list=new ArrayList<>();
            Arrays.sort(a);
            list.add(a[0]-1+n-a[m-1]);
            for(int i=1;i<m;i++){
                list.add(a[i]-a[i-1]-1);
            }
            Collections.sort(list,(x,y)->y-x);
            int cnt=0;
            int gap=0;
            for(int i=0;i<list.size();i++){
                int num=list.get(i)-2*gap;
                if(num <= 0){
                    break;
                }
                num--;
                gap+=2;
                if(num == 0){
                    cnt+=1;
                    break;
                }
                cnt+=num;
            }
            System.out.println(n-cnt);
        }
    }
}