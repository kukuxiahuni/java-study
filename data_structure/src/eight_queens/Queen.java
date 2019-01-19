package eight_queens;

public class Queen {
    // 同栏是否有皇后，1表示无，可以占用
    private int[] column;
    // 右上至左下是否有皇后,i+j之和相等
    private int[] rup;
    // 左上至右下是否有皇后，|i-j|相等
    private int[] lup;
    // 解答
    private int[] queen;

    // 解答编号
    private int num;

    public Queen() {
        column = new int[4 + 1];
        rup = new int[2 * 4 + 1];
        lup = new int[2 * 4 + 1];

        for (int i = 1; i <= 4; i++)
            column[i] = 1;

        for (int i = 1; i <= 2 * 4; i++)
            rup[i] = lup[i] = 1;

        queen = new int[4 + 1];
    }

    public void backtrack(int i) {
        if (i > 4) {
            showAnswer();
        } else {
            for (int j = 1; j <= 4; j++) {
                if (column[j] == 1 &&
                        rup[i + j] == 1 &&
                        lup[i - j + 4] == 1) {
                    queen[i] = j;
                    // 设定为占用
                    column[j] = rup[i + j] = lup[i - j + 4] = 0;
                    backtrack(i + 1);
                    //放弃占用
                    column[j] = rup[i + j] = lup[i - j + 4] = 1;
                }
            }
        }
    }

    protected void showAnswer() {
        num++;
        System.out.println("\n解答 " + num);
        for (int y = 1; y <= 4; y++) {
            for (int x = 1; x <= 4; x++) {
                if (queen[y] == x) {
                    System.out.print(" Q");
                } else {
                    System.out.print(" .");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.backtrack(1);
    }
}