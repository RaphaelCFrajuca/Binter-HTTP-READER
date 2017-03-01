# Binter-HTTP-READER
Programa feito em JAVA para fazer HTTP Requests com Header Personalizado

## Modo de uso:

curl https://raw.githubusercontent.com/BadGuy552/Binter-HTTP-READER/master/Binter-HTTP-READER.jar > Binter-HTTP-READER.jar

java -jar Binter-HTTP-READER.jar *IP* *PORTA* *"HTTP READER PERSONALIZADO"*

Exemplo:

java -jar Binter-HTTP-READER.jar domain.com 80 "GET http://domain.com/ HTTP/1.1[crlf]Host: domain.com[crlf][crlf]CONNECT [host_port] [protocol][crlf][crlf]"

Assumindo que:

[host] 	domain.com

[port] 	80

[host_port] 	domain.com:80	

[protocol] 	HTTP\1.0 ou HTTP\1.1 

[netData] 	CONNECT [host_port] [protocol] 	

[cr] 	\r 	

[lf] 	\n 	

[crlf] 	\r\n 

[lfcr] 	\n\r 	

[crlf][crlf] 	\r\n\r\n 	
