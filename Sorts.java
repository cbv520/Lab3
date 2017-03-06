/**
** Software Technology 152
** Class to hold various static sort methods.
*/
class Sorts
{
    // bubble sort
    public static void bubbleSort(int[] A)
    {
    }//bubbleSort()

    // selection sort
    public static void selectionSort(int[] A)
    {
        int minIdx;
        for(int i = 0; i < A.length - 1; i++)
        {
            minIdx = i;
            for(int j = i + 1; j < A.length; j++)
            {
                if(A[j] < A[minIdx])
                {
                    minIdx = j;
                }
            }

            int temp = A[minIdx];
            A[minIdx] = A[i];
            A[i] = temp; 
        }
    }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A)
    {
        int i;
        for(int n = 1; n < A.length; n++)
        {
            i = n;
            int temp = A[i];
            while((i > 0) && (A[i - 1] > temp))
            {
                A[i] = A[i - 1];
                i--;
            } 
            A[i] = temp;  
        }
    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
    }//mergeSort()
    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//mergeSortRecurse()
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
		return 0;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning


}//end Sorts calss
