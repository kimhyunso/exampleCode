#include<stdio.h>
#include<time.h>

int main(){
	int count =10;
	while(1){
		usleep(2000000);
		printf("%d\n",count--);
		if(count==0)break;
	}
	
	return 0;
}
