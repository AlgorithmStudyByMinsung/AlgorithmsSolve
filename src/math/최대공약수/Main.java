package math.최대공약수;
/**
 * 유클리드 호제법을 이용하였다.
 * */
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int M;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;

        else return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return gcd(a, b) * (a / gcd(a, b)) * (b / gcd(a, b));
    }


    public static void main(String[] args) {
        input();
        System.out.println(gcd(N , M));
        System.out.println(lcm(N , M));
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
