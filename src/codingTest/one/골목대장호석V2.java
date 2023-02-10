package codingTest.one;
// https://www.acmicpc.net/problem/20183
import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 정답 탐색: 문제의 정렬과 상관없이 정답의 범위가 정해져있고 log 를 씌워서 시간 복잡도가 괜찮다면 써보자
 * */
/**
 * 다익스트라 :
 * - 어찌 됫더간에 최소비용으로 찾아야 간선의 경우가 더 많이 나온다라는 사실을 이용
 * - 최소 비용으로 풀어서 해당 값보다 작은 지 큰 지 확인이 가능
 * - 특정 값보다 큰게 나오면 continue 를 쓰면 그 경로를 어차피 안감
 * */
public class 골목대장호석V2 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        public int to;
        /**
         * long
         * */
        public long weight;

        public Edge(int to , long weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    /**
     * Comparable 이다.
     * */
    static class Info implements Comparable<Info>{
        int idx;
        long money;

        public Info(int idx, long money) {
            this.idx = idx;
            this.money = money;
        }
        @Override
        public int compareTo(Info o) {
            return Long.compare(this.money , o.money);
        }
    }
    static int N;
    static int M;
    static int A;
    static int B;
    static long C;
    static ArrayList<Edge>[] adj;
    static long[] dist;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = scan.nextInt();
        B = scan.nextInt();
        C = scan.nextLong();

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N ; i++) adj[i] = new ArrayList<>();
        dist = new long[N + 1];

        for (int i = 0; i < M; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            long weight = scan.nextLong();

            adj[from].add(new Edge(to , weight));
        }
    }
    static void search() {
        long L = 1; long R = 1000000001; long ans = -1;
        while (L <= R) {
            long mid = (L + R)/ 2;

            if (dijkstra(mid)) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static boolean dijkstra(long x) {
        /**
         * 우선 순위 큐
         * */
        PriorityQueue<Info> queue = new PriorityQueue<>();
        for (int i = 1; i <= N ; i++) dist[i] = Long.MAX_VALUE;
        /**
         * dist[A] = 0 해줘야 함
         * */
        queue.add(new Info(A , 0));
        dist[A] = 0;

        while (! queue.isEmpty()) {
            Info info = queue.poll();
            if (info.money != dist[info.idx]) continue;

            for (Edge edge : adj[info.idx]) {
                /**
                 * 이렇게 하면 탐색을 못함
                 * */
                if (edge.weight > x) continue;

                if (dist[edge.to] > dist[info.idx] + edge.weight) {
                    dist[edge.to]= dist[info.idx] + edge.weight;

                    queue.add(new Info(edge.to , dist[edge.to]));
                }
            }
        }

        return dist[B] <= C;
    }

    public static void main(String[] args) {
        input();
        search();
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
