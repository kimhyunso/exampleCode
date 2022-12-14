#include<stdio.h>

int main(){
	int year;
	int last;
	printf("insert year : ");
	scanf("%d",&year);

	if(year%4==0||year%400==0||year%100==0){
		last=29;
	}else{
		last=28;
	}
	
	
	printf("last : %d year : %d\n",last,year);

	return 0;

}
