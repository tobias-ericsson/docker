#!/bin/sh
#https://docs.docker.com/engine/installation/linux/centos/
sudo yum -y update

sudo tee /etc/yum.repos.d/docker.repo <<-'EOF'
[dockerrepo]
name=Docker Repository
baseurl=https://yum.dockerproject.org/repo/main/centos/7/
enabled=1
gpgcheck=1
gpgkey=https://yum.dockerproject.org/gpg
EOF

sudo yum -y install docker-engine

sudo service docker start

sudo docker run hello-world

sudo groupadd docker

echo "Consider running the following"
echo "sudo usermod -aG docker your_username"

sudo chkconfig docker on
