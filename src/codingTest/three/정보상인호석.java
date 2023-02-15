package codingTest.three;
/**
 * 우선순위 큐의 탐색은 1
 *
 * */
import java.io.*;
import java.util.*;

public class 정보상인호석 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int Q;
    static long ans;
    static HashMap<String , PriorityQueue<Integer>> convert = new HashMap<>();

    static void input() {
        Q = scan.nextInt();
    }

    static void save (String name, int k) {
        /**
         * Collections.reverseOrder()
         * */
        if (convert.get(name) == null) convert.put(name, new PriorityQueue<>(Collections.reverseOrder()));

        PriorityQueue<Integer> queue = convert.get(name);

        for (int i = 0; i < k; i++) {
            queue.add(scan.nextInt());
        }
    }

    static void sell (String name, int cnt) {
        PriorityQueue<Integer> queue = convert.get(name);
        if (queue == null) return;

        if (cnt >= queue.size()) {
            while (! queue.isEmpty()) {
                ans += queue.poll();
            }
        } else {
            for (int i = 0; i < cnt; i++) {
                ans += queue.poll();
            }
        }
    }
    static void pro() {
        int type = scan.nextInt();
        /**
         * switch - case 로 input 을 받으면 에러
         * */
        if (type == 1) {
            save(scan.next(), scan.nextInt());
        } else {
            sell(scan.next(), scan.nextInt());
        }
    }


    public static void main(String[] args) {
        input();
        for (int i = 0; i < Q; i++) {
            pro();
        }
        System.out.println(ans);
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
