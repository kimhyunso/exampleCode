#include<stdio.h>
#include<pthread.h>

void one(){
	int count =0;
	while(1){
		sleep(1);
		printf("ONE : %d\n",++count);
	}
}


void five(){
	int count =0;
	while(1){
		sleep(5);
		printf("FIVE : %d\n",++count);
	}
}

void three(){
	int count =0;
	while(1){
		sleep(3);
		printf("three : %d\n",++count);
	}
}
int main(){
	pthread_t thread_one , thread_five,thread_three;

	if(pthread_create(&thread_one,NULL,(void *)one,NULL)<0){
		printf("FAIL1\n");
	}else{
		printf("OK..5\n");
	}

	if(pthread_create(&thread_five,NULL,(void *)five,NULL)<0){
		printf("FAIL5\n");
	}else{
		printf("OK..5\n");
	}
	if(pthread_create(&thread_three,NULL,(void *)three,NULL)<0){
		printf("FAIL3\n");
	}else{
		printf("OK..3\n");
	}
	
	pthread_join(thread_one,NULL);

	return 0;
}
