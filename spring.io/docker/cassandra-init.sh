#!/usr/bin/env bash
(sleep 20 && cqlsh -e "create keyspace toer with replication={'class':'SimpleStrategy', 'replication_factor':1};")&
docker-entrypoint.sh
sleep 2
echo "hej"
