## How to setup myprod in AWS

### DNS

Connect AWS Elastic ip IP to tibbes.com in namecheap.com

tibbes.com -> http://3.120.101.6/

https://ap.www.namecheap.com/domains/domaincontrolpanel/tibbes.com/advancedns

https://eu-central-1.console.aws.amazon.com/vpc/home?region=eu-central-1#Addresses:PublicIp=3.120.101.6;sort=PublicIp

### NGINX

./aws/deployaws.sh