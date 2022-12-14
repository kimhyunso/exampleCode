#include<stdio.h>



void swap(int *a,int *b){
	int temp;
	temp=*a;
	*a=*b;
	*b=temp;
	printf("swap a : %d b : %d \n",*a,*b);
}




int main(){
	int a =3 , b=2;
	printf("before a : %d b : %d \n",a,b);

	swap(&a,&b);

	printf("after a : %d b : %d \n",a,b);
	return 0;
}

