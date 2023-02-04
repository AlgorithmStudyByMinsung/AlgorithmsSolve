package dp.four;
// https://www.acmicpc.net/problem/15681
import java.io.*;
import java.util.*;
/**
 * 트리를 이용한 dp
 *
 * 트리는 dps 를 이용
 * */
public class One {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, R, Q;
    static ArrayList<Integer>[] con;
    static int[] Dy;

    static void input(){
        N = scan.nextInt();
        R = scan.nextInt();
        Q = scan.nextInt();
        con = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++){
            con[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++){
            int x = scan.nextInt(), y = scan.nextInt();
            con[x].add(y);
            con[y].add(x);
        }
    }

    // Dy[x] 를 계산하는 함수
    static void dfs(int x, int prev){
        /**
         * 이렇게 하면 마지막 자식은 1이 된다.
         * */
        Dy[x] = 1;

        for (int y: con[x]){
            if (y == prev) continue;
            dfs(y, x);
            Dy[x] += Dy[y];
        }
    }

    static void pro() {
        Dy = new int[N + 1];

        dfs(R, -1);

        for (int i = 1; i <= Q; i++){
            int q = scan.nextInt();
            sb.append(Dy[q]).append('\n');
        }
        System.out.println(sb);
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
