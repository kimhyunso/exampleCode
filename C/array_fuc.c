#include<stdio.h>
#include<string.h>

void print_array(char array[],int count){
	int i;
	for(i=0; i<count; i++){
		printf("HI %s",array);
	}
}

void print_array2(char *array,int count){
	int i;
	for(i=0; i<count; i++){
		printf("%s",array);
	}
}
int main(){
	char name[20];
	printf("insert name : ");
	fgets(name,sizeof(name)-1,stdin);
	
	//print_array(name,7);
	print_array(name,7);
	return 0;
}

