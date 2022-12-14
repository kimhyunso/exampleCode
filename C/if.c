#include<stdio.h>

int main(){
	
	int num=20;
	int input;
	int max,min;
	

	printf("input : ");
	scanf("%d",&input);
	
	if(input>=num){
		max=input;
		min=num;
		printf("max : %d \n",max);
	}else{
		max=num;
		min=input;
		printf("min : %d \n",min);
	}
	
}
