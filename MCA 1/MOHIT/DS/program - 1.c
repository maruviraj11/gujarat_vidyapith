//Program -1 : Write Menu driven program to implement operations of stack 1) Push 2) pop 3) peep 4) display
#include<stdio.h>
#include<stdlib.h>
#define max 5

void main()
{
	int *top;
	int value,rval,choice;
	int a[max];
	
	void push(int [],int *,int );
	int pop(int [],int *);
	int peep(int [],int *);
	int display(int [],int *);
	
	top = (int *)malloc(sizeof(int));
	*top = -1;
	
	printf("....Stack Menu....\n");
	while(1)
	{
		printf("\n1. Push \n2. Pop \n3. Peep \n4. Display\n5. Exit\n");
		printf("Enter Choice : ");
		scanf("%d",&choice);
		
		switch(choice){
			case 1: 
			
					printf("Enter Element to push:");
					scanf("%d",&value);
					push(a,top,value);
					break;
			case 2: 
			
					rval = pop(a,top);
					if(rval == -1)
					{
						printf("Stack underflow!!");
					}else
					{
						printf("Popped Element: %d\n", rval);	
					}
					
					break;
			case 3: 
			
					rval = peep(a,top);
					if(rval == -1)
					{
						printf("Stack underflow!!");
					}else
					{
						printf("Top Element: %d\n", rval);
					}
					break;
			case 4: 
			
					display(a,top);
					break;
					
			case 5:
				
					exit(0);
					free(top);
					
			default: 
			
					printf("Enter Valid Choice...");
					break;
		}
	}
	
}
void push(int a[max],int *top,int val)
{
	if(*top>=max-1)
	{	
		printf("\nStack is Overflow...\n");
	}
	else
	{
		(*top)=(*top)+1;
		a[(*top)]=val;
		printf("\nPushed Element: %d",a[(*top)]);

	}
}
int pop(int a[max],int *top){
	int no;
	if(*top==-1)
	{
		return -1;
	}
	else
	{
		no=a[(*top)];
		(*top)=(*top)-1;
		return no;
	}	
}
int peep(int a[max],int *top)
{
	if(*top==-1)
	{
		return -1;
	}
	else
	{
		return a[(*top)];
	}
	
}
int display(int a[max],int *top)
{
	int i;
	if (*top == -1) 
	{
        printf("\nStack is empty\n");
    }
    else
    {
	
		printf("\nStack Elements:\n");
    	for (i = (*top); i >= 0; i--) 
		{
        	printf("\t%d\n", a[i]);
    	}
	}
}
