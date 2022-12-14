#include<stdio.h>

int main(){
	int i;
	for(i=1; i<=30; i++){
		printf("%2d  ",i);
		if(i%7==0){
			printf("\n");
		}
	}
	printf("\n");
	return 0;

}
