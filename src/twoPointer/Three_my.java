package twoPointer;
// https://www.acmicpc.net/problem/13144
/**
 * 투포인터의 원리:
 *      다음 스텝이 이전 스텝의 결과를 가지고 잇어야한다.
 *      그래서 이전 스텝을 하지 않아도 다음 스텝을 할 수 있게 한다.
 *
 * 스켈레톤 코드
 *      int R = 0;
 *      for(L <= N) {
 *          // 자기 이전꺼 제거
 *
 *          while (R <= N) {
 *              자기꺼 부터 시작
 *              안되면 break;
 *              R 을 증가
 *          }
 *          정답을 갱
 *      }
 * */
import java.io.*;
import java.util.StringTokenizer;

public class Three_my {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int[] a;
    /**
     * 특정 값이 있는 지 확인하는 가장 좋은 방법 = 배열을 사용
     * - 시간복잡도 1이다.
     * - 근데 10만 넘어가면 메모리초과가 날 수 있으므로 꼭 계산이 필요
     **/
    static int[] check;

    static void input() {
        N = scan.nextInt();
        a = new int[N +1];
        check = new int[N +1];

        for (int i = 1; i <= N ; i++) {
            a[i] = scan.nextInt();
        }
    }

    static void pro() {
        long sum =0;
        int R = 1; // L 과 R 은 동시 출발

        for (int L = 1; L <= N ; L++) {
            /**
             * 이런식으로 해야한다. check[a[]] <-- 보통 이런 형식
             **/
            check[a[L -1]] = 0;

            /**
             * R이 계속 증가하고 있다. <-- 투포인터 이고 이래서 시간 복잡도가 N 이다.
             **/
            while (R <= N) {
                // R 은 L 대신 움직인다고 보면 된다.
                if (check[a[R]] == 1) break;
                check[a[R]] = 1;

                R++;
            }
            // R 은 항상 1이 증가된 상태로 오기에 +1 을 해줄 필요가 없다.
            sum += (R - L);
        }
        System.out.println(sum);
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
