#include<stdio.h>
#include<conio.h>
#define size 5

void main()
{
	int stack[size];
	int top=-1;
	int value,ch;
	
	void push(int stack[],int *top,int value);
	void pop(int stack[],int *top);
	void peep(int stack[],int *top);
	void display(int stack[],int *top);
	
	printf("\n1.push..");
	printf("\n2.pop..");
	printf("\n3.peep..");
	printf("\n4.display..");
	printf("\n5.exit..\n");
	
	while(1)
	{
		printf("\nENTER A YOUR CHOICE");
		scanf("%d\n",&ch);
		
		switch(ch)
		{
			case 1:
					printf("\nENTER A ANY VALUE");
					scanf("%d",&value);
					push(stack,&top,value);
					break;
			case 2:
					pop(stack,&top);
					break;
			case 3:
					peep(stack,&top);
					break;
			case 4:
					display(stack,&top);
					break;
		
			default:
					printf("invaliid choice..");
					break;
					
		}
		
		
	}
	
}
void push(int stack[],int *top,int value)
{
	if(*top>=size-1)
	{
		printf("STACK IS OVERFLOW");
		
	}
	else
	{
		*top=*top+1;
		stack[*top]=value;
		printf("\nPUSH THE VALUE IS %d",value);
	}
}
void pop(int stack[],int *top)
{
	int pvalue;
	if(*top==-1)
	{
		printf("STACK IS UNDERFLOW");
		
	}
	else
	{
		pvalue=stack[*top];
		*top=*top-1;
	
		printf("\nPOP THE VALUE IS %d",pvalue);
		
	}
}
void peep(int stack[],int *top)
{
	printf("\nPEEP THE VALUE IS %d",stack[*top]);
}
void display(int stack[],int *top)
{
	int i;
	
	if(*top==-1)
	{
		printf("stack is empty..");
		
	}
	else
	{
	
	for(i=0;i<=*top;i++)
	{
		printf("%d\n",stack[i]);
	}
}
}
