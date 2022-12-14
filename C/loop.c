#include<stdio.h>
int main(){
	int i=0;
	for(;;){
		printf("insert number : ");
		scanf("%d",&i);

		if(i%7==0){
			break;
		}
		printf("%d \n",i);
	}	


	printf("loop.c \n");	
	return  0;
}
