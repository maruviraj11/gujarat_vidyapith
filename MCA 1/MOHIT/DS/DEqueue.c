#include<stdio.h>
#include<stdlib.h>
#define max 5

void insertFront(int*,int*,int[],int);
void insertRear(int*,int*,int[],int);
int deleteFront(int*,int*,int[]);
int deleteRear(int*,int*,int[]);
int modify(int*,int*,int[],int,int);
void display(int*,int*,int[]);

void main()
{
    int *f,*r,val,choice,rval,pos,mVal;
    int q[max];

    f=(int*)malloc(sizeof(int));
    r=(int*)malloc(sizeof(int));
    *f=-1;
    *r=-1;

    while(1)
    {
        printf("\n1.Insert Front\n2.Insert Rear\n3.Delete Front\n4.Delete Rear\n5.Modify\n6.Display\n7.Exit\nEnter choice: ");
        scanf("%d",&choice);

        switch(choice)
        {
            case 1:
                printf("Enter value: ");
                scanf("%d",&val);
                insertFront(f,r,q,val);
                break;

            case 2:
                printf("Enter value: ");
                scanf("%d",&val);
                insertRear(f,r,q,val);
                break;

            case 3:
                rval=deleteFront(f,r,q);
                if(rval==-1) printf("Queue is empty!!");
                else printf("Deleted: %d",rval);
                break;

            case 4:
                rval=deleteRear(f,r,q);
                if(rval==-1) printf("Queue is empty!!");
                else printf("Deleted: %d",rval);
                break;

            case 5:
                printf("Enter position to modify: ");
                scanf("%d",&pos);
                printf("Enter new value: ");
                scanf("%d",&mVal);
                rval=modify(f,r,q,pos,mVal);
                if(rval==-1) printf("Invalid position!!");
                else printf("Modified value: %d",rval);
                break;

            case 6:
                display(f,r,q);
                break;

            case 7:
                exit(0);

            default:
                printf("Invalid input!!");
        }
    }
}

void insertFront(int *f,int *r,int q[max],int val)
{
    if((*f==0 && *r==max-1) || (*r+1==*f))
    {
        printf("Queue is full!!");
    }
    else if(*f==-1)
    {
        *f=*r=0;
        q[*f]=val;
    }
    else if(*f==0)
    {
        *f=max-1;
        q[*f]=val;
    }
    else
    {
        (*f)--;
        q[*f]=val;
    }
    printf("Inserted at front: %d\n",val);
}

void insertRear(int *f,int *r,int q[max],int val)
{
    if((*f==0 && *r==max-1) || (*r+1==*f))
    {
        printf("Queue is full!!");
    }
    else if(*f==-1)
    {
        *f=*r=0;
        q[*r]=val;
    }
    else if(*r==max-1)
    {
        *r=0;
        q[*r]=val;
    }
    else
    {
        (*r)++;
        q[*r]=val;
    }
    printf("Inserted at rear: %d\n",val);
}

int deleteFront(int *f,int *r,int q[max])
{
    int temp;
    if(*f==-1) return -1;

    temp=q[*f];
    if(*f==*r)
        *f=*r=-1;
    else if(*f==max-1)
        *f=0;
    else
        (*f)++;
    return temp;
}

int deleteRear(int *f,int *r,int q[max])
{
    int temp;
    if(*f==-1) return -1;

    temp=q[*r];
    if(*f==*r){
        *f=*r=-1;
    }else if(*r==0){
        *r=max-1;
    }else{
        (*r)--;
	}
    return temp;
}

int modify(int *f,int *r,int q[max],int pos,int mVal)
{
    if(*f==-1) return -1;

    int count,i;
    if(*r>=*f)
        count=*r-*f+1;
    else
        count=(max-*f)+(*r+1);

    if(pos<1 || pos>count) return -1;

    q[(*f)+pos-1]=mVal;	
    return q[(*f)+pos-1];
}

void display(int *f,int *r,int q[max])
{
    if(*f==-1)
    {
        printf("Queue is empty!!");
        return;
    }
    int i=*f;
    while(1)
    {
        printf("%d ",q[i]);
        if(i==*r) break;
        if(i==max-1) i=0;
        else i++;
    }
}

