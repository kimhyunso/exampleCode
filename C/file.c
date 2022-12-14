#include<stdio.h>
int main(){
	FILE *fp;
	int readchar;
	int count=0;
	int size;
	fp = fopen("tcp.c","r");
	if(fp==NULL){

		printf("file open error\n");
		return -1;
	}
	while((readchar=fgetc(fp))!=EOF){
		printf("%c",readchar);	
		count++;
	}
	size=sizeof(fp);
	printf("size : %d\n",size);
	printf("count : %d\n",count);
	fclose(fp);
	return 0;
}
