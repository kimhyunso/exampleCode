#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#define MAX 	256

float get_tem(){
	unsigned int random;
	random = rand() % 10+15;
	return random * 1.3;

}

float get_hum(){
	unsigned int random;
	random = rand() % 10+15;
	return random * 1.3;
}

typedef struct _data_t{
	int id;
	int seq;
	float temperature;
	float humidity;

} data_t;

int main(int argc, char **argv)
{
	struct sockaddr_in server, client;
	int cli_len, server_len;
	int port;
	int sd;
	char *ip;
	unsigned char buf[MAX] = "TEST String to Send";
	int seq = 0;
	data_t data;
	
	srand(time(0));

	if(argc != 4)
	{
		printf("[usage] %s serverip, serverport, id\n", argv[0]);
		return -1;
	}

	ip = (char *)malloc(20);

	strcpy(ip, argv[1]);
	port = atoi(argv[2]);

	if((sd = socket(AF_INET, SOCK_DGRAM, 0))<0) {
		printf("CLIENT Socket() Error\n");
		return -1;
	}

	bzero((char *)&server, sizeof(server));
	server.sin_family = AF_INET;
	server.sin_addr.s_addr = inet_addr(ip);
	server.sin_port = htons(port);
	cli_len = sizeof(server);

	while(1)
	{
		seq++;
		data.id = atoi(argv[3]);
		data.seq = seq;
		data.temperature = get_tem();
		data.humidity = get_hum();

		if(sendto(sd, (void *)&data, sizeof(data), 0, (struct sockaddr *)&server, cli_len)<0) 
		{
			printf("Client Sendto Error\n");
			return -1;
		}
	
		printf("(id , seq , temp, hum) = (%d,%d,%.1f,%.1f)\n",data.id,data.seq,data.temperature,data.humidity);
		sleep(3);


	}
	close(sd);

	return 0;
}

