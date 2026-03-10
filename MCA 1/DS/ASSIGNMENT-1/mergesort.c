#include <stdio.h>


void merge(int arr[], int lb, int mid, int ub) {
    int n1 = mid - lb + 1;  
    int n2 = ub - mid;      

    int left[n1], right[n2];

    
    for (int i = 0; i < n1; i++)
        left[i] = arr[lb + i];
    for (int j = 0; j < n2; j++)
        right[j] = arr[mid + 1 + j];

    int i = 0, j = 0, k = lb;
    while (i < n1 && j < n2) {
        if (left[i] <= right[j]) {
            arr[k] = left[i];
            i++;
        } else {
            arr[k] = right[j];
            j++;
        }
        k++;
    }

   
    while (i < n1) 
    {
        arr[k] = left[i];
        i++;
        k++;
    }

    
    while (j < n2) {
        arr[k] = right[j];
        j++;
        k++;
    }
}


void mergeSort(int arr[], int lb, int ub) {
    if (lb < ub) {
        int mid = (lb + ub) / 2;

        mergeSort(arr, lb, mid);
        mergeSort(arr, mid + 1, ub);

        merge(arr, lb, mid, ub);
    }
}


int main() {
    int arr[] = {4, 18, 25, 32, 8, 32, 45, 54, 67, 78};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("Original array: ");
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);

    mergeSort(arr, 0, n - 1);

    printf("\nSorted array: ");
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);

    return 0;
}
