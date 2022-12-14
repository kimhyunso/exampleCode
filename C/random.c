#include<stdio.h>
#include<stdlib.h>
#include<time.h>


int main(){
	int random;
	int i;
	srand(time(0));

	for(i=1; i<=6; i++){
		random = rand()%45+1;
		printf("random = %d \n",random);
	}

	return 0;
}
