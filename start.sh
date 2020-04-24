#!/usr/bin/env bash

mvn clean package && mvn docker:build

#去docker-compose目录
cd src/main/docker-compose

#启动智慧电务服务
docker-compose up -d -f  docker-compose.yml