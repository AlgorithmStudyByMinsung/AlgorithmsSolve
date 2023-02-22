package math.소수;
// https://www.acmicpc.net/problem/6588
import java.io.*;
import java.util.StringTokenizer;

public class 골든바흐의추측 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N = -1;
    static int MOD = 1000000;
    static boolean[] check = new boolean[MOD + 1];
    static void input() {
        N = scan.nextInt();
    }
    static void primeCheck() {
        check[0] = check[1] = true;

        for (int i = 2; i * i <= MOD; i++) {
            if (check[i]) continue;

            for (int j = i + i; j <= MOD; j+= i) {
                check[j] = true;
            }
        }
    }

    static void pro(int x) {

        for (int i = 3; i <= x; i++) {
            if (check[i]) continue;
            if (i%2 == 0) continue;

            if (! check[x - i]) {
                sb.append(x).append(" = ").append(i).append(" + ").append(x - i).append('\n');
                break;
            }
        }
    }
    public static void main(String[] args) {
        primeCheck();

        while (N != 0) {
            input();

            pro(N);
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
