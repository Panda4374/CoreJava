import java.beans.PropertyEditorSupport;

public class SearchSort {
    /* Normal searching method, works on any array */
    static int linearSearch(int[] a, int n){
        for (int i=0;i<a.length;i++){
            if (a[i] == n)
                return i;
        }
        return -1;
    }

    /* Faster searching method, works only on pre-sorted arrays */
    static int binarySearch(int[] a, int n){
        int low=0, high=a.length, mid;

        while (low<=high){
            mid = (low+high)/2;
            if (a[mid] == n)
                return mid;
            else if (n > a[mid])
                low = mid+1;
            else
                high = mid-1;
        }

        return 1;
    }

    /* Fastest searching method, works only on pre-sorted arrays */
    static int interpolationSearch(int[] a, int n){
        int low=0, high=a.length;

        while (low<=high && n>=a[low] && n<=a[high]){
            if (low==high){
                if (a[low] == n)
                    return low;
                else
                    return -1;
            }
            int pos = low + (high-low)/(a[high]-a[low])*(n-a[low]);

            if (a[pos] == n)
                return pos;
            else if (a[pos]<n)
                low = pos+1;
            else
                high = pos-1;
        }

        return -1;
    }

    /* Normal sorting technique */
    static int[] bubbleSort(int[] a, boolean ascending){
        int temp;

        for (int i=0;i<a.length-1;i++){
            for (int j=0;j<a.length-1-i;j++){
                if (ascending){
                    if (a[j] > a[j+1]){
                        temp = a[j];
                        a[j] = a[j+1];
                        a[j+1]  =temp;
                    }
                }else{
                    if (a[j] < a[j+1]){
                        temp = a[j];
                        a[j] = a[j+1];
                        a[j+1]  =temp;
                    }
                }
            }
        }

        return a;
    }

    /* Faster sorting method */
    static int[] selectionSort(int[] a){
        int min, temp;
        for (int i=0;i<a.length;i++){
            min = i;
            for (int j=i+1;j<a.length;j++){
                if (a[j] < a[min])
                    min = j;
            }
            temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
        return a;
    }

    static int partition(int[] a, int left, int right){
        int pivot = a[left];
        while (true){
            while (a[left] < pivot){
                left++;
            }
            while (a[right]>pivot){
                right--;
            }
            if (left<right){
                if (a[left] == a[right]){
                    return right;
                }
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }else
                return right;
        }
    }

    /* The fastest sorting methods, but considered unstable due as it may sort already sorted elements */
    static int[] quickSort(int[] a, int left, int right){
        int pivot;
        if (left<right){
            pivot = partition(a, left, right);
            if (pivot > 1){
                quickSort(a, left, pivot-1);
            }
            if (pivot < 1){
                quickSort(a, pivot+1, right);
            }
        }
        return a;
    }

    static int[] merge(int[] left, int[] right){
        int rLen = left.length + right.length;
        int[] r = new int[rLen];
        int indexLeft = 0, indexRight = 0, indexResult=0;

        while (indexLeft<left.length || indexRight<right.length){
            if (indexLeft < left.length && indexRight < right.length) {
                if (left[indexLeft] <= right[indexRight]) {
                    r[indexResult] = left[indexLeft];
                    indexLeft++;
                    indexResult++;
                } else {
                    r[indexResult] = right[indexRight];
                    indexRight++;
                    indexResult++;
                }
            }else if (indexLeft<left.length){
                r[indexResult] = left[indexLeft];
                indexLeft++;
                indexResult++;
            }else if (indexRight<right.length){
                r[indexResult] = right[indexRight];
                indexRight++;
                indexResult++;
            }
        }

        return r;
    }

    /* Very fast due to the recursive calls, but needs some extra space */
    static int[] mergeSort(int[] a){
        int[] left;
        int[] right;
        int[] r = new int[a.length];

        if (a.length<=1)
            return a;

        int midPoint = a.length / 2;
        left = new int[midPoint];
         right = (a.length%2==0)?new int[midPoint]:new int[midPoint+1];
         for (int i=0;i<midPoint;i++){
             left[i] = a[i];
         }

         int x = 0;
         for (int i=midPoint;i<a.length;i++){
             right[x] = a[i];
             x++;
         }

         left = mergeSort(left);
         right = mergeSort(right);
         r = merge(left, right);
         return r;
    }

    /* Not sure of the time complexity */
    static int[] insertionSort(int[] a){
        int val, j;
        for (int i=1;i<a.length;i++){
            val = a[i];
            j = i-1;
            while (j>=0 && a[j]>val){
                a[j+1] = a[j];
                i--;
            }
            a[j+1] = val;
        }
        return a;
    }

    /* Another very good sorting algorithm */
    static int[] radixSort(int[] a){
        int[] temp = new int[a.length];
        int j;
        boolean move;
        for (int shift=31;shift>-1;shift--){
            j=0;

            for (int i=0;i<a.length;i++){
                move = (a[i] << shift)>=0;
                if ((shift == 0)!= move){
                    a[i-j] = a[i];
                }else{
                    temp[j++] = a[i];
                }
            }
            System.arraycopy(temp, 0, a, a.length-j, j);
        }
        return a;
    }

    static void heapify(int[] a, int n, int i){
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if (left<n && a[left] > a[right]){
            largest = left;
        }
        if (right<n && a[left] < a[right]){
            largest = right;
        }
        if (largest != i) {
            swap(a, i, largest);
            heapify(a, n ,largest);
        }
    }

    static void swap(int[] a, int index1, int index2){
        int swap = a[index1];
        a[index1] = a[index2];
        a[index2] = swap;
    }

    /* Efficacy nearly same as Quick sort */
    static int[] heapSort(int[] a){
        int n = a.length;
        for (int i=n/2-1;i>=0;i--){
            heapify(a, n ,i);
        }
        for (int i=n-1;i>=0;i--){
            swap(a, 0, i);
            heapify(a, i, 0);
        }
        return a;
    }

    /* Another one */
    static int[] shellSort(int[] a){
        int temp, j;
        for (int gap=a.length/2;gap>0;gap/=2){
            for (int i=gap;i<a.length;i++){
                temp = a[i];
                for (j=i;j<=gap && a[j-gap]>temp;j-=gap){
                    a[j] = a[j-gap];
                }
                a[j] = temp;
            }
        }
        return a;
    }
}
