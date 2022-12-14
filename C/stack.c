#include<stdio.h>
#define MAX 5

int stack[MAX];
int top;
void push(int number){
	if(top==MAX-1){
		printf("FULL\n");
		return;
	}
	stack[top++]=number;
	printf("push!\n");
}

void pop(){
	int value;
	if(top==-1){
		printf("EMPTY\n");
		return;
	}
	value=stack[top--];
	printf("pop\n");
}
void dump(){
	int i;
	for(i=top; i=>0; i--){
		printf("stack[%d] : %d\n",i,stack[i]);
	}
}

int main(){
	top = -1;
	int cmd;	
	int num;
	int flag=1;
	do{
		printf("1.Push 2.Pop 3.Dump 4.Exit : ");
		scanf("%d",&cmd);
		
		switch(cmd){
		case 1:
			printf("Insert num : ");
			scanf("%d",&num);
			push(num);
			break;
		case 2:
			pop();
			break;
		case 3:
			dump();
			break;
		case 4:
			flag=0;
			break;
		}

	}while(flag);

	return 0;
}
