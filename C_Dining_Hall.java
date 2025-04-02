import java.io.*;
import java.util.*;

public class C_Dining_Hall {
    
    // Generic Pair class definition.
    static class Pair<F, S> {
        F f;
        S s;
        public Pair(F first, S second) {
            this.f = first;
            this.s = second;
        }
        @Override
        public int hashCode() {
            return f.hashCode() * 31 + s.hashCode();
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair<?, ?> p = (Pair<?, ?>) o;
            return f.equals(p.f) && s.equals(p.s);
        }
    }

    // Node class to store a coordinate and its weight (priority)
    static class Node {
        Pair<Long, Long> coord;
        long weight;
        public Node(Pair<Long, Long> coord, long weight) {
            this.coord = coord;
            this.weight = weight;
        }
    }

    // Computes the "distance" or priority for a given cell.
    static long getDistance(long x, long y) {
        int m1 = (int) (x % 3);
        int m2 = (int) (y % 3);
        if (m1 == 2 && m2 == 2) {
            return x + y + 3;
        }
        return x + y + 1;
    }

    // Adds four new candidate cells to the priority queue based on the current (x, y) and returns the next expansion coordinates.
    static long[] addCells(PriorityQueue<Node> pq, long x, long y) {
        int[] arr = {1, 2};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                long xx = 3L * x + arr[i];
                long yy = 3L * y + arr[j];
                long d = getDistance(xx, yy);
                pq.add(new Node(new Pair<>(xx, yy), d));
            }
        }
        // Update expansion coordinates systematically.
        if (y == 0) {
            return new long[]{0, x + 1};
        }
        return new long[]{x + 1, y - 1};
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        // Global priority queue: orders nodes by weight, then x and y values.
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            if (n1.weight != n2.weight)
                return Long.compare(n1.weight, n2.weight);
            if (!n1.coord.f.equals(n2.coord.f))
                return Long.compare(n1.coord.f, n2.coord.f);
            return Long.compare(n1.coord.s, n2.coord.s);
        });
        
        // Initialize the expansion coordinates and populate the global queue with enough cells.
        long x = 0, y = 0;
        for (int i = 0; i < 50000; i++) {
            long[] next = addCells(pq, x, y);
            x = next[0];
            y = next[1];
        }
        
        // Process each test case.
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            // Set to keep track of coordinates that have been output.
            Set<Pair<Long, Long>> used = new HashSet<>();
            // For non-priority cells (when arr[i] == 0), we use a scanning mechanism.
            long x2 = 1, y2 = 1;
            long[][] res = new long[n][2];
            // Temporary queue to store removed nodes from pq so they can be restored later.
            PriorityQueue<Node> temp = new PriorityQueue<>(pq.comparator());
            
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) {
                    // Find the next available cell in the scanning order.
                    while (used.contains(new Pair<>(x2, y2))) {
                        if (y2 >= 4) {
                            x2 += 3;
                            y2 -= 3;
                        } else {
                            y2 = x2 + 3;
                            x2 = 1;
                        }
                    }
                    res[i][0] = x2;
                    res[i][1] = y2;
                    used.add(new Pair<>(x2, y2));
                } else {
                    // For arr[i] == 1, take the next available candidate from the priority queue.
                    while (true) {
                        Node node = pq.poll();
                        temp.add(node);  // Save the node to restore later.
                        if (used.contains(node.coord)) {
                            continue;
                        }
                        used.add(node.coord);
                        res[i][0] = node.coord.f;
                        res[i][1] = node.coord.s;
                        break;
                    }
                }
            }
            // Output the results for this test case.
            for (int i = 0; i < n; i++) {
                System.out.println(res[i][0] + " " + res[i][1]);
            }
            // Restore nodes back into the global priority queue.
            while (!temp.isEmpty()) {
                pq.add(temp.poll());
            }
        }
    }
}
