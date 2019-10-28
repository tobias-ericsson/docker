#!/usr/bin/env bash

docker stop nginx
docker rm nginx

cd $(pwd)/html
git pull
cd -

docker run --name nginx -d --network="host" --read-only \
  -v $(pwd)/nginx-cache:/var/cache/nginx \
  -v $(pwd)/nginx-pid:/var/run \
  -v $(pwd)/nginx.conf:/etc/nginx/nginx.conf \
  -v $(pwd)/html:/etc/nginx/html \
  -v $(pwd)/letsencrypt/live/tibbes.com/fullchain.pem:/etc/letsencrypt/live/tibbes.com/fullchain.pem \
  -v $(pwd)/letsencrypt/live/tibbes.com/privkey.pem:/etc/letsencrypt/live/tibbes.com/privkey.pem \
  -v $(pwd)/dhparam-2048.pem:/etc/ssl/certs/dhparam-2048.pem \
  nginx:alpine
