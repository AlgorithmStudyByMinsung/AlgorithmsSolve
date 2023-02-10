package dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Two {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Info {
        int idx;
        int dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int V;
    static int E;
    static int s;
    static ArrayList<Edge>[] edges;
    static int[] dist;

    static void input() {
        V = scan.nextInt();
        E = scan.nextInt();

        s = scan.nextInt();

        dist = new int[V +1];
        edges = new ArrayList[V +1];
        for (int i = 1; i <= V ; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();

            edges[from].add(new Edge(to, weight));
        }
    }

    static void pro() {
        PriorityQueue<Info> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        for (int i = 1; i <= V ; i++) {
            if (i == s) continue;
            dist[i] = Integer.MAX_VALUE;
        }

        queue.add(new Info(s, 0));

        while (! queue.isEmpty()) {
            Info x = queue.poll();

            if (x.dist != dist[x.idx]) continue;

            for (Edge y : edges[x.idx]) {
                if (y.weight + dist[x.idx] >= dist[y.to]) continue;

                dist[y.to] = y.weight + dist[x.idx];

                queue.add(new Info(y.to, dist[y.to]));
            }
        }

    }

    public static void main(String[] args) {
        input();
        pro();

        for (int i = 1; i <= V ; i++) {
            if (dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
