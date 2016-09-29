#!/bin/sh
#https://www.nginx.com/blog/deploying-nginx-nginx-plus-docker/
docker run --name nginx \
   -v /etc/localtime:/etc/localtime \
   -v $PWD/nginx/html:/usr/share/nginx/html:ro \
   -p 80:80 -p 443:443 -d nginx 

docker ps
#for external config add:
#-v $PWD/nginx/conf:/etc/nginx:ro \
