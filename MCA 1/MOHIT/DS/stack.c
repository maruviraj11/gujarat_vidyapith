/*implimatation of Stack*/
#include<stdio.h>
#include<stdlib.h>
#define max 3

void main()
{
	void push(int *,int [],int);
	int pop(int*,int []);
	void display(int *,int []);
	int peep(int *,int []);

	int *top;
	int ele,choice,val;;
	int S[max];

	top=(int*)malloc(sizeof(int));
	*top=-1;
	while(1)
	{
		printf("\n1 .Push\n");
		printf("2 .Pop\n");
		printf("3 .Peep\n");
		printf("4 .Display\n");
		printf("5 .Exit\n");

		printf("Enter Your Choice: ");
		scanf("%d",&choice);

		switch(choice)
		{
		case 1: 
				printf("Enter The Element : ");
				scanf("%d",&ele);
				push(top,S,ele);
				break;
		case 2:	val=pop(top,S);
	            if(val == -1)
	            {
	            	printf("Stack is Underflow");
				}
				else
				{
					printf("Removed Value is %d",val);
				}
				break;
		case 3:	val=peep(top,S);
				if(val == -1)
				{
					printf("Stack is Underflow");
				}
				else
				{
					printf("Peepepd Value is %d",val);
				}
				
				break;
		case 4:	display(top,S);
				break;
				
		case 5:
				printf("\nExiting...");
				exit(0);
		default:
				printf("Invalid input.");
				break;
		
		}
	}
}
void push(int *top,int S[max],int nval)
{
	if(*top==max-1)
	{
		printf("Stack is Overflow");
	}
	else if(*top==-1)
	{
		S[*top]=nval;
	}
	else
	{
		*top++;
		S[*top]=nval;
	}
}
int pop(int *top,int S[max])
{	int val;
	if(*top==-1)
	{
		return -1;
	
	}
	else
	{
		val=S[*top];
		*top--;
		return val;
		
	}
	
}
int peep(int *top,int S[max])
{	
    if(*top == -1)
    {
    	return -1;
	}
	else
	{
		return S[*top];
	}

}
void display(int *top,int S[max])
{	
	int i;
	if(*top == -1)
    {
    	printf("Stack underflow!!");
	}
	else
	{
		for(i=0;i<=*top;i++)
		{
			printf("%d ",S[i]);
			
		}
	}
}
