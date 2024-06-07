import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * A_Forked
 */
public class A_Forked {

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
    static class Pair {
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
        
    public static void main(String[] args) throws java.lang.Exception {
        FastReader in = new FastReader();
        FastWriter out = new FastWriter();
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int a=in.nextInt();
            int b=in.nextInt();
            int kx=in.nextInt();
            int ky=in.nextInt();
            int qx=in.nextInt();
            int qy=in.nextInt();
            ArrayList<Pair> list=new ArrayList<>();
            int ax[]={1,1,-1,-1};
            int by[]={1,-1,-1,1};
         
            for(int i=0;i<4;i++){
                int nx=qx+ax[i]*a;
                int ny=qy+by[i]*b;
                list.add(new Pair(nx,ny));
            }
            
            if(a != b){
                for(int i=0;i<4;i++){
                    int nx=qx+ax[i]*b;
                    int ny=qy+by[i]*a;
                    list.add(new Pair(nx,ny));
                }
            }
            int count=0;
            for(int i=0;i<list.size();i++){
                int lx=list.get(i).x;
                int ly=list.get(i).y;
                for(int o=0;o<4;o++){
                    int nx=lx+ax[o]*a;
                    int ny=ly+by[o]*b;
                    if(kx == nx && ky == ny){
                        count++;
                    }
                }
                
                if(a != b){
                    for(int p=0;p<4;p++){
                        int nx=lx+ax[p]*b;
                        int ny=ly+by[p]*a;
                        if(kx == nx && ky == ny){
                            count++;
                        }
                    }
                }
                
            }
            out.println(count);
        }
        out.close();
    }
}