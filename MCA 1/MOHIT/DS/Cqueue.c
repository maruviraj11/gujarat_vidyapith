#include<stdio.h>
#include<stdlib.h>
#define max 3

void insert(int*,int*,int[],int);
int removeq(int*,int*,int[]);
int modify(int*,int*,int[],int,int);
void display(int*,int*,int[]);

void main()
{
    int *f,*r;
    int val,choice,rval,mVal,pos;
    int q[max];

    f=(int*)malloc(sizeof(int));
    r=(int*)malloc(sizeof(int));

    *f=-1;
    *r=-1;

    while(1)
    {
        printf("\n\n1.insert\n2.remove\n3.modify\n4.display\n5.exit\nEnter choice :");
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
                    printf("Queue is empty!!");
                else
                    printf("Removed value : %d",rval);
                break;

            case 3:
                printf("Enter position to modify: ");
                scanf("%d",&pos);
                
                printf("Enter new value: ");
                scanf("%d",&mVal);
                
                rval=modify(f,r,q,pos,mVal);
                
                if(rval==-1)
                {
                    printf("Invalid position!!");
                }else{
                    printf("Value modified: %d\n",rval);
                    display(f,r,q);
            	}
                break;

            case 4:
                display(f,r,q);
                break;

            case 5:
                exit(0);

            default:
                printf("Invalid input!!");
        }
    }
}

void insert(int *f,int *r,int q[max],int nval)
{
    if((*f==0 && *r==max-1) || (*r+1==*f))
    {
        printf("Queue is full!!");
    }
    else
    {
	    if(*f==-1 && *r==-1)
	    {
	        *f=*r=0;
	        q[*r]=nval;
	    }
	    else if(*r==max-1 && *f!=0)
	    {
	        *r=0;
	        q[*r]=nval;
	    }
	    else
	    {
	        (*r)++;
	        q[*r]=nval;
	    }
	    printf("Inserted: %d\n",nval);
	}
}

int removeq(int *f,int *r,int q[max])
{
    int temp;
    if(*f==-1 && *r==-1)
    {
        return -1;
    }
    temp=q[*f];
    if(*f==*r)
    {
        *f=*r=-1;
    }
    else if(*f==max-1)
    {
        *f=0;
    }
    else
    {
        (*f)++;
    }
    return temp;
}

int modify(int* f,int* r,int q[max],int pos,int mVal)
{
    if(*f==-1) {return -1;}

    int count,i;
    
    if(*r>=*f)
    {
	
        count=*r-*f+1;
    }else{
	
        count=(max-*f)+(*r+1);
	}
    if(pos<1 || pos>count) {return -1;}
    
	q[(*f)+pos-1]=mVal;	
    return q[(*f)+pos-1];
}

void display(int *f,int *r,int q[max])
{
    if(*f==-1 && *r==-1)
    {
        printf("Queue is empty!!\n");
        return;
    }
    int i=*f;
    printf("Queue Elements : ");
    while(1)
    {
        printf("%d ",q[i]);
        if(i==*r) break;
        
        if(i==max-1){
			i=0;
		}else{
			i++;
		} 
    }
}

