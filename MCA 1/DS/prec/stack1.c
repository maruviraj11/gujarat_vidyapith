#include<stdio.h>
#include<stdlib.h>

#define size 5

void push(int s[], int *top, int val);
void pop(int s[], int *top);
void peep(int s[], int *top);
void display(int s[], int *top);

int main()
{
    int s[size];
    int top = -1;
    int choice = 0, val;

    while(choice != 5)
    {
        printf("\n1.Push\n2.Pop\n3.Peep\n4.Display\n5.Exit");
        printf("\nEnter your choice: ");
        scanf("%d", &choice);

        switch(choice)
        {
            case 1:
                printf("Enter value to push: ");
                scanf("%d", &val);
                push(s, &top, val);
                break;

            case 2:
                pop(s, &top);
                break;

            case 3:
                peep(s, &top);
                break;

            case 4:
                display(s, &top);
                break;

            case 5:
                printf("Exit...");
                break;

            default:
                printf("Invalid choice");
        }
    }
    return 0;
}

void push(int s[], int *top, int val)
{
    if(*top >= size - 1)
        printf("Stack Overflow");
    else
    {
        (*top)++;
        s[*top] = val;
        printf("Pushed: %d", val);
    }
}

void pop(int s[], int *top)
{
    if(*top == -1)
        printf("Stack Underflow");
    else
    {
        printf("Popped: %d", s[*top]);
        (*top)--;
    }
}

void peep(int s[], int *top)
{
    if(*top == -1)
        printf("Stack is empty");
    else
        printf("Top element: %d", s[*top]);
}

void display(int s[], int *top)
{
    if(*top == -1)
        printf("Stack is empty");
    else
    {
        int i;
        printf("Stack elements:");
        for(i = *top; i >= 0; i--)
            printf("\n%d", s[i]);
    }
}

