#include<stdio.h>

int main(){
	int a=3;
	int *ptr;
	int **dptr;
	ptr=&a;
	*ptr=7;
	dptr=&ptr;
	**dptr=8;	
	printf("a : %d\n",a);
	return 0;
}
