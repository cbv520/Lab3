public class Test
{
    public static void main(String args[])
    {
        int[] a = {1,54,6,7,4,3,7,8,4,8,9,6,546,54,654,67,8,3,32,5,6,8,9,4,432,7,6,9,67,4,32,2,8,9,9,23,2,8,89,9,3,2,2,1,78};

        a = Sorts.bubbleSort(a);

        for(int x : a)
        {
            System.out.print(x + " ");
        }
    }
}
