#include<stdio.h>
int main(){
	int month=7;
	switch(month){
	case 4:
	case 6:
	case 9:
	case 11:
		printf("30 \n");
		break;
	case 2:
		printf("28 \n");
		break;
	default:
		printf("31 \n");
		break;	
	}	

	return 0;

}
