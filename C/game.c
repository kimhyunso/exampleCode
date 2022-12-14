#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int main(){
	int game;
	int i,j,k;
	int temp;
	int lotto[6];
	
	while(1){
		printf("Count Game : ");
		scanf("%d",&game);
		srand(time(0));		
		for(k=0; k<game; k++){
			printf("Game Count : %d\n",k+1);
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
					}
				}
				printf("%02d   ",lotto[i]);
				if(i/5==1)printf("\n");	
			}
			
		}
		printf("\n");
		if(game==0)break;
	}	

	return 0;
}
