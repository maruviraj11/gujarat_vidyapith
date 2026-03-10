#include <stdio.h>
#define max 6

void merge(int arr[max], int st, int mid, int end) {
    int temp[max];
    int i = st, j = mid + 1, t = st,idx;

    while (i <= mid && j <= end) {
        if (arr[i] < arr[j]) {
            temp[t++] = arr[i++];
        } else {
            temp[t++] = arr[j++];
        }
    }
    while (i <= mid) {
        temp[t++] = arr[i++];
    }
    while (j <= end) {
        temp[t++] = arr[j++];
    }

    for (idx = st; idx <= end; idx++) {
        arr[idx] = temp[idx];
    }
}

void mergesort(int arr[max], int st, int end) {
    int mid = st + (end - st) / 2;
	if (st < end) {   
        mergesort(arr, st, mid);
        mergesort(arr, mid + 1, end);
        merge(arr, st, mid, end);
    }
}

void main() {
    int arr[max];
    int i;

	printf("Enter elements in array:");
	for(i=0;i<max;i++){
		scanf("%d",&arr[i]);
	}
	
	printf("\n----After Merge Sort----\n");
	
    mergesort(arr, 0, max - 1);

    for (i = 0; i < max; i++) {
        printf("%d ", arr[i]);
    }
}

