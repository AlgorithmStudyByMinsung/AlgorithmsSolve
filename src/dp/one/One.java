package dp.one;
// https://www.acmicpc.net/problem/9095
import java.io.*;
import java.util.*;

public class One {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] Dy;

    /**
     * test Case 문제는 미리 만들어 놓고 해야한다.
     * */
    static void preprocess(){
        /**
         * dp는 이걸 만들어야 한다.
         * */
        Dy = new int[12];
        // 초기값 구하기
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;

        // 점화식을 토대로 Dy 배열 채우기
        for (int i = 4; i <= 11; i++){
            Dy[i] = Dy[i - 1] + Dy[i - 2] + Dy[i - 3];
        }
    }

    /**
     * 미리 만들어 놓고 할 수 있음 만들어 놓자
     **/
    static void pro() {
        int T = scan.nextInt();
        for (int tt = 1; tt <= T; tt++){
            int N = scan.nextInt();
            sb.append(Dy[N]).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) {
        preprocess();
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