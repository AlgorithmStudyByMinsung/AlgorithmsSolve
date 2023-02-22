package math.소수;
// https://www.acmicpc.net/problem/1929
import java.io.*;
import java.util.StringTokenizer;
/**
 * 유형 2: 특정 값 이하에서 소수를 전부 구하기
 * */
public class 모든소수찾기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int M;
    static boolean[] check; // 소수인지 아닌지를 확인하는 배열

    static void input() {
        M = scan.nextInt();
        N = scan.nextInt();

        check = new boolean[N + 1];
    }

    static void primeCheck() {
        check[0] = check[1] = true; // 0과 1은 소수가 아니므로 true

        /**
         * i * i <= N
         * 이유는 i 까지 왔다는 것은 i 이전 수의 배수들은 모두 지워졌다.
         * 예를 들어 i 의 2배수 3배수 4배수... 모두 확인을 하였다
         * 그래서 i * i 가 N 보다 크다면 더 이상 진행을 할 필요가 없다.
         * */
        for (int i = 2; i * i <= N; i++) {// 2로 시작해서 2는 무조건 소수임!
            if (check[i]) continue; // 소수가 아닌것들은 pass

            /**
             * 여기도 이런식으로 진행
             * */
            for (int j = i + i; j <= N; j += i) {
                check[j] = true;
            }
        }
    }

    static void pro() {
        primeCheck();

        for (int i = M; i <= N; i++) {
            if (check[i]) continue;

            sb.append(i).append('\n');
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
