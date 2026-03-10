#include<stdio.h>
#include<conio.h>
#define size 5



int main()
{
    
void push(int stack[],int *top,int value);
void pop(int stack[],int *top);
void display(int stack[],int *top);

    int stack[size];
    int top=-1;
    int choice=0,value;

    while (choice=4)
    {
        printf("\n stack operation\n");
        printf("\n1.push\n 2.pop\n 3.displlay\n4.exit\n");
        printf("ENTER YOUR CHOICE");
        scanf("%d",&choice);

        switch (choice)
        {
            case 1:
                if(top==size-1)
                {
                    printf("stack is overload,can not push more item");
                }
                else
                {
                    printf("ENTER A VALUE OF PUSH");
                    scanf("%d",&value);
                    push(stack,&top,value);
                }
                break;
            case 2:
                if(top==-1)
                {
                    printf("stack is underflow");
                }
                else
                {
                    pop(stack,&top);
                }
                break;
            case 3:
                display(stack,&top);
                break;
            case 4:
                    printf("existing program..\n");
                    break;
                    //return 0;
            default:
                printf("invalid choice ! pleace tray again...");
        }
    }
    return 0;
    
}
void push(int stack[],int *top,int value)
{
    *top=*top+1;
    stack[*top]=value;
    printf("pushed %d on to stack \n", value);

}
void pop(int stack[],int *top)
{
    int popvalue=stack[*top];
    *top=*top-1;
    printf("poped %d from stack \n ",popvalue);

}
void display(int stack[],int *top)
{
    if(*top==-1)
    {
        printf("stack is empty");
    }
    else
    {
        printf("stack elements(top to bottem)\n");

        for(int i=*top;i>=0;i--)
        {
            printf("%d\n",stack[i]);
        }
    }

}