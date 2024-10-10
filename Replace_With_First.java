import java.util.*;

import java.lang.*;

import java.io.*;

/**
 * 
 * Replace_With_First
 * 
 */

class Replace_With_First {

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

        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        return arr;

    }

    // input of long array

    static long[] al(int n) {

        long[] arr = new long[n];

        for (int i = 0; i < n; i++)
            arr[i] = in.nextLong();

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

            int n = in.nextInt();

            int m = in.nextInt();

            String s = in.next();

            String s2 = in.next();

            if (n < m) {

                String temp = s;

                s = s2;

                s2 = temp;

                int x = n;

                n = m;

                m = x;

            }

            if (s.charAt(0) != s2.charAt(0)) {

                System.out.println(-1);

            } else {

                if (s.equals(s2)) {

                    System.out.println(0);

                } else {

                    int i = 0;

                    while (i < m) {

                        if (s.charAt(i) != s2.charAt(i)) {

                            break;

                        }

                        i++;

                    }

                    boolean flag = true;

                    int j = n - 1;

                    int k = m - 1;

                    while (k >= i) {

                        if (s.charAt(j) != s2.charAt(k)) {

                            flag = false;

                        }

                        k--;

                        j--;

                    }

                    if (flag) {

                        System.out.println(1);

                    } else {

                        System.out.println(2);

                    }

                }

            }

        }

    }

}