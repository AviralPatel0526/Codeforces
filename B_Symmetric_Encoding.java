import java.util.*;
import java.lang.*;
import java.io.*;

public class B_Symmetric_Encoding {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            int n = sc.nextInt();
            String s = sc.next();
            HashSet<Character> set = new HashSet<>();
            StringBuilder rBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (!set.contains(s.charAt(i))) {
                    rBuilder.append(s.charAt(i));
                }
                set.add(s.charAt(i));
            }
            String r = rBuilder.toString();

            // Convert to a character array and sort it
            char[] rArray = r.toCharArray();
            Arrays.sort(rArray);
            r = new String(rArray);

            HashMap<Character, Character> map = new HashMap<>();
            int st = 0;
            int en = r.length() - 1;
            while (st <= en) {
                char ch1 = r.charAt(st);
                char ch2 = r.charAt(en);
                map.put(ch1, ch2);
                map.put(ch2, ch1);
                st++;
                en--;
            }

            StringBuilder ansBuilder = new StringBuilder();
            for (int k = 0; k < n; k++) {
                char ty = s.charAt(k);
                ansBuilder.append(map.get(ty));
            }
            String ans = ansBuilder.toString();
            System.out.println(ans);
        }
       
        sc.close();
    }
}
