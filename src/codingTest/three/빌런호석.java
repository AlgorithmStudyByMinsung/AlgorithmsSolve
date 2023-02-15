package codingTest.three;
/**
 * 브루트 포스 + 구현
 * - 브루트 포스의 고정관념을 깨야한다.
 * */
// https://www.acmicpc.net/problem/22251
import java.io.*;
import java.util.StringTokenizer;

public class 빌런호석 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int K;
    static int P;
    static int X;
    static int[][] numbers = {
            {1, 1, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 0, 1, 1},
            {0, 1, 1, 1, 0, 1, 0},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 1, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1}
    };

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        P = scan.nextInt();
        X = scan.nextInt();
    }
    
    static int diff_one(int x, int y) {
        if (x == y) return 0;
        
        int res = 0;
        for (int i = 0; i <= 6; i++) {
            if (numbers[x][i] != numbers[y][i]) res ++;   
        }
        return res;
    }

    static int diff(int x, int y) {
        if (x == y) return 0;

        int res = 0;
        for (int i = 0; i < K; i++) {
            res += diff_one(x % 10, y % 10);

            x /= 10; y /= 10;
        }
        return res;
    }

    /**
     * 숫자 2개의 차이 값을 비교해서 p 보다 작으면 + 1
     *
     * */
    static void pro() {
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            if (i == X) continue;

            if (diff(X , i) <= P) ans ++;
        }
        System.out.println(ans);
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
