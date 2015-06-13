import java.awt.*;

public class Main {
    static int n=6;
    static int s=0;
    static int d=5;
    static int[][]f = new int[n][n];
    static int[][]c = new int[n][n];

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI ex = new GUI();
                ex.setVisible(true);
            }
        });
    }
}
