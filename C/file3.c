#include<stdio.h>
#include<stdlib.h>

int main(){
	FILE *fp;
	char buf[1024];
	char day[20];
	char time[20];

	int yy,mm,dd,hh,min,sec;

	fp = fopen("sample.txt","r");
	if(fp==NULL){

		printf("file open error\n");
		return -1;
	}
	
	//fgets(buf,sizeof(buf)-1,stdin);
	//printf("buf = %s\n",buf);
	//fscanf(fp,"%s %s",day,time);
	//printf("day : %s , time : %s\n",day,time);
	fscanf(fp,"%d-%d-%d %d:%d:%d",&yy,&mm,&dd,&hh,&min,&sec);	
	printf("%d-%d-%d %d:%d:%d\n",yy,mm,dd,hh,min,sec);
	fclose(fp);
	return 0;
}
