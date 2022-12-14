#include<stdio.h>

int get_number();
int calculate_lastday(int year,int month);
int get_feb(int y);
int main(){
	int year;
	int month;
	int last;
	
	year = get_number();
	month=get_number();
	last = calculate_lastday(year,month);
	printf("year : %d \n",year);
	printf("month : %d\n",month);
	printf("last : %d\n",last);
	return 0;
}

int get_feb(int y){
	if(y%4==0||y%100==0||y%400==0){
		return 29;
	}else{
		return 28;
	}
	return 0;
}

int calculate_lastday(int y,int m){
	int value;
	switch(m){
	case 4:
	case 6:
	case 9:
	case 11:
		value=30;
		break;
	case 2: 
		value=get_feb(y);
		break;
	default : 
		value=30;
		break;
	}
	return value;
}


int get_number(){
	int num;
	printf("insert num : ");
	scanf("%d",&num);
	return num;
}
