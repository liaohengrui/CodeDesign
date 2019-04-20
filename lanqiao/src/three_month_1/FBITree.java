package three_month_1;

import java.util.Scanner;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2019/3/2
 */
public class FBITree {
    static class Tree {
        Tree leftTree;
        Tree rightTree;
        String val;

        public Tree(String val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String s = scanner.nextLine();
        Tree tree = createTree(s);
        houxu(tree);
    }

    private static void houxu(Tree tree) {
        if (tree == null) {
            return;
        }
        houxu(tree.leftTree);
        houxu(tree.rightTree);
        System.out.print(tree.val);
    }

    private static Tree createTree(String s) {
        if (s.length() == 1) {
            return new Tree(judgeVal(s));
        }
        Tree root = new Tree(judgeVal(s));
        String leftStr = s.substring(0, s.length() / 2);
        String rightStr = s.substring(s.length() / 2, s.length());
        Tree leftTree = createTree(leftStr);
        Tree rightTree = createTree(rightStr);
        root.leftTree = leftTree;
        root.rightTree = rightTree;
        return root;

    }

    private static String judgeVal(String s) {
        if (s.contains("0") && s.contains("1")) {
            return "F";
        } else if (s.contains("0")) {
            return "B";
        } else {
            return "I";
        }
    }
}
