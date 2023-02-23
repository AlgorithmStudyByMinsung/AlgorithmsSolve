package facemTest.two;
// https://www.acmicpc.net/problem/21941
import java.io.*;
import java.util.StringTokenizer;
/**
 * dp 문제
 *
 * 유형
 * - 1차원 배열
 *
 * - d[i] = d[i - 경우 1번] + p[경우 1번]
 *          d[i - 경우 1번] + p[경우 1번]
 *          선택 x
 *
 *          중에 Max 값
 * */
public class 문자열제거 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class EraseStr {
        public String a;
        public int score;

        public EraseStr(String a, int score) {
            this.a = a;
            this.score = score;
        }
    }

    static String S;
    static int M;
    static EraseStr[] a;
    static int[] d;


    static void input() {
        S = scan.next();
        M = scan.nextInt();

        a = new EraseStr[M];
        d = new int[S.length()];

        for (int i = 0; i < M; i++) {
            a[i] = new EraseStr(scan.next(), scan.nextInt());
        }
    }

    static void dp() {
        for (int i = 0; i < S.length(); i++) {
            if (i - 1 >= 0) {
                d[i] = 1 + d[i - 1];
            } else {
                d[i] = 1;
            }

            for (EraseStr eraseStr : a) {
                int length = eraseStr.a.length();
                if (length > i + 1) continue;

                String substring = S.substring(i - length + 1, i + 1);

                if (substring.equals(eraseStr.a)) {
                    if (i - length >= 0) {
                        d[i] = Math.max(d[i] , d[i - length] + eraseStr.score);
                    } else {
                        d[i] = Math.max(d[i] , eraseStr.score);
                    }
                }
            }
        }

        System.out.println(d[S.length() - 1]);
    }

    public static void main(String[] args) {
        input();
        dp();
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
