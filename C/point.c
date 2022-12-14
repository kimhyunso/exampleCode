#include<stdio.h>

int main(){
	int a = 3;
	int *ptr;

	//printf("a : %p \n",&a);
	ptr=&a;
	printf("a adress : %p \n",&a);	
	printf("ptr adress :  ptr : %p\n",ptr);
	printf("&ptr adress : %p\n",&ptr);
	printf("ptr : %d\n",ptr);

	//ptr = &a;
	//printf("ptr : %p\n",ptr);
	//printf("&ptr : %p\n",&ptr);


	//*ptr =7;
	//*ptr=*ptr+3;
	//printf("a = %d\n",a);
	//ptr=&a;
	//printf("%p \n",&ptr);
	//printf("%d \n",&ptr);
	//ptr = 0;
	//printf("*ptr : %d\n",*ptr);
	
	return 0;
}
