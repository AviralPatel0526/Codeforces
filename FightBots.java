import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * FightBots
 */
public class FightBots {

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
    
        while (t-- > 0) {
            int n = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            String s = in.next();
            
            int aliceX = 0, aliceY = 0;
            boolean bobWins = false;
            
            for (int i = 0; i < n; i++) {
                char move = s.charAt(i);
                
                // Update Alice's position
                if (move == 'R') aliceX++;
                else if (move == 'L') aliceX--;
                else if (move == 'U') aliceY++;
                else if (move == 'D') aliceY--;
                
                // Bob moves one step towards Alice
                if (x != aliceX) {
                    if (x < aliceX) x++;
                    else x--;
                } else {
                    // If x coordinates are aligned, move along y
                    if (y < aliceY) y++;
                    else if (y > aliceY) y--;
                }

                // After Bob's move, check if their positions match
                if (x == aliceX && y == aliceY) {
                    bobWins = true;
                    break;
                }
            }
            
            if (bobWins) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
    }
    
    
}