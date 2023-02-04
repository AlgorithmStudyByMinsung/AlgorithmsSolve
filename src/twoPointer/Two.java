package twoPointer;
// https://www.acmicpc.net/problem/2470
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * twoPointer 유형 2번 기본 : 근사치를 찾는다, 두개의 합, 두개의 치이 등등
 *
 * - 원리:
 * 1. 정렬
 * 2. 가장 작은거랑 가장 큰거랑 더했는데도 목표 값보다 작다면 가장 작은 값을 증가
 * 반대라면 큰 값을 줄임
 *
 * - 스켈레톤
 *      Arrays.sort
 *
 *      while(L < R){
 *          if (작다면) L +=1
 *          else if(크다면) R +=1
 *          같다면 종료
 *      }
 * */
public class Two {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int[] a;

    static void input() {
        N = scan.nextInt();
        a = new int[N +1];

        for (int i = 1; i <=N ; i++) {
            a[i] = scan.nextInt();
        }
    }
    static void pro() {
        Arrays.sort(a, 1, N+1);

        int L =1, R= a.length -1;

        int l =L, r =R;
        int min =Integer.MAX_VALUE;

        while (L < R) {

            int sum = a[L] + a[R];

            if (sum > 0) {
                if (min > Math.abs(sum)) {
                    r = R; l = L; min = Math.abs(sum);
                }

                R -=1;
            } else if (sum ==0) {
                r = R; l = L;
                break;
            } else {
                if (min > Math.abs(sum)) {
                    r = R; l = L; min = Math.abs(sum);
                }

                L += 1;
            }
        }
            sb.append(a[l]).append(' ').append(a[r]);
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
