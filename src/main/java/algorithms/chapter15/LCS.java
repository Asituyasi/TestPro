package algorithms.chapter15;

/**
 * Created by tiantian on 2019/3/17
 * 动态规划-计算字符串最长公共子序列
 * 注意：与最大子数组不同，最长公共子序列不要求元素连续
 */
public class LCS {
    
    // c表示x[i] 和 y[j]的lcs长度
    private static int[][] c =  new int[8][7];
    private static String[][] b = new String[8][7];
    
    public static void lcsLength(String[] x, String[] y) {
        for (int i = 1; i < x.length; i++) {
            for (int j = 1; j < y.length; j++) {
                if (x[i].equals(y[j])) {
                    c[i][j] = c[i-1][j-1] + 1;
                    b[i][j] = "\\";
                } else if (c[i-1][j] >= c[i][j-1]) {
                    c[i][j] = c[i-1][j];
                    b[i][j] = "|";
                } else {
                    c[i][j] = c[i][j-1];
                    b[i][j] = "<-";
                } 
                
            }
        }
    }

    public static void main(String[] args) {
        String[] x = "#ABCBDAB".split("");
        String[] y = "&BDCABA".split("");

        System.out.println("x:");
        for (int i = 0; i < x.length; i++) {
            System.out.printf(x[i] + " ");
        }
        System.out.println("\ny:");
        for (int i = 0; i < y.length; i++) {
            System.out.print(y[i] + " ");
        }
        System.out.println("\n");
        lcsLength(x, y);

        for (int i = 0; i < y.length; i++) {
            System.out.printf(y[i] + " ");
        }
        System.out.println("\n");
        for (int i = 1; i < b.length; i++) {
            System.out.print(x[i] + " ");
            for (int j = 1; j < b[i].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
}
