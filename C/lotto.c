#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int main(){
	int lotto[6];
	int i;
	int j;
	int temp;
	int count=0;

	srand(time(0));
	for(i=0; i<6; i++){
		lotto[i]=rand()%45+1;
		for(j=0; j<i; j++){
			if(lotto[i]==lotto[j]){
				i--;
				break;
			}
		}
	}

	for(i=0; i<6; i++){
		for(j=i+1; j<6; j++){
			if(lotto[i]>lotto[j]){
				temp=lotto[i];
				lotto[i]=lotto[j];
				lotto[j]=temp;
				count++;
			}
		}
	}
	printf("count : %d \n",count);

	for(i=0; i<6; i++){
		printf("%02d   ",lotto[i]);
		if(i/5==1)printf("\n");	
	}

	return 0;
}

