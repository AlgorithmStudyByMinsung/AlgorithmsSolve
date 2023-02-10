package dp.유형1_배열_1개.기본;
// https://www.acmicpc.net/problem/2011
import java.io.*;
import java.util.StringTokenizer;
/**
 * dp 는 쉬운데 안되는 조건이 많아서 맞왜틀 유발!!
 * */
public class 암호코드 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static String a;
    static int[] d;

    static void input() {
        a = scan.nextLine();
        d = new int[a.length() +1];
    }

    static void pro() {
        if (a.charAt(0) <= 48) {
            System.out.println(0);
            return;
        }
        d[0] = 1;
        d[1] = 1;

        for (int i = 2; i <= a.length() ; i++) {
            if (a.charAt(i -1) != 48) {
                d[i] += d[i -1];
            }

            if (Integer.parseInt(a.substring(i - 2 ,i)) <= 26 && Integer.parseInt(a.substring(i - 2 ,i)) >= 10) {
                d[i] += d[i -2];
            }
            if (d[i] == 0) {
                System.out.println(0);
                return;
            }
            d[i] %= 1000000;
        }

        System.out.println(d[a.length()]);
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
