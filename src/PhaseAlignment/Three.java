package PhaseAlignment;
import java.io.*;
import java.util.*;
// https://www.acmicpc.net/problem/2623
/**
 * 보면 순서 문제
 * 키워드 : 순서!!
 *
 * inDegree 가 중요
 *
 * 들어오는 차수가 없다면 그게 1순위!
 **/
public class Three {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int M;
    static ArrayList<Integer>[] adj;
    static int[] inDegree;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        adj = new ArrayList[N +1];
        inDegree = new int[N +1];
        for (int i = 1; i <= N ; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int T = scan.nextInt();

            int[] a = new int[T];

            for (int j = 0; j < T; j++) {
                a[j] = scan.nextInt();
            }

            for (int j = 0; j < T -1; j++) {
                for (int k = j +1; k < T ; k++) {
                    adj[a[j]].add(a[k]);
                    inDegree[a[k]] ++;
                }
            }
        }
    }

    static void pro() {
        int cnt = 0;

        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N ; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (! queue.isEmpty()) {
            Integer x = queue.poll();
            cnt ++;
            sb.append(x).append('\n');

            for (Integer y : adj[x]) {
                inDegree[y] --;

                if (inDegree[y] == 0) queue.add(y);
            }
        }
        if (cnt == N) System.out.println(sb);
        else System.out.println(0);
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
