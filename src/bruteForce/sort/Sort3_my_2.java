package bruteForce.sort;
// https://www.acmicpc.net/problem/11652
import java.io.*;
import java.util.*;

public class Sort3_my_2 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static Long[] numbers;
    static Map<Long, Integer> ans = new HashMap<>();

    static void input() {
        N = scan.nextInt();
        numbers = new Long[N];

        for (int i = 0; i < N; i++) numbers[i] = scan.nextLong();
    }
    static Long sorting() {
        for (Long number : numbers) {
            ans.put(number, ans.get(number) == null ? 1 : ans.get(number) + 1);
        }

        ArrayList<Long> keySet = new ArrayList<>(ans.keySet());

        keySet.sort(new Comparator<Long>() {
            /**
             * long 타입을 comparator 하기
             * 그리고 맞왜틀 일 시에는 음수도 확인하자
             * */
            @Override
            public int compare(Long o1, Long o2) {

                if (ans.get(o2) != ans.get(o1)) {
                    return ans.get(o2)- ans.get(o1);
                }
                return Long.compare(o1, o2);
            }
        });
        for (Map.Entry<Long, Integer> longIntegerEntry : ans.entrySet()) {
            System.out.println("longIntegerEntry.getKey() = " + longIntegerEntry.getKey());
            System.out.println("longIntegerEntry.getValue() = " + longIntegerEntry.getValue());
        }
        for (Long aLong : keySet) {
            System.out.println("aLong = " + aLong);
        }

        return keySet.get(0);
    }
    public static void main(String[] args) {
        input();

        Long sorting = sorting();
        System.out.println(sorting);

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
