package codingTest.two;
// 부분점수....
// https://www.acmicpc.net/problem/21278
import java.io.*;
import java.util.*;
/**
 * 브루트 포스 + bfs(최단거리 + multiSource)
 *
 * 최단거리 : bfs & 다익스트라
 * */
public class 호석이두마리치킨 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Ans implements Comparable<Ans> {
        public int a;
        public int b;

        public Ans(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Ans o) {
            if (this.a != o.a) return this.a - o.a;
            return this.b - o.b;
        }
    }

    static int N;
    static int M;
    static ArrayList<Integer>[] adj;
    static int[] d;
    static boolean[] visit;
    static int[] sel;
    static ArrayList<Ans> ansArrayList = new ArrayList<>();

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        adj = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        d = new int[N + 1];
        sel = new int[4];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            /**
             * 해당문제는 양방향이었음
             * */
            adj[x].add(y); adj[y].add(x);
        }
    }
    static int ans = Integer.MAX_VALUE;
    static void bruteForce (int x, int cnt) {
        if (cnt == 3) {
            if (ans >= bfs(sel[1], sel[2])) {
                ans = bfs(sel[1], sel[2]);

                if (sel[1] < sel[2]) {
                    ansArrayList.add(new Ans(sel[1], sel[2]));
                } else {
                    ansArrayList.add(new Ans(sel[2], sel[1]));
                }
            }
            return;
        }
        for (int i = x + 1; i <= N; i++) {
            sel[cnt] = i; cnt += 1;
            bruteForce(i , cnt);
            sel[cnt] = 0; cnt -= 1;
        }
    }

    static int bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        //init
        queue.add(x); queue.add(y);

        for (int i = 1; i <= N; i++) {
            visit[i] = false;
            d[i] = 0;
        }
        /**
         * 처음에도 visit check
         * */
        visit[x] = true; visit[y] = true;

        // start
        while (! queue.isEmpty()) {
            int p = queue.poll();

            for (Integer z : adj[p]) {
                if (visit[z]) continue;

                queue.add(z);
                visit[z] = true;
                d[z] = d[p] + 1;
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += d[i];
        }
        return sum * 2;
    }

    public static void main(String[] args) {
        input();
        bruteForce(0 , 1);
        Collections.sort(ansArrayList);

        Ans ans1 = ansArrayList.get(0);
        sb.append(ans1.a).append(' ').append(ans1.b).append(' ');
        sb.append(ans);

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
