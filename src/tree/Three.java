package tree;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/4803
public class Three {
    /**
     * 트리의 특성을 살린 문제
     *
     * - 노드가 하나여도 트리이다.
     * - 간선 = 정점 - 1 하지만 양방향이므로 곱하기 2
     * - multi dfs 이다. 시작점을 다르게 해서 dfs 를 돌리면 tree 의 갯 수가 나온다.
     * */
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int M;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int vertex;
    static int edges;

    static void input() {
        /**
         * test case 문제에서는 이렇게 하면 새로 다시 만들어진다.
         * */
        N = scan.nextInt();
        M = scan.nextInt();

        adj = new ArrayList[N +1];
        visit = new boolean[N +1];

        for (int i = 1; i <= N ; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            adj[x].add(y); adj[y].add(x);
        }

    }

    static void dfs(int x) {
        visit[x] = true;
        vertex ++;

        for (Integer integer : adj[x]) {
            edges ++;

            if (visit[integer]) continue;

            dfs(integer);
        }
    }

    static void pro(int i) {
        int ans = 0;

        for (int j = 1; j <= N ; j++) {
            if (visit[j]) continue;
            vertex = 0;
            edges = 0;

            dfs(j);

            if (edges == (vertex -1)*2) ans ++;
        }
        sb.append("Case").append(' ').append(i).append(": ");
        if (ans == 0) {
            sb.append("No trees.").append('\n');
        } else if (ans == 1) {
            sb.append("There is one tree.").append('\n');
        } else {
            sb.append("A forest of ").append(ans).append(" trees.").append('\n');
        }
    }

    public static void main(String[] args) {
        for (int i = 1;; i++) {
            input();
            if (N == 0 && M == 0) break;
            // visit 배열 초기화
            pro(i);
        }
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
