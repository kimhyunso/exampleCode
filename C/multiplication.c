#include<stdio.h>

int main(){
	int table;
	int i;
	for(table=2; table<10; table++){
		for(i=1; i<10; i++){
			printf("%d * %d = %d\n",table,i,table*i);
		}
		printf("\n");
	}
	return 0;
}
