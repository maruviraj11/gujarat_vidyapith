#include<stdio.h>
#define max 5
void merge(int arr[max],int st,int mid,int end)
{
	int i=st, t=st, j=end, idx, temp[max];
	while(i <= mid && j <= end)
	{
		if(arr[i] < arr[j])
		{
			temp[t++] = arr[i++];
		}
		else
		{
			temp[t++] = arr[j++];
		}
	}
	while(i <= mid)
	{
		temp[t++] = arr[i++];
	}
	while(j <= end)
	{
		temp[t++] = arr[j++];
	}
	for(idx = st; idx <= end; idx++)
	{
		arr[idx] = temp[idx];
	}
}
void mergesort(int arr[max],int st,int end)
{
	int mid = st + (end - st)/2;
	if(st < end) {
		mergesort(arr, st, mid);
		mergesort(arr, mid+1, end);
		merge(arr,st,mid,end);
	}	
}
void main()
{
	int i,arr[max];
	
	printf("Enter elements:");
	for(i=0; i<max-1; i++)
	{
		scanf("%d ", &arr[i]);
	}
	
	mergesort(arr,0,max-1);
	
	printf("Enter elements:");
	for(i=0; i<max-1; i++)
	{
		printf("%d",arr[i]);
	}
}
