
    import java.io.*;
    import java.util.*;
    
    public class D_Rating_Compression {
        static final int MXN = 300001;
    
        public static void solve(Scanner sc, PrintWriter out) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] cnt = new int[n + 1]; // cnt[x] = number of occurrences of x in the array (0-indexed numbers)
            boolean[] ans = new boolean[n]; // final answer
    
            // initialize frequency array and answer array
            for (int i = 0; i <= n; i++) {
                cnt[i] = 0;
            }
            // Read array and switch to 0-indexing
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                arr[i]--; // switch to 0-indexing
                cnt[arr[i]]++;
            }
    
            int tp = -1;
            while (tp + 1 <= n && cnt[tp + 1] == 1) {
                tp++;
            }
            // ans[0] is true if every number from 0 to n-1 occurs exactly once (i.e. it's a permutation)
            ans[0] = (tp == n - 1);
    
            int l = 0, r = n - 1;
            // special case, min = 0
            ans[n - 1] = (cnt[0] > 0);
    
            // shrink the interval as long as our checks pass
            for (int i = n - 1; i > 0; i--) {
                if (!ans[n - 1])
                    break;
                ans[i] = true;
                int nxt = n - i - 1;
                // Decrement count of nxt
                cnt[nxt]--;
                if (cnt[nxt] == 0 && (arr[l] == nxt || arr[r] == nxt) && cnt[nxt + 1] > 0) {
                    if (arr[l] == nxt) {
                        l++;
                    }
                    if (arr[r] == nxt) {
                        r--;
                    }
                    continue;
                }
                break;
            }
    
            // Output the answer as a contiguous string of 0's and 1's.
            for (int i = 0; i < n; i++) {
                out.print(ans[i] ? "1" : "0");
            }
            out.println();
        }
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out);
            int T = sc.nextInt();
            while (T-- > 0) {
                solve(sc, out);
            }
            out.flush();
            out.close();
        }
    }
    