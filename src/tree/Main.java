package tree;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
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
    static void remove_dfs(int x) {
        visit[x] = true;

        for (Integer integer : adj[x]) {
            if (visit[integer]) continue;

            remove_dfs(integer);
        }
//        adj[parents[x]].removeIf(integer -> integer==x);
//        adj[x].removeIf(integer -> integer == parents[x]);
    }

    static void dfs(int x) {
        visit[x] = true;


        for (Integer integer : adj[x]) {
            if (visit[integer]) continue;

            if (adj[integer].size() == 1) ans ++;

            dfs(integer);
        }
    }
    public static void main(String[] args) {
        input();

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
