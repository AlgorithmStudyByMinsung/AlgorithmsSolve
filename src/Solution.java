import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;


    static void input() {
        N = scan.nextInt();
    }
    static void pro() {
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append('\n');
        }
    }
    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
        Math.abs()

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