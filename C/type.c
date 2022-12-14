#include<stdio.h>
#include<string.h>

typedef unsigned char uint8;
typedef unsigned short uint16;
typedef unsigned int uint32;

typedef char int8;
typedef short int16;
typedef int int32;

typedef struct _book_t{
	char title[30];
	int price;
	int page;

} book_t;

struct memory{
	uint32 a;
	
	uint8 b;
	uint8 c;
	uint8 rsv1;
	uint8 rsv2;

	uint32 d;
};

int main(){
	book_t math;
	book_t *ptr;

	math.price=1200;
	math.page=1234;
	strcpy(math.title,"Hello Math");
	printf("math price : %d\n",math.price);
	printf("math page : %d\n",math.page);
	printf("math title : %s\n",math.title);
	
	ptr=&math;

	printf("ptr title : %s\n",ptr->title);
	printf("ptr price : %d\n",ptr->price);
	printf("ptr page : %d\n",ptr->page);
	return 0;
}
