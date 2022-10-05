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
        for (int i = 0; i < matrix.length; i++) {
            String string2 = in.nextLine();
            try {
                matrix[i][0] = Integer.parseInt(string2.split(" ")[0]);
            } catch (NumberFormatException e) {
                matrix[i][0] = 0;
            }
            try {
                matrix[i][1] = Integer.parseInt(string2.split(" ")[1]);
            } catch (NumberFormatException e) {
                matrix[i][1] = 0;
            }
        }
        int count1 = 0;                             // порядковый номер резюме в первой стопке
        int count2 = 0;                             // порядковый номер резюме во второй стопке
        int result = 0;                             // сумма зарплат из открытых резюме
        int countResult1 = 0;                              // количество открытых резюме
        while (result < s) {                            // первый вариант: берем всегда с меньшей зарплатой
            if (count1 < matrix.length && count2 < matrix.length) {
                if ((matrix[count1][0] < matrix[count2][1])) {
                    if (matrix[count1][0] == 0) {
                        if (result + matrix[count2][1] > s) break;
                        result = result + matrix[count2][1];
                        count2++;
                        countResult1++;
                    } else {
                        if (result + matrix[count1][0] > s) break;
                        result = result + matrix[count1][0];
                        count1++;
                        countResult1++;
                    }
                } else {
                    if (matrix[count2][1] != 0) {
                        if (result + matrix[count2][1] > s) break;
                        result = result + matrix[count2][1];
                        count2++;
                        countResult1++;
                    } else {
                        if (result + matrix[count1][0] > s) break;
                        result = result + matrix[count1][0];
                        count1++;
                        countResult1++;
                    }
                }
            } else if (count1 < matrix.length) {
                if (matrix[count1][0] != 0) {
                    if (result + matrix[count1][0] > s) break;
                    result = result + matrix[count1][0];
                    count1++;
                    countResult1++;
                }
            } else if (count2 < matrix.length) {
                if (matrix[count2][1] != 0) {
                    if (result + matrix[count2][1] > s) break;
                    result = result + matrix[count2][1];
                    count2++;
                    countResult1++;
                }
            } else break;
        }

        count1 = 0;                             // порядковый номер резюме в первой стопке
        count2 = 0;                             // порядковый номер резюме во второй стопке
        result = 0;                             // сумма зарплат из открытых резюме
        int countResult2 = 0;                   // количество открытых резюме
        while (result < s) {                    //второй вариант: берем всегда с первой стопки, после со второй
            if (count1 < matrix.length) {
                if (matrix[count1][0] != 0) {
                    if (result + matrix[count1][0] > s) break;
                    result = result + matrix[count1][0];
                    count1++;
                    countResult2++;
                } else if (count2 < matrix.length) {
                    if (matrix[count2][1] != 0) {
                        if (result + matrix[count2][1] > s) break;
                        result = result + matrix[count2][1];
                        count2++;
                        countResult2++;
                    } else {
                        break;
                    }
                } else break;
            } else if (count2 < matrix.length) {
                if (matrix[count2][1] != 0) {
                    if (result + matrix[count2][1] > s) break;
                    result = result + matrix[count2][1];
                    count2++;
                    countResult2++;
                }
            } else break;
        }

        count1 = 0;                             // порядковый номер резюме в первой стопке
        count2 = 0;                             // порядковый номер резюме во второй стопке
        result = 0;                             // сумма зарплат из открытых резюме
        int countResult3 = 0;                   // количество открытых резюме
        while (result < s) {                  //третий вариант: берем всегда со второй стопки, затем с первой
            if (count2 < matrix.length) {
                if (matrix[count2][1] != 0) {
                    if (result + matrix[count2][1] > s) break;
                    result = result + matrix[count2][1];
                    count2++;
                    countResult3++;
                } else if (count1 < matrix.length) {
                    if (matrix[count1][0] != 0) {
                        if (result + matrix[count1][0] > s) break;
                        result = result + matrix[count1][0];
                        count1++;
                        countResult3++;
                    } else {
                        break;
                    }
                } else break;
            } else if (count1 < matrix.length) {
                if (matrix[count1][0] != 0) {
                    if (result + matrix[count1][0] > s) break;
                    result = result + matrix[count1][0];
                    count1++;
                    countResult3++;
                }
            }else break;
        }
        System.out.println(Math.max(countResult1, Math.max(countResult2, countResult3)));

    }
}
