package codingTest.two;
// https://www.acmicpc.net/problem/21275
import java.io.*;
import java.util.StringTokenizer;

public class 폰호석만 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static String a;
    static String b;
    // 2의 63 승이 최대값이므로 long.max 를 사용해야 한다.
    static long MAX = Long.MAX_VALUE;

    static void input() {
        a = scan.next();
        b = scan.next();
    }
    /**
     * 문자열을 숫자로 변경하는 방법이다.
     * */
    static int convert(char x) {
        if (x >= '0' && x <= '9') return x - '0';
        else return x - 'a' + 10;
    }
    /**
     * 진법 변환 함수 공식
     * res * 진수 + 자리의 숫자
     * */
    static int cal(String str, int base) {
        int res = 0;
        for (char c : str.toCharArray()) {
            if (convert(c) >= base) return -1;
            /**
             * 숫자가 너무 커서 이항을 해야 계산이 된다.
             * */
            /**
             * int 형일 때는 -1 로 아니다라는 것을 표현한다.
             * */
            if (res >= (MAX - convert(c) / base)) return -1;
            res = res * base + convert(c);
        }
        return res;
    }
    static void pro() {
        int ans = -1; int A = 0; int B = 0; int cnt = 0;

        for (int i = 2; i <= 36; i++) {

            int calA = cal(a, i);
            if (calA == -1) continue;

            for (int j = 2; j <= 36; j++) {
                if (i == j) continue;
                int calB = cal(b, j);
                if (calB == -1) continue;
                if (calA != calB) continue;

                if (ans == -1) {
                    ans = calA;
                    A = i;
                    B = j;
                } else {
                    System.out.println("Multiple");
                    /**
                     * close 를 사용하면 더 이상의 출력이 되지 않는다.
                     * */
                    System.out.close();
                }
            }
        }
        if (ans == -1) {
            System.out.println("Impossible");
        } else {
            sb.append(ans).append(' ').append(A).append(' ').append(B);
            System.out.println(sb);
        }


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
