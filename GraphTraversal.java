import java.util.*;

class Quad<T, U, V, W> {
    T first;
    U second;
    V third;
    W fourth;

    Quad(T first, U second, V third, W fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }
}

public class GraphTraversal {
    static int[] dijkstra(List<Integer>[] adj, String[] type) {
        int n = adj.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        int[] par = new int[n];
        Arrays.fill(par, -1);

        PriorityQueue<Quad<Integer, Integer, Boolean, Boolean>> pq = new PriorityQueue<>(Comparator.comparingInt(q -> q.first));
        pq.add(new Quad<>(0, 0, false, false));

        while (!pq.isEmpty()) {
            var q = pq.poll();
            int u = q.second;
            int cur = q.first;
            boolean nitroPrev = q.third;
            boolean sandPrev = q.fourth;

            for (int v : adj[u]) {
                if (type[v].equals("Cop")) continue;
                
                boolean nitroNxt = false;
                boolean sandNxt = false;
                int time = 4;
                
                if (nitroPrev) time /= 2;
                if (sandPrev) time *= 2;
                
                switch (type[u]) {
                    case "Nitro" -> {
                        time /= 2;
                        nitroNxt = true;
                    }
                    case "Sand" -> {
                        time *= 2;
                        sandNxt = true;
                    }
                    case "Crash" -> time = 4;
                }

                if (cur + time < dist[v]) {
                    dist[v] = cur + time;
                    pq.add(new Quad<>(cur + time, v, nitroNxt, sandNxt));
                    par[v] = u;
                }
            }
        }
        return par;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 7;
        int m = in.nextInt();
        String[] specialPowers = {"None", "Cop", "Sand", "None", "Nitro", "None", "None"};
        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, i -> new ArrayList<>());

        while (m-- > 0) {
            int u = in.nextInt();
            int v = in.nextInt();
            adj[u].add(v);
        }

        int[] result = dijkstra(adj, specialPowers);

        if (result[n - 1] == -1) {
            System.out.println("No Path");
            return;
        }

        List<Integer> path = new ArrayList<>();
        int cur = n - 1;
        while (cur != -1) {
            path.add(cur);
            cur = result[cur];
        }
        Collections.reverse(path);
        System.out.println(path);
    }
}
