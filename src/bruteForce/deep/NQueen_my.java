package bruteForce.deep;
// https://www.acmicpc.net/problem/9663
/**
 * back tracking 문제
 *
 * - 재귀를 다 돌려서 확인 X
 * - 재귀 도중에 아니라면 처음으로 Back!!
 **/

import java.io.*;
import java.util.StringTokenizer;

public class NQueen_my {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int ans;
    static int[] selected;
    static void input() {
        N = scan.nextInt();
        selected = new int[N]; // 죄표 문제라고 이중 배열을 만들 필요는 없다.

    }
    static boolean isAvailable(int x, int y) {
        boolean check = true;
        /**
         * y1 < y 로 하면 좋음.
         **/
        for (int y1 = 0; y1 < y ; y1++) {
            int x1 = selected[y1];

            if (Math.abs(x-x1) == Math.abs(y -y1) || x == x1) return false;
        }
        return check;
    }
    static void rec_func(int y){
        if (y == N) {
            ans++;
            return;
        }
        for (int x = 0; x <N; x++) {
            if (isAvailable(x, y)) {
                selected[y] =x;
                rec_func(y+1);
                selected[y] =0;
            }
        }
    }



    public static void main(String[] args) {
        input();
        rec_func(0);
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
