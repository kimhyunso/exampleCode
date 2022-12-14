#include<stdio.h>
#include<string.h>

int main(){
	char str1[100]="Hello World";
	char str11[100]="abcdefghijkl";
	char str2[100]="Hello World";
	char str3[100]="0123456789";
	char str4[100]="";
	int size;
	size=strlen(str1); //string length
	printf("%d\n",size);
	strcpy(str4,str1); //value copy
	printf("str4 = %s\n",str4);
	strncpy(str4,str1,5); //value copy
	str4[5]=NULL;
	printf("str4 = %s\n",str4);
	strcat(str1,str11);
	printf("str1 : %s\n",str1);
	size=strcmp("Hello World",str2);
	printf("size : %d\n",size);
	
	strcpy(str1,"C,Java,JSP,PHP,C++");
	char *delimeter=",";
	char *token;
	token = (char *)malloc(30);
	token=strtok(str1,delimeter);
	while(token != NULL){
		printf("%s\n",token);
		token=strtok(NULL,delimeter);
	}	
	
	return 0;
}
