import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            String s = scanner.next();
            Stack<Pair<Character, Integer>> st = new Stack<>();
            long ans = 0;
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (!st.isEmpty() && ch == ')' && st.peek().getKey() == '_') {
                    st.pop();
                    ans += i - st.pop().getValue();
                } else if (!st.isEmpty() && ch == '_' && st.peek().getKey() == '(') {
                    st.pop();
                    ans += i - st.pop().getValue();
                } else {
                    st.push(new Pair<>(ch, i));
                }
            }
            System.out.println(ans);
        }
        scanner.close();
    }

    // Simple implementation of a Pair class
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}