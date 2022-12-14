#include<stdio.h>
#include<stdlib.h>
int main(){
	FILE *fp;
	char *line=NULL;
	size_t len=0;
	ssize_t nread;	
	int count=0;
	int size;

	fp = fopen("tcp.c","r");
	if(fp==NULL){

		printf("file open error\n");
		return -1;
	}
	line =(char *)malloc(1024);
	size=sizeof(fp);
	while((nread=getline(&line,&len,fp))!=-1){
		printf("%s",line);
		count++;
	}
	printf("%d\n",size);
	printf("%d\n",count);

	fclose(fp);
	return 0;
}
