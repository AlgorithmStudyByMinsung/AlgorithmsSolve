package PhaseAlignment;
// https://www.acmicpc.net/problem/1005
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 문제에서 그래프라고 암시를 한다.
 * 사이클이 있음으로 tree 가 아니다. ---> visit 배열 필요
 *
 * 하지만 위상 정렬은 visit 배열이 필요가 없다. 왜냐면 지우니까
 * 또한 부모노드도 저장 할 필요가 없다. 왜냐면 순서가 있으니까
 *
 * 정해진 순서 규칙이 있음으로 bfs 아니라 위상정렬로 풀어야 한다.
 **/
public class Two_my {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T;
    static int N;
    static int K;
    static int W;

    static int[] d;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int start;


    static void input() {
        T = scan.nextInt();

        for (int i = 0; i < T; i++) {
            N = scan.nextInt();
            K = scan.nextInt();

            d = new int[N +1];
            visit = new boolean[N +1];
            adj = new ArrayList[N +1];

            for (int j = 1; j <= N ; j++) adj[j] = new ArrayList<>();

            for (int j = 1; j <= N ; j++) d[j] = scan.nextInt();

            for (int j = 1; j <= K ; j++) {
                int x = scan.nextInt();
                if (j == 1) start = x;

                int y = scan.nextInt();

                adj[x].add(y); adj[y].add(x);
            }

            W = scan.nextInt();

            bfs();
        }

    }

    static void bfs() {
        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visit[start] = true;
        sum += d[start];

        while (! queue.isEmpty()) {
            Integer x = queue.poll();
            System.out.println("x = " + x);

            int max = Integer.MIN_VALUE;

            boolean check = false;
            for (Integer y : adj[x]) {
                if (visit[y]) continue;
                System.out.println("y = " + y);
                if (adj[y].contains(W)) check = true;

                max = Math.max(max, d[y]);

                queue.add(y);
                visit[y] = true;
            }
            sum += max;
            System.out.println("sum = " + sum);
            if (check) {
                sum += d[W];
                System.out.println(sum);
                break;
            }
        }
    }

    public static void main(String[] args) {
        input();

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
