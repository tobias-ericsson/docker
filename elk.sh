#!/bin/sh
create() {
  #https://hub.docker.com/_/logstash/
  #docker run --name d-logstash -it -v "$PWD/logstash":/config-dir -d logstash logstash -f /config-dir/logstash.conf

  #https://hub.docker.com/_/elasticsearch/
  docker run --name d-elasticsearch --restart=always \
         -v "$PWD/elasticsearch/data":/usr/share/elasticsearch/data \
         -v /etc/localtime:/etc/localtime \
         -p 9200:9200 -p 9300:9300 -d elasticsearch

   #https://hub.docker.com/_/kibana/
   docker run --name d-kibana --restart=always \
         --link d-elasticsearch:elasticsearch \
         -v /etc/localtime:/etc/localtime \
         -p 5601:5601 -d kibana
}

start() {
        #docker start d-logstash
        docker start d-elasticsearch
        docker start d-kibana
}

stop() {
        #docker stop d-logstash
        docker stop d-kibana
        docker stop d-elasticsearch
}

destroy() {
        #docker rm d-logstash
        docker rm d-kibana
        docker rm d-elasticsearch
}

case "$1" in
    create)  create ;;
    destroy) destroy ;;
    start)   start ;;
    stop)    stop ;;
    restart) stop; start ;;
    *) echo "usage: $0 create|destroy|start|stop|restart" >&2
       exit 1
    ;;
esac

docker ps

