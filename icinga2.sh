#https://hub.docker.com/r/icinga/icinga2/


docker run -ti --name icinga2 -p 80:80 icinga/icinga2
#docker run -d -ti --name icinga2-api -p 80:80 -p 4665:5665 icinga/icinga2
