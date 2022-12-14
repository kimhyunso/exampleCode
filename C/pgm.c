#include <stdio.h>


//int main(int argc,char *argv[]){ 
//int main(int argc,char argv[][]){ 

int main(int argc,char **argv){
	int i;
	printf("argc = %d\n",argc);
	printf("argc[0]=%s\n",argv[0]);	
	printf("argc[1]=%s\n",argv[1]);	
	return 0;
}
