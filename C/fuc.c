#include<stdio.h>
int add(int x,int y){
	printf("i am add...\n");
	return x+y;
}
int main(){
	int a,b;
	int result;
	a=1; b=2;
	result=add(a,b);
	printf("result = %d \n",result);
	return 0;
}
