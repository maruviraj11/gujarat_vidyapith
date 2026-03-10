#include <stdio.h>
#include <stdlib.h>

struct Block {
    int start;
    int size;
    int free;
};

struct Block mem[20];
int n;

void createMemory()
{
    int i;
    printf("\nEnter number of memory blocks: ");
    scanf("%d", &n);

    printf("\nEnter size of each block:\n");
    for(i = 0; i < n; i++)
    {
        printf("Block %d size: ", i);
        scanf("%d", &mem[i].size);
        mem[i].start = i * 100;
        mem[i].free = 1;
    }
}

void allocate()
{
    int req, i, bestIndex = -1;
    int bestSize = 99999;

    printf("\nEnter memory required: ");
    scanf("%d", &req);

    for(i = 0; i < n; i++)
    {
        if(mem[i].free == 1 && mem[i].size >= req)
        {
            if(mem[i].size < bestSize)
            {
                bestSize = mem[i].size;
                bestIndex = i;
            }
        }
    }

    if(bestIndex == -1)
    {
        printf("\nAllocation failed! No suitable block.\n");
        return;
    }

    mem[bestIndex].free = 0;
    printf("\nAllocated at Block %d (Start: %d, Size: %d)\n",
            bestIndex, mem[bestIndex].start, mem[bestIndex].size);
}

void deallocate()
{
    int block;
    printf("\nEnter block number to deallocate: ");
    scanf("%d", &block);

    if(block < 0 || block >= n)
    {
        printf("Invalid block!\n");
        return;
    }

    if(mem[block].free == 1)
    {
        printf("Block already free.\n");
        return;
    }

    mem[block].free = 1;
    printf("Block %d deallocated.\n", block);
}

void display()
{
    int i;
    printf("\nBlock\tStart\tSize\tStatus\n");
    for(i = 0; i < n; i++)
    {
        printf("%d\t%d\t%d\t%s\n",
            i,
            mem[i].start,
            mem[i].size,
            mem[i].free ? "Free" : "Allocated");
    }
}

int main()
{
    int ch;

    createMemory();

    while(1)
    {
        printf("\n\n----- BEST-FIT MEMORY MENU -----\n");
        printf("1. Allocate\n");
        printf("2. Deallocate\n");
        printf("3. Display Blocks\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &ch);

        switch(ch)
        {
            case 1: allocate(); break;
            case 2: deallocate(); break;
            case 3: display(); break;
            case 4: exit(0);
            default: printf("Invalid Choice!\n");
        }
    }

    return 0;
}

