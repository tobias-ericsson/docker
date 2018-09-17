#!/usr/bin/env bash
host='ec2-user@tibbes.com'

scp -r nginx ${host}:~/.
ssh $host "cd nginx;pwd;./start-nginx.sh"