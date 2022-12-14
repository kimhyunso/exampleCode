#include<stdio.h>
#define MAX  6

int main(){
	int age[MAX]={0,};
	int i;
	int sum=0;
	float avg=0.0;

	for(i=0; i<MAX; i++){
		printf("insert age[%d] : ",i+1);
		scanf("%d",&age[i]);
		sum+=age[i];
	}

	printf("sum = %d\n",sum);
	printf("avg = %.2f\n",avg=((float)sum)/5.0);
	
	for(i=0; i<MAX; i++){
		printf("age[%d] : %d\n",i+1,age[i]);
	}
	
	printf("array.c");

	return 0;
}
