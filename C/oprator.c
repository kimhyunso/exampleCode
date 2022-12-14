#include<stdio.h>
int main(){

	int i=10;
	int result;
	float pi=3.14;
	int age;
	
	int a=7 , b=3 ,c=a+b;
	printf("+ : %d \n",a+b);
	printf("- : %d \n",a-b);
	printf("* : %d \n",a*b);
	printf("/ : %d \n",a/b);
	printf("%% : %d \n",a%b);
	
	a ++; 
	printf("%d \n",a);
	a+=1;	
	printf("%d \n",a);

	c=a<<1;
	printf("%d \n",c);
	
	c=a>>1;
	printf("%d \n",c);
	printf("insert : ");
	scanf("%d",&age);
	printf("%d \n",age);
	printf("%d \n",(int)((float)i+pi));
	printf("%f \n",(float)((float)i+pi));
	return 0;
}
