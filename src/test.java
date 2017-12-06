import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        SudokuGenerator.generate();

        int[] shit = new int[5];
        shit[0] = 1;
        shit[1] = 2;

        ArrayList<Integer> shittier = new ArrayList<Integer>();
        shittier.add(shit[0]);
        shittier.add(shit[1]);

        System.out.println(shittier.get(0));
        System.out.println(shit[0]);
        shit[0]++;
        System.out.println(shit[0]);

        System.out.println(shittier.get(0));
        System.out.println(shittier.get(1));
    }
}
