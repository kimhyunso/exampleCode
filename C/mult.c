#include<stdio.h>

int main(){
	int table=3;
	int i;
	
	printf("insert table : ");
	scanf("%d",&table);
	for(i=1; i<=9; i++){
		printf("%d * %d = %02d \n",table,i,table*i);
	}

	
	
	return 0;
}
