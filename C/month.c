#include<stdio.h>

int main(){
	int last;
	int month;
	printf("insert month : ");
	scanf("%d",&month);
	
	if(month==1){
		last=31;
	}else if(month==2){
		last=28;
	}else if(month==3){
		last=31;
	}else{
		last=30;
	}
	

	if(month==1 || month==3){
		last=31;
	}else if(month==2){
		last=28;
	}else{
		last=30;
	}

	printf("last : %d \n",last);

}
