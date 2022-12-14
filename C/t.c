#include<stdio.h>

void print_alphabet(int count){
	int i,j;
	for(i=0; i<=count; i++){
		for(j='A'; j<='Z'; j++){
			printf("%c",j);
		}
		printf("\n");
	}

}

int main(){
	int input;
	int result=0;
	int i;

	printf("insert num : ");
	scanf("%d",&input);
	if(input%2==0){
		for(i=1; i<=input; i++){
			result+=i;
		}
		print_alphabet(10);
	}else{
		result=1;
		for(i=1; i<=input; i++){
			result*=i;
		}
		print_alphabet(result);
	}
	printf("%d\n",result);

	return 0;
}
