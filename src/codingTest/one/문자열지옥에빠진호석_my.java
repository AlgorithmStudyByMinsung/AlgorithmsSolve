package codingTest.one;
// https://www.acmicpc.net/problem/20166
// 시간 : 50분
// 실수했지만 맞음
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * 1. 문제를 잘읽어야 함 왜냐면 K 는 테스트 케이스 회수고 신이 좋아하는 문자열길이랑은 별개
 * 2. 브루트포스와 그래프가 아닌 그래프문제랑 다른 점은 브루트 포스는 N*N 이라면 이건 N*M*상수*상수 <-- 이렇게 상수이다.
 * */
public class 문자열지옥에빠진호석_my {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int M;
    static int K;
    static String[] a;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, -1}, {1, 1}, {-1, 1}, {-1, -1}};
    static Map<String, Integer> ansCnt = new HashMap<>();

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();

        a = new String[N];

        for (int i = 0; i < N; i++) a[i] = scan.nextLine();
    }

    static int changeX(int x) {
        if (x >= 0 && x < N) {
            return x;
        } else if (x < 0) {
            return N - 1;
        } else if (x >= N) {
            return 0;
        }
        throw new IllegalArgumentException("my_error_x");
    }

    static int changeY(int y) {
        if (y >= 0 && y < M) {
            return y;
        } else if (y < 0) {
            return M - 1;
        } else if (y >= M) {
            return 0;
        }
        throw new IllegalArgumentException("my_error_y");
    }
    /**
     * 이걸 무조건 static 으로 빼야한다.
     * */
    static int sum = 0;
    static void dfs(int x, int y, String s) {

        if (ansCnt.containsKey(s)) ansCnt.put(s, ansCnt.get(s) + 1);
        else ansCnt.put(s , 1);

        if (s.length() == 5) return;

        for (int i = 0; i < 8 ; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

            int x1 = changeX(nx);
            int y1 = changeY(ny);

            String concat = s.concat(String.valueOf(a[x1].charAt(y1)));

            dfs(x1, y1, concat);
        }
    }
    static void pro() {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                dfs(x, y, String.valueOf(a[x].charAt(y)));
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();

        for (int i = 0; i < K; i++) {
            String ans = scan.nextLine();

            Integer integer = ansCnt.get(ans);
            if (integer == null) integer = 0;

            sb.append(integer).append('\n');
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
