package twoPointer.skeletonCode;
/**
 * 키워드: 연속된 부분수열, 순서를 지키며
 **/
public class 유형1 {
    /**
     * 1. 변수 R 을 생성 (L 과 R 은 동시 출발)
     * 2. for L 을 순회
     * 3. L -1 을 제거
     * 4. while (R < N) 을 순회
     * 5. 조건이 안맞으면 break;
     * 6. 로직
     * 7. R ++
     * 8. and = R - L (R이 1이 증가된 상태이므로)
     * */
    static int N;
    static int[] a = new int[N +1];

    static void twoPointer() {
        int R = 1; int ans = 0;

        for (int L = 1; L <= N; L++) {

            // L -1 번 꺼를 제거

            while (R <= N) {
                // 조건에 안 맞으면 break;
                // 로직
                R ++;
            }

            ans = R - L;
        }
    }
    public static void main(String[] args) {

    }
}
