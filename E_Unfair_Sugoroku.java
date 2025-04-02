import java.util.*;
import java.lang.*;
import java.io.*;

public class E_Unfair_Sugoroku {

    static final int MOD = 998244353;
    static long invP, invQ;
    // We'll use memoization: state is defined by (a, b, turn)
    // Here turn: 0 for Takahashi's turn, 1 for Aoki's turn.
    static int[][][] memo;
    
    // Fast modular exponentiation.
    static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while(exp > 0) {
            if((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
    
    // Modular inverse using Fermat's little theorem.
    static long modInverse(long x, long mod) {
        return modPow(x, mod - 2, mod);
    }
    
    // f(a, b, p, q, n, prev) returns the probability (mod MOD) that Takahashi wins
    // starting from positions a and b, with 'prev' indicating whose turn it is:
    // prev==0 means Takahashi's turn; prev==1 means Aoki's turn.
    public static int f(int a, int b, int p, int q, int n, int prev) {
        // Terminal conditions: if a reaches n, Takahashi wins; if b reaches n, he loses.
        if (a == n) return 1;
        if (b == n) return 0;
        
        if (memo[a][b][prev] != -1) return memo[a][b][prev];
        
        long ans = 0;
        if (prev == 0) { // Takahashi's turn; his die outcomes are 1...p.
            for (int i = 1; i <= p; i++) {
                int newA = Math.min(a + i, n);
                // Multiply by the probability of the outcome: 1/p (using modular inverse invP).
                ans = (ans + invP * f(newA, b, p, q, n, 1)) % MOD;
            }
        } else { // Aoki's turn; his die outcomes are 1...q.
            for (int j = 1; j <= q; j++) {
                int newB = Math.min(b + j, n);
                ans = (ans + invQ * f(a, newB, p, q, n, 0)) % MOD;
            }
        }
        
        memo[a][b][prev] = (int) ans;
        return (int) ans;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  // endpoint
        int a = in.nextInt();  // Takahashi's starting position
        int b = in.nextInt();  // Aoki's starting position
        int p = in.nextInt();  // sides on Takahashi's die
        int q = in.nextInt();  // sides on Aoki's die
        
        // Precompute modular inverses for p and q.
        invP = modInverse(p, MOD);
        invQ = modInverse(q, MOD);
        
        // Create memoization table.
        // Dimensions: positions 0..n for both players and 2 for turn.
        memo = new int[n + 1][n + 1][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k < 2; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        
        // Takahashi starts (prev==0).
        int answer = f(a, b, p, q, n, 0);
        System.out.println(answer);
    }
}