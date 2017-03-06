import java.util.*;

public class Test
{
    public static void main(String args[])
    {
        int[] a = new int[300];
        int[] z;
        Random r = new Random();

        for(int i = 0; i < 300; i++)
        {
            a[i] = r.nextInt(99) + 1;
        }

        //z = Sorts.bubbleSort(a);
        z = Arrays.copyOf(a, 300);
        Sorts.bubbleSort(z);

        for(int i = 0; i < 300; i++)
        {
            System.out.printf("%-2d    %-2d\n", a[i], z[i]);
        }
    }
}
