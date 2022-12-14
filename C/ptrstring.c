#include<stdio.h>

int main(){
	char buf[20];
	char *ptr;
	int i;
	
	printf("insert name : ");
	fgets(buf,sizeof(buf)-1,stdin);
	printf("buf : %s\n",buf);
	printf("buf adress : %p\n",&buf);
	printf("buf not adress : %p\n",buf);
	printf("buf[0] adress : %p\n",&buf[0]);
	printf("buf[0] : %c\n",buf[0]);
	printf("buf[1] : %c\n",buf[1]);

	for(i=0; i<7; i++){

		printf("buf[%d] : %c \n",i,buf[i]);
		printf("buf[%d] adress : %p \n",i,&buf[i]);
		printf("buf[%d] point+i : %c \n",i,*(buf+i));
	}

	return 0;
}
