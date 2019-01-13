## How to setup myprod in AWS

### DNS

Connect AWS Elastic ip IP to tibbes.com in namecheap.com

tibbes.com -> http://3.120.101.6/

https://ap.www.namecheap.com/domains/domaincontrolpanel/tibbes.com/advancedns

https://eu-central-1.console.aws.amazon.com/vpc/home?region=eu-central-1#Addresses:PublicIp=3.120.101.6;sort=PublicIp

### NGINX

./aws/deployaws.sh


### Lets encrypt
(start-certbot.sh can be run multiple times and will renew cert if needed but need to restart nginx I think)

(running certbot check on the first of every month)
crontab -e

0 0 1 * * /home/ec2-user/nginx/start-certbot.sh
0 1 1 * * /home/ec2-user/nginx/start-nginx.sh


