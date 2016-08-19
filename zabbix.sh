#https://hub.docker.com/r/monitoringartist/zabbix-3.0-xxl/

#create /var/lib/mysql as persistent volume storage
docker run -d -v /var/lib/mysql --name zabbix-db-storage busybox:latest

# start DB for Zabbix - default 1GB innodb_buffer_pool_size is used
docker run \
    -d \
    --name zabbix-db \
    -v /backups:/backups \
    -v /etc/localtime:/etc/localtime:ro \
    --volumes-from zabbix-db-storage \
    --env="MARIADB_USER=zabbix" \
    --env="MARIADB_PASS=my_password" \
    monitoringartist/zabbix-db-mariadb

# start Zabbix linked to started DB
docker run \
    -d \
    --name zabbix \
    -p 80:80 \
    -p 10051:10051 \
    -v /etc/localtime:/etc/localtime:ro \
    --link zabbix-db:zabbix.db \
    --env="ZS_DBHost=zabbix.db" \
    --env="ZS_DBUser=zabbix" \
    --env="ZS_DBPassword=my_password" \
    monitoringartist/zabbix-3.0-xxl:latest
# wait ~60 seconds for Zabbix initialization
# Zabbix web will be available on the port 80, Zabbix server on the port 10051
