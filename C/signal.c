#include<stdio.h>
#include<signal.h>

void sig_test(int sig_no){
	switch(sig_no){
	case SIGINT:
		printf("Ctnl+c press \n");
		break;
	case SIGSEGV:
		printf("SIGSEGC \n");
		exit(1);
		break;
	default:
		printf("Hellow\n");
		break;
	}

}
int main(){
	int count =0;
	signal(SIGINT,sig_test);
	//signal(SIGSEGV,sig_test);
	
#if 0
	printf("11111\n");
	printf("11111\n");
	printf("11111\n");
	printf("11111\n");
	printf("11111\n");
	printf("11111\n");
	printf("11111\n");
#endif

#ifdef DEBUG1
	printf("count %d\n",count);
	printf("&count %d\n",&count);
	printf("%s, %s, %d\n",__FILE__,__FUNCTION__,__LINE__);

#endif
	while(1){
		usleep(1000000);
		printf("%d\n",++count);
		if(count>=30)break;
	}
	
	return 0;
}
