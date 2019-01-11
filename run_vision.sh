#!/usr/bin/env bash
cd /srv/vision
JAR=`ls | grep vision*.jar`
java -Djava.library.path="/srv/vision/natives" -jar ${JAR} &
