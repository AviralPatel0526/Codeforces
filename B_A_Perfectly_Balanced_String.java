import java.util.*;
import java.lang.*;
import java.io.*;
public class B_A_Perfectly_Balanced_String {

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
            String s=in.next();
            int n=s.length();
            HashMap<Character,Integer> map=new HashMap<>();
            HashSet<Character> set=new HashSet<>();
            for(int i=0;i<n;i++){
                set.add(s.charAt(i));
            }
            boolean flag=true;
            int a[][]=new int[n][26];
            for(int i=0;i<n;i++){
                char ch=s.charAt(i);
                if(i == 0){
                    a[i][ch-'a']++;
                }else{
                    a[i][ch-'a']++;
                    for(int k=0;k<26;k++){
                        a[i][k]+=a[i-1][k];
                    }
                }
                if(map.containsKey(ch)){
                    int dif[]=new int[26];
                    for(int k=0;k<26;k++){
                        dif[k]=a[i][k]-a[map.get(ch)][k];
                    }
                    int cnt=0;
                    for(int z=0;z<26;z++){
                        if(dif[z] > 0){
                            cnt++;
                        }
                    }
                    if(cnt != set.size()){
                        flag=false;
                        break;
                    }
                }
                map.put(ch,i);
            }
            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}