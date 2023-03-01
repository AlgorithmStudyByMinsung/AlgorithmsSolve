package twoPointer;
// https://www.acmicpc.net/problem/15565
import java.util.*;
import java.io.*;

public class 귀여운라이언
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int K;
    static int[] a;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();

        a = new int[N + 1];

        for(int i = 1; i <= N; i ++) a[i] = scan.nextInt();

    }
    static void twoPointer() {
        // R = 0 으로 설정
        int R = 0;
        // 1이 몇 번인가
        int cnt = 0;
        int res = Integer.MAX_VALUE;

        for(int L = 1; L <= N; L ++) {
            // R < N 으로 하고
            while(R < N && cnt < K) {
                // 처음에는 항상 R 을 증가
                R ++;

                if(a[R] == 1) cnt ++;
            }
            /**
             * 투 포인터는 길이를 이용하는 문제이다.
             * 그래서 R - L + 1이 어떻게 이용될 지 잘 살펴야 한다.
             * */
            if(cnt >= K) res = Math.min(res , R - L + 1);
            // 빼는 건 마지막에 빼줘도 된다.
            if(a[L] == 1) cnt --;
        }

        if(res == Integer.MAX_VALUE) System.out.println("-1");
        else System.out.println(res);
    }
    public static void main(String args[])
    {
        input();
        twoPointer();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || ! st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            String str = "";

            try {
                str = br.readLine();
            } catch(IOException e) {
                e.printStackTrace();
            }

            return str;
        }
    }
}
