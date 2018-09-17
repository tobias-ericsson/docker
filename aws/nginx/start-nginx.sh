#!/usr/bin/env bash

docker stop nginx
docker rm nginx

cd ~/nginx/html
git pull
cd -

docker run --name nginx -d --network="host" --read-only \
  -v $(pwd)/nginx-cache:/var/cache/nginx \
  -v $(pwd)/nginx-pid:/var/run \
  -v $(pwd)/nginx.conf:/etc/nginx/nginx.conf \
  -v $(pwd)/html:/etc/nginx/html \
  nginx:alpine
