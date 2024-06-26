import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * C_Sofia_and_the_Lost_Operations
 */
public class C_Sofia_and_the_Lost_Operations {
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
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("").append(String.valueOf(object));
        }
        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        FastReader in = new FastReader();
        FastWriter out = new FastWriter();
	    int t= in.nextInt();

        while (t != 0) {
            t--;
            int n=in.nextInt();
            ArrayList<Integer> a=new ArrayList<>();
            for(int i=0;i<n;i++){
                a.add(in.nextInt());
            }
            ArrayList<Integer> b=new ArrayList<>();
            HashSet<Integer> set=new HashSet<>();
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<n;i++){
                b.add(in.nextInt());
                if(b.get(i)!=a.get(i)){
                    map.put(b.get(i),map.getOrDefault(b.get(i), 0)+1);
                }
                set.add(b.get(i));
            }
            int m=in.nextInt();
            ArrayList<Integer> d=new ArrayList<>();
            for(int i=0;i<m;i++){
                d.add(in.nextInt());
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
                out.println("YES");
            }else{
                out.println("NO");
            }
        }
        out.close();

    }
}