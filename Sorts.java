/**
** Software Technology 152
** Class to hold various static sort methods.
*/
class Sorts
{
    // bubble sort
    public static void bubbleSort(int[] A)
    {
        boolean passed;
        do
        {
            passed = true;
            for(int i = 0; i < A.length - 1; i++)
            {
                if(A[i] > A[i + 1])
                {
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                    passed = false;
                }
            }
        }
        while(!passed);
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
        mergeSortRecurse(A, 0, A.length - 1);
    }//mergeSort()
    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
        if(leftIdx < rightIdx)
        {
            int midIdx = (leftIdx + rightIdx)/2;
            mergeSortRecurse(A, leftIdx, midIdx);
            mergeSortRecurse(A, midIdx + 1, rightIdx);
            merge(A, leftIdx, midIdx, rightIdx);
        }
    }//mergeSortRecurse()
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
        int[] temp = new int[rightIdx - leftIdx + 1];
        int i = leftIdx;
        int j = midIdx + 1;
        int k = 0;

        while((i <= midIdx) && j <= rightIdx)
        {
            if(A[i] <= A[j])
            {
                temp[k] = A[i];
                i++;
            }
            else
            {
                temp[k] = A[j];
                j++;
            }
            k++;
        }

        for(i = i; i <= midIdx; i++)
        {
            temp[k] = A[i];
            k++;
        }
        for(j = j; j <= rightIdx; j++)
        {
            temp[k] = A[j];
            k++;
        }
        for(int n = leftIdx; n <= rightIdx; n++)
        {
            A[n] = temp[n - leftIdx];
        }

    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
        quickSortRecurse(A, 0, A.length - 1);
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
        if(rightIdx > leftIdx)
        {
            int pivotIdx = (rightIdx + leftIdx) /2;
            int newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);

            quickSortRecurse(A, leftIdx, newPivotIdx - 1);
            quickSortRecurse(A, newPivotIdx + 1, rightIdx);
        }
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
		int pivotVal = A[pivotIdx];
        A[pivotIdx] = A[rightIdx];
        A[rightIdx] = pivotVal;

        int currentIdx = leftIdx;
        for(int i = leftIdx; i < rightIdx; i++)
        {
            if(A[i] < pivotVal)
            {
                int temp = A[i];
                A[i] = A[currentIdx];
                A[currentIdx] = temp;
                currentIdx++;
            }
        }
        int newPivotIdx = currentIdx;
        A[rightIdx] = A[newPivotIdx];
        A[newPivotIdx] = pivotVal;

        return newPivotIdx;
    }//doPartitioning


}//end Sorts calss
