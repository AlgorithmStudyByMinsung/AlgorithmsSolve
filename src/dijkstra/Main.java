package dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 최단거리를 구해라! --> bfs or 다익스트라
 *
 * 가중치가 1이냐 아니냐 --> 나뉨
 * */
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info {
        int idx;
        int dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static int N;
    static int M;
    static int s;
    static int d;

    static ArrayList<Edge>[] edges;
    /**
     * 현재 info 의 dist 값과 같음
     * */
    static int[] dist;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        edges = new ArrayList[N +1];
        dist = new int[N +1];

        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < M ; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();

            edges[from].add(new Edge(to, weight));
        }

        s = scan.nextInt();
        d = scan.nextInt();

    }

    static void dijkstra() {
        PriorityQueue<Info> infos = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        // init

        /**
         * info 를 초기화 하는 것이 아니라 dist 를 초기화를 한다.
         * */
//        for (int i = 1; i <= N ; i++) {
//            if (i == s) continue;
//
//            infos.add(new Info(i, Integer.MAX_VALUE));
//        }

        for (int i = 1; i <= N ; i++) dist[i] = Integer.MAX_VALUE;

        infos.add(new Info(s, 0));
        dist[s] = 0;

        // pro
        while (! infos.isEmpty()) {
            Info x = infos.poll();

            // valid check
            /**
             * 같지 않다 == 예전 값 == 최솟 값이 아니다.
             * */
            if (dist[x.idx] != x.dist) continue;

            for (Edge edge1 : edges[x.idx]) {
                if (dist[x.idx] + edge1.weight >= dist[edge1.to]) continue;

                dist[edge1.to] = dist[x.idx] + edge1.weight;
                infos.add(new Info(edge1.to, dist[edge1.to]));
            }
        }

        System.out.println(dist[d]);
    }

    public static void main(String[] args) {
        input();
        dijkstra();
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
