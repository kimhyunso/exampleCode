#include<stdio.h>
#include<pthread.h>

int g_count = 0;
pthread_mutex_t mutex;


void plus(){

	int i;
	for(i=1; i<=10000000; i++){
		pthread_mutex_lock(&mutex);
		g_count++;
		pthread_mutex_unlock(&mutex);
	}
	printf("PLUS : %d\n",g_count);

}


void minus(){
	int i;
	for(i=1; i<=10000000; i++){
		pthread_mutex_lock(&mutex);
		g_count--;
		pthread_mutex_unlock(&mutex);
	}
	printf("MINUS : %d\n",g_count);

}
int main(){
	pthread_t thread_plus , thread_minus;

	if(pthread_create(&thread_plus,NULL,(void *)plus,NULL)<0){
		printf("FAIL PLUS\n");
	}else{
		printf("OK..PLUS\n");
	}

	if(pthread_create(&thread_minus,NULL,(void *)minus,NULL)<0){
		printf("FAIL MINUS\n");
	}else{
		printf("OK..MINUS\n");
	}
	
	pthread_join(thread_plus,NULL);

	return 0;
}
