package tree;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Two_my {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int R;
    static ArrayList<Integer>[] adj;
    static int[] parents;
    static boolean[] visit;
    static int ans;
    static int start;

    static void input() {
        N = scan.nextInt();
        parents = new int[N];
        visit = new boolean[N];
        adj = new ArrayList[N];

        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            int x= scan.nextInt();

            if (x == -1) start = i;
            if (x == -1) continue;

            parents[i] = x;

            adj[i].add(x); adj[x].add(i);
        }

        R = scan.nextInt();
    }

    // 지워야 할 노드로 부터 탐색을 시작한다.
    // 그 후 visit 처리를 한다.
    static void remove_dfs(int x) {
        visit[x] = true;

        for (Integer integer : adj[x]) {
            if (visit[integer]) continue;

            remove_dfs(integer);
        }
    }
    // 자식이 1개인 노드들을 센다
    static void dfs(int x) {
        visit[x] = true;
        if (adj[x].size() == 1) ans ++;

        for (Integer integer : adj[x]) {
            if (visit[integer]) continue;

            dfs(integer);
        }
    }
    public static void main(String[] args) {
        input();

        if (R == start) {
            System.out.println(0);
            return;
        }

        visit[parents[R]] = true;
        remove_dfs(R);

        visit[parents[R]] = false;

        dfs(start);
        System.out.println(ans);

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
