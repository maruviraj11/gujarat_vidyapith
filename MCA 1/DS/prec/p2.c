#include<stdio.h>
#include<conio.h>
#define size 5
void main()
{
	int s[size];
	int top=-1;
	int val,ch;
	
	void push(int s[],int *top,int val);
	void pop(int s[],int *top);
	void peep(int s[],int *top);
	void display(int s[],int *top);
	
	printf("\nstack operation");
	printf("\n1.pop\n2.pop\n3.peep\n4.display");
	printf("enter a valid choice");
	scanf("%d",&ch);
	
	switch(ch)
	{
		case 1:
			push(s,&top,val);
			break;
		case 2:
			pop(s,&top);
			break;
		case 3:
			peep(s,&top);
			break;
		case 4:
			display(s,&top);
			break;
		default:
			printf("\n invalid choice...");
			break;
			
	}
}
void push(int s[],int *top,int val)
{
	printf("enter a push the element..\n");
	scannf("%d",&val);
	if(*top>=size-1)
	{
		printf("stack is overflow..\n");
	}
	else
	{
		*top=*top+1;
		s[*top]=val;
		printf("push the elements is%d",s[*top]);
	}
}
void pop(int s[],int *top)
{
	int pval;
	if(*top==-1)
	{
		printf("stack is underflow\n");
		
	}
	else
	{
		*top=*top-1;
		s[*top]=pval;
	}
	
}
void peep(int s[],int *top)
{
	if(*top==-1)
	{
		printf("on a top is%d",s[*top]);
	}
}
void display(int s[],int *top)
{
	if(s[*top]==-1)
	{
		printf("\n stack is empty...");
		
	}
	else
	{
		int i;
		for(i=0;i<=*top;i++)
		{
			printf("%d\n",s[i]);
		}
	}

}