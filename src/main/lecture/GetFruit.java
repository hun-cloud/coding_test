package main.lecture;

public class GetFruit {
    public static void main(String[] args) {

    }

    public static int getMin(int[] nums) {
        int result = 50;
        for (int num : nums) {
            result = Math.min(result, num);
        }
        return result;
    }
    public static boolean isMinUnique(int[] fruit) {
        int cnt = 0;
        int min = getMin(fruit);
        for (int x : fruit) {
            if (x == min) cnt++;
        }
        return cnt == 1;
    }
    public static int getMinIndex(int[] fruit) {
        int min = getMin(fruit);
        for (int i = 0; i < fruit.length; i++) {
            if (fruit[i] == min) {
                return i;
            }
        }
        return 0;
    }

    public static int solution(int[][] fruit) {
        int answer = 0;
        int n = fruit.length;
        int[] ch = new int[n];
        for (int i = 0; i < n; i++) {
            if (ch[i] == 1) continue;
            if (!isMinUnique(fruit[i])) continue;
            for (int j = i+1; j < n; j++) {
                int a = getMinIndex(fruit[i]);
                int b = getMinIndex(fruit[j]);
                if (a != b && fruit[i][b] > 0 && fruit[j][a] > 0) {
                    if (fruit[i][a] + 1 <= fruit[i][b] - 1 && fruit[j][b] + 1 <= fruit[j][a] - 1) {
                        fruit[i][a]++;
                        fruit[i][b]--;
                        fruit[j][b]++;
                        fruit[j][a]--;
                        ch[i] = 1;
                        ch[j] = 1;
                        break;
                    }
                }
            }
        }
        for (int[] x : fruit) {
            answer += getMin(x);
        }

        return answer;
    }
}
