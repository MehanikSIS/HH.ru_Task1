import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string1 = in.nextLine();
        int n = Integer.parseInt(string1.split(" ")[0]);
        int m = Integer.parseInt(string1.split(" ")[1]);
        int s = Integer.parseInt(string1.split(" ")[2]);
        int max = Math.max(n, m);

        int[][] matrix = new int[max][2];
        for (int i = 0; i < max; i++) {
            String string2 = in.nextLine();
            try {
                matrix[i][0] = Integer.parseInt(string2.split(" ")[0]);
            } catch (NumberFormatException e) {
                matrix[i][0] = 0;
            }
            try {
                matrix[i][1] = Integer.parseInt(string2.split(" ")[0]);
            } catch (NumberFormatException e) {
                matrix[i][1] = 0;
            }
        }
        int count1 = 0;
        int count2 = 0;
        int result = 0;
        while (result < s) {
            if (matrix[count1][0] < matrix[count2][1]) {
                result = result + matrix[count1][0];
                count1++;
            } else if (matrix[count1][0] > matrix[count2][1]){

            }
        }

    }
}
