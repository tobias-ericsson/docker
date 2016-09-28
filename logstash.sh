docker run -it --name logstash -p 5044:5044 \
	 -v "$PWD/config":/config \
         -v /etc/localtime:/etc/localtime \
	 -d logstash:5 logstash -f /config/logstash.conf

