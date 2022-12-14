#include<stdio.h>
int main(){
	int i;
	for(i='A'; i<='Z'; i++){
		printf("%c , 0x%X \n",i,i);	
	}
	printf("\n");

	for(i=1; i<=100; i*=2){
		printf("%d \n",i);
	}
	
	for(i=1; i<=100; i++){
		if((!(i%10==0))&&((i%10)%3==0)){
			printf("*\n");
		}else{
			printf("%d\n",i);
		}
	}
	

	return 0;
}
