#include<stdio.h>

typedef unsigned char uint8;
typedef unsigned short uint16;
typedef unsigned int uint32;

typedef struct _hdr_t{
	uint16 src;
	uint16 dst;

	uint32 seq;

	uint16 offset:4;
	uint16 rsv:6;
	uint16 syn:1;
	uint16 ack:1;
	uint16 fin:1;
	uint16 test:3;
	uint16 window;

} hdr_t;

int main(){
	hdr_t hdr;
	int i;
	hdr.syn = 0;
	hdr.test = 0;
	

	for(i=1; i<=15; i++){
		printf("%d : syn = %d , test = %d\n",i,hdr.syn++,hdr.test++);
	}
	

	printf("&gdr.dst = %p\n",&hdr.dst);
	printf("&gdr.src = %p\n",&hdr.src);
	printf("&gdr.seq = %p\n",&hdr.seq);
	//printf("&gdr.offset = %p\n",&hdr.offset);
	/*for(i=1; i<=15; i++){
		printf("%d : syn = %d , test = %d", \
			i,\
			hdr.syn,\
			hdr.test);
	}*/
	return 0;
}
