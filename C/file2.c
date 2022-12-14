#include<stdio.h>
#include<stdlib.h>
int main(){
	FILE *fp;
	int age=12;
	char name[20]="Hong jil dong";
	
	printf("Insert Name : ");
	scanf("%s",name);


	fp = fopen("sample.txt","w+");
	if(fp==NULL){

		printf("file open error\n");
		return -1;
	}
	fprintf(fp,"HI %s, You are %d years old\n",name,age);	


	fclose(fp);
	return 0;
}
