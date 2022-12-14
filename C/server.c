#include <stdio.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#define MAX	256

int main(int argc, char *argv[])
{
	int port;
	struct sockaddr_in server, client;
	int recvn;
	int cli_len;
	int sd;
	unsigned char buf[MAX];
	int so_reuseaddr = 1;

	if(argc !=2)
	{
		printf("[usage] %s port\n", argv[0]);
		return -1;
	}

	port = atoi(argv[1]);
	if((sd = socket(AF_INET, SOCK_DGRAM, 0))<0)
	{
		printf("SERVER ERROR\n");
		return -1;
	}

	setsockopt(sd, SOL_SOCKET, SO_REUSEADDR, &so_reuseaddr, sizeof(so_reuseaddr));

	bzero((char *)&server, sizeof(server));
	server.sin_family = AF_INET;
	server.sin_addr.s_addr = htonl(INADDR_ANY);
	server.sin_port = htons(port);

	if(bind(sd, (struct sockaddr *)&server, sizeof(server))<0)
	{
		printf("Bind Error\n");
		return -1;
	}

	printf("[SERVER] Listening ... port : %d\n", port);

	while(1)
	{
		cli_len = sizeof(client);
		if((recvn = recvfrom(sd, (void *)&buf, MAX, 0, (struct sockaddr *)&client, &cli_len))<0)
		{
			printf("SERVER RECV ERROR\n");
			return -1;
		}

		printf("buf = %s\n", buf);
	}	

	close(sd);
	return 0;
}

