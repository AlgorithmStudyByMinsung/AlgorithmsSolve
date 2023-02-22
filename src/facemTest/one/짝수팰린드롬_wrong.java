package facemTest.one;
// https://www.acmicpc.net/problem/21925
/**
 * 질문!!
 *
 * - 투포인터 + 그리디로 했는데 틀림
 * - 스텍을 이용한 것인데 나는 스텍을 이용하면 틀림
 * - 반례가 존재
 * */
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 짝수팰린드롬_wrong {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int[] a;
    static ArrayList<Integer> result = new ArrayList<>();

    static void input() {
        N = scan.nextInt();

        a = new int[N + 1];

        for (int i = 1; i <= N; i++) a[i] = scan.nextInt();
    }

    static void twoPointer () {
        int R = 1;
        int res = 0;
        for (int L = 1; L <= N; L++) {
            if (L < R) continue;
            result.add(a[L]);

            while (R < N) {
                R ++;

                if (a[R] != result.get(result.size() - 1)) {
                     result.add(a[R]);

                } else {
                    result.remove(result.size() - 1);
                    if (result.size() == 0) {
                        res ++;
                        R ++;
                        break;
                    }
                }
            }
        }
        if (res == 0) System.out.println("-1");
        else System.out.println(res);
    }

    public static void main(String[] args) {
        input();
        twoPointer();
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
