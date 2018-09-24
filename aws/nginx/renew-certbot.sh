#!/usr/bin/env bash

sudo docker run -it --rm \
-v $(pwd)/letsencrypt:/etc/letsencrypt \
-v $(pwd)/html:/data/letsencrypt \
certbot/certbot \
renew --webroot \
--email t.ericsson@gmail.com --agree-tos --no-eff-email \
--webroot-path=/data/letsencrypt \
-d tibbes.com -d www.tibbes.com

#--register-unsafely-without-email --agree-tos \
#--webroot-path=/data/letsencrypt \
#--staging \
#-d tibbes.com -d www.tibbes.com
#-d week.tibbes.com -d veckogott.tibbes.com -d seawind.tibbes.com