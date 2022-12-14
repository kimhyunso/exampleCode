#include<stdio.h>
#include<string.h>
int main(){
	char init='A';
	int i;
	int size;
	char buf[30];	

	//printf("insert name : ");
	//scanf("%s",buf);
	//printf("Hellow %s\n",buf);

	strcpy(buf,"Hellow");
	printf("Hi %s\n",buf);
	
	printf("buf = %p\n",&buf);
	printf("buf1 = %p\n",&buf[1]);
	printf("buf2 = %p\n",&buf[2]);

	int a = 5;
	int b = 6;
	printf(" && ",5>3&&10>3);
	printf("a & b = %d\n",a&b);
	printf("a | b = %d\n",a|b);

	for(i=0; i<20; i++){
		printf("%d : %c : %d\n",i,buf[i],buf[i]);
	}

	
	size=sizeof(int);
	printf("int size : %d\n",size);
	size=sizeof(init);
	printf("char size : %d\n",size);
	for(i='a'; i<='z'; i++){
		printf("%c",i);
	}
	printf("\n");

	//scanf -> get[s(string)]
	//printf -> [s(string)]prinf
	
	sprintf(buf,"Hello %05d ~~",12);
	printf("buf = %s\n",buf);
	printf("insert name : ");
	//gets(buf); //dangerous 
	fgets(buf,sizeof(buf)-1,stdin);
	printf("buf = %s\n",buf);
	return 0;

}
