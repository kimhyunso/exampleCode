#include<stdio.h>
#include<string.h>

struct book{
	char title[30];
	int price;
	int page;

};

struct memory{
	int a;
	char b;
	char d;
	char rsv1;
	char rsv2;
	int c;
};

int main(){
	int size;
	struct book math;
	struct memory memo;
	struct book *ptr;	

	size =sizeof(math);
	size =sizeof(memo);
	printf("%d\n",size);
	
	math.price=12300;	
	math.page=1200;
	strcpy(math.title,"Basic Math..");
	printf("price : %d\n",math.price);
	printf("title : %s\n",math.title);
	printf("page : %d\n",math.page);
	ptr=&math;
	
	printf("ptr : %p\n",ptr);	
	printf("&math : %p\n",&math);
	
	ptr -> price =20000;
	ptr -> page=1300;
	strcpy(ptr->title,"Hellow English");

	printf("price : %d\n",math.price);
	printf("title : %s\n",math.title);
	printf("page : %d\n",math.page);
	
	return 0;
}
