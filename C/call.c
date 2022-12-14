#include<stdio.h>
#include<string.h>

typedef struct _book_t{
	char title[20];
	int price;
	int page;

} book_t;

book_t get_book_info(){
	book_t temp;
	
	strcpy(temp.title,"Hello Math");
	temp.price=1111;
	temp.page=2222;

	return temp;
}
void print_book_pointer(book_t *ptr){
	printf("Title : %s\n",ptr->title);
	printf("price : %d\n",ptr->price);
	printf("page : %d\n",ptr->page);

}
void print_book(book_t book){
	printf("Title : %s\n",book.title);
	printf("price : %d\n",book.price);
	printf("page : %d\n",book.page);

}

int main(){
	book_t math;
	math = get_book_info();
	printf("math.title : %s\n",math.title);
	print_book(math);
	print_book_pointer(&math);
	return 0;
}
