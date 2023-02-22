package math.소수;
/**
 * 그 수가 소수인지 확인하는 방법
 * 시간 복잡도는 루트 N 이다.
 * */
import java.io.*;
import java.util.StringTokenizer;

public class 소수인지확인 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;

    static void input() {
        N = scan.nextInt();
    }

    static boolean check(int x) {
        if (x < 2) {
            /**
             * 소수는 2 이상부터이다.
             * */
            return false;
        }
        /**
         * 루트이기 때문에 <= 로 해줘야한다.
         *
         * 이유는 특정 숫자가 소수인지 확인 하는 것이므로
         * 소수는 1 * 12, 2 * 6, 3 * 4 ... 이런식으로 진행이 된다.
         * 따라서 특정 숫자의 루트 이전까지만 확인하면 된다.
         * */
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        input();
        System.out.println(check(N));
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
