#include<stdio.h>
#include<stdlib.h>
# define max 3

void main()
{
	int *f,*r;
	int val,choice,rval,mVal,pos;
	int q[max];
	
	void insert(int*,int *,int [],int);
	int removeq(int *,int *,int []);
	int modify(int *,int*,int [],int ,int);
	void display(int *,int *,int []);
	
	f=(int *)malloc(sizeof(int));
	r=(int *)malloc(sizeof(int));
	
	*f=-1;
	*r=-1;
	
	while(1)
	{
		printf("\n1.insert\n2.remove\n3.modify\n4.display\n5.exit\nEnter choice :");
		scanf("%d",&choice);
		
		switch(choice)
		{
			case 1:
				printf("Enter value :");
				scanf("%d",&val);
				insert(f,r,q,val);
				break;
				
			case 2:
				rval=removeq(f,r,q);
				if(rval==-1)
				{
					printf("Queue is empty!!");	
				}
				else{
					printf("Removed value from the queue : %d",rval);	
				}
				break;
				
			case 3:
				printf("Enter position to be modify:");
				scanf("%d",&pos);
	
				printf("Enter New Value:");
				scanf("%d",&mVal);
		
				rval=modify(f,r,q,pos,mVal);
				
				if(rval==-1)
				{
					printf("Invalid position!!");
				}
				else
				{
					printf("Value modified: %d",rval);
				}
				break;
				
			case 4:
				display(f,r,q);
				break;
				
			case 5:
				exit(0);
				
			default:
				printf("Invalid input");
				break;
		}
	}
}
void insert(int *f,int *r,int q[max],int nval)
{
	if(*r==max-1)
	{
		printf("queue is full..");
	}
	else if((*f)==-1 && (*r)==-1)
	{
		*f=*r=0;
		q[*r]=nval;
		printf("value entered in queue :%d\n",q[*r]);
	}
	else
	{
		(*r)=(*r)+1;
		q[*r]=nval;
		printf("Value entered in queue :%d\n",q[*r]);
	}
}
int removeq(int *f,int *r,int q[max])
{
		int temp;
	if(*f==-1 && *r==-1)
	{
		return -1;
	}
	else
	{
		if(*f == *r)
		{
			temp = q[*f];
			(*f)=(*r)=-1;
		}
		else
		{
			temp = q[*f];
			(*f)=(*f)+1;
		}
		return temp;
	}
}
int modify(int* f,int *r,int q[max],int pos,int mVal)
{
	pos-=1;
	if (*f== -1 || pos < 0 || pos > *r - *f) {
        return -1;
    }
    else
    {
    	q[(*f)+pos]=mVal;	
    	return q[(*f)+pos];
	}
}
void display(int *f,int *r,int q[max])
{
	int i;
	if((*f)==-1 && (*r)==-1)
	{
		printf("Queue is empty!!");
	}
	else
	{
		for(i=*f; i<=*r; i++)
		{
			printf("%d  ",q[i]);
		}
	}
}
