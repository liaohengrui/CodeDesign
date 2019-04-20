package GuoContest9;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/4/18
 */
public class Question2 {
    static int counter = 0;
    static int deep = 0;

    public static void main(String[] args) {
        dfsSearch(true);
        System.out.println(counter);
    }

    private static void dfsSearch(boolean canOpen) {
        if (deep >= 30) {
            counter++;
            return;
        }
        if (canOpen) {
            //开
            deep++;
            dfsSearch(false);
            deep--;
        }
        //关
        deep++;
        dfsSearch(true);
        deep--;
    }
}
