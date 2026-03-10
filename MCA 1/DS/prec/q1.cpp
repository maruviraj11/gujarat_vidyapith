#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#define max 5
int q[max]
void main()
{
	int q[max];
	int f,r;
	int val,rmv,ch;
	
	f=(int *)malloc(sizeof(int));
	r=(int *)malloc(sizeof(int));
	
	*f=-1;
	*r=-1;
	
	void qinsert(int *,int *,int val);
	void qdelete(int *,int *);
	void display(int *,int *);
	
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
				qdelete(f,r);
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
}
