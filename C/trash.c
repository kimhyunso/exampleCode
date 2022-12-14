#include<stdio.h>

int main(){
	int a;
	int b;
	printf("%p\n",&a);
	printf("%p\n",&b);
	printf("%d\n",a=0);
	printf("%d\n",b=12);
	return 0;
}
