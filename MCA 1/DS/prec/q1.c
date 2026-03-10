#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#define max 5
int q[max];
void main()
{
	
	int *f,*r;
	int val,rmv,ch;
	
	void qinsert(int *,int *,int val);
	int  qdelete(int *,int *);
	void display(int *,int *);
	
	f=(int *)malloc(sizeof(int));
	r=(int *)malloc(sizeof(int));
	
	*f=-1;
	*r=-1;
	
	
	printf("1.insert\n");
	printf("2.delete\n");
	printf("3.display\n");
	printf("4.exit\n");
	
	while(1)
	{
		printf("ENTER YOUR CHOICE..");
		scanf("%d",&ch);
		
		switch(ch)
		{
			case 1:
				printf("ENTER A VALUE");
				scanf("%d",&val);
				qinsert(f,r,val);
				break;
			case 2:
				rmv=qdelete(f,r);
				printf("remove is :%d",rmv);
				break;
			case 3:
				display(f,r);
				break;
			case 4:
				exit(0);
				break;
			deafult:
				printf("INVALID CHOICE..\n");
				break;
	
				
		}
	}
}
void qinsert(int *f,int *r,int val)
{
	if(*f==-1 && *r==-1)
	{
		*f=*r=0;
		q[*r]=val;
	}
	else
	{
		if(*r>=max-1)
		{
			printf("QUEUE IS FULL..");	
		}
		else
		{
			*r=*r+1;
			q[*r]=val;
		}
	}
}
int qdelete(int *f,int *r)
{
	int rmv;
	if(*f==-1 && *r==-1)
	{
		printf("queue is empty\n");
		
	}
	else
	{
		if(*f==*r)
		{
			rmv=q[*f];
			*f=*r=-1;
		}
		else
		{
			rmv=q[*f];
			*f=*f+1;
		}
		
	}
	return rmv;
}
void display(int *f,int *r)
{
	int i;
	if(*f==*r)
	{
		printf("queue is empty..\n");
		
	}
	else
	{
		for(i=*f;i<=*r;i++)
		{
			printf("%d\n",q[i]);
		}
	}
	
}
