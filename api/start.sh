#!/usr/bin/env bash

mvn clean

mvn package

java -jar /api/target/Spring-boot-1.8.jar