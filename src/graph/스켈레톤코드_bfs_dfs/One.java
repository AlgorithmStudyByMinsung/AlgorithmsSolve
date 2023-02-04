package graph.스켈레톤코드_bfs_dfs;
// https://www.acmicpc.net/problem/1260
/**
 * bfs 와 dfs 의 기본
 *
 * - 특징: 자식이 방문 됫으면 안간다.
 **/
import java.io.*;
import java.util.*;

public class One {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int M;
    static int V;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();
        visited = new boolean[N+1];
        adj = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            adj[x].add(y);
            adj[y].add(x);
        }
        for (int i = 1; i <=N ; i++) {
            Collections.sort(adj[i]);
        }

    }

    static void dfs(int x) {
        visited[x] = true;
        sb.append(x).append(' ');

        for (Integer integer : adj[x]) {
            if (visited[integer]) continue;

            dfs(integer);
        }
    }

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();

        // init
        queue.add(x);
        visited[x] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll(); // 여기서 visit 처리 x
            sb.append(poll).append(' ');

            for (Integer integer : adj[poll]) {
                /**
                 * 자식 기준으로 continue 처리와 visit 처리를 해준다.
                 **/
                if (visited[integer]) continue;

                queue.add(integer);
                visited[integer] = true;
            }

        }



    }

    public static void main(String[] args) {
        input();
        dfs(V);
        sb.append('\n');

        for (int i = 1; i <= N ; i++) visited[i] = false;

        bfs(V);

        System.out.println(sb);
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
