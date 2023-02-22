package facemTest.one;
// https://www.acmicpc.net/problem/21924
/**
 * 이 문제를 난 다익스트라로 풀었고 틀렸다.
 *
 * 다익스트라는 최단거리이지 최소신장트리를 구하는 문제가 아니다.
 * */
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 도시건설_wrong {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        public int to;
        public int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info {
        public int idx;
        public int dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static int N;
    static int M;
    static ArrayList<Edge>[] adj;
    static boolean[][] visit;
    static int[] dist;
    static int start;
    static long sum;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        adj = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        visit = new boolean[M + 1][M + 1];

        for (int i = 0; i < M; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();

            if (i == 0) start = from;

            adj[from].add(new Edge(to , weight));
            adj[to].add(new Edge(from , weight));

            sum += weight;
        }
    }

    static void dijkstra() {
        PriorityQueue<Info> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        queue.add(new Info(start , 0));
        dist[start] = 0;

        while (! queue.isEmpty()) {
            Info info = queue.poll();

            if (info.dist != dist[info.idx]) continue;

            for (Edge edge : adj[info.idx]) {
                if (visit[info.idx][edge.to]) continue;
                if (visit[edge.to][info.idx]) continue;

                visit[info.idx][edge.to] = true;
                visit[edge.to][info.idx] = true;

                if (dist[edge.to] <= edge.weight) continue;

                dist[edge.to] = edge.weight;
                queue.add(new Info(edge.to , dist[edge.to]));
            }
        }
    }

    static void pro () {
        dijkstra();

        long res = 0;
        boolean check = false;

        for (int i = 1; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                check = true;
                break;
            }

            res += dist[i];
        }
        if (check) System.out.println("-1");
        else System.out.println(sum - res);
    }

    public static void main(String[] args) {
        input();
        pro();
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
