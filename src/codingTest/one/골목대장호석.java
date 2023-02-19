package codingTest.one;
// 부분만 맞음
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
// 아직 답변 못들음
public class 골목대장호석 {
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

    static int N;
    static int M;
    static int A;
    static int B;
    static int C;
    static ArrayList<Edge>[] adj;
    static int[] d;


    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = scan.nextInt();
        B = scan.nextInt();
        C = scan.nextInt();

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N ; i++) adj[i] = new ArrayList<>();
        d = new int[N + 1];

        for (int i = 1; i <= N ; i++) {
            d[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();

            adj[from].add(new Edge(to , weight));
        }
    }

    static void dfs (int x, int money) {
        ArrayList<Edge> edges = adj[x];
        for (Edge edge : edges) {
            if (money - edge.weight < 0) continue;

            if (d[edge.to] != -1) {
                d[edge.to] = Math.min(d[edge.to], Math.max(d[x], edge.weight));
            } else {
                d[edge.to] = Math.max(edge.weight , d[x]);
            }

            dfs(edge.to , money - edge.weight);
        }
    }

    public static void main(String[] args) {
        input();
        dfs(A , C);
        System.out.println(d[B]);
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
