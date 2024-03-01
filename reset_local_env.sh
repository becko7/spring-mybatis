#! /bin/bash

echo "CREATE DATABASE test;" > ./init.sql

docker-compose stop && \
  docker-compose rm -f && \
  docker-compose pull && \
  docker-compose up -d
