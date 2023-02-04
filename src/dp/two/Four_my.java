package dp.two;
// https://www.acmicpc.net/problem/11057
import java.io.*;
import java.util.StringTokenizer;
/**
 * 정답은 문제를 10007로 나눈 값을 원한다.
 * 난 정답을 구하고 10007로 나눴지만
 * d 배열에 10007 로 나눈 값을 저장 했어야 했고
 * 그래야 integer 범위로 풀 수 있다.
 * */
public class Four_my {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int ans;
    static int d[][];


    static void input() {
        N = scan.nextInt();
        d = new int [1001][10];
        for (int i = 0; i < 10; i++) {
            d[1][i] = 1;
        }
    }

    static void pro() {
        for (int i = 2; i <=1000 ; i++) {
            for (int j = 0; j <10 ; j++) {
                for (int k = 0; k <= j; k++) {
                    d[i][j] += d[i -1][k];
                }
                d[i][j] %= 10007;
            }
        }
        for (int i = 0; i < 10; i++) {
            ans += d[N][i];
        }
        System.out.println(ans % 10007);
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
