#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#define MAX 	256

int main(int argc, char **argv)
{
	struct sockaddr_in server, client;
	int cli_len, server_len;
	int port;
	int sd;
	char *ip;
	unsigned char buf[MAX] = "TEST String to Send";

	if(argc != 3)
	{
		printf("[usage] %s serverip, serverport\n", argv[0]);
		return -1;
	}

	ip = (char *)malloc(20);

	strcpy(ip, argv[1]);
	port = atoi(argv[2]);

	if((sd = socket(AF_INET, SOCK_DGRAM, 0))<0) { //UDP 
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
		printf("Msg :");
		fgets(buf, sizeof(buf), stdin);

		if(sendto(sd, (void *)&buf, sizeof(buf), 0, (struct sockaddr *)&server, cli_len)<0) 
		{
			printf("Client Sendto Error\n");
			return -1;
		}
	
		printf("send msg = %s\n", buf);
		if(strncmp(buf,"bye",3)==0){
			printf("end of Client\n");
			break;
		}
	}
	close(sd);

	return 0;
}
