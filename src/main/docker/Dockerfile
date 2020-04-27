FROM openjdk:8
MAINTAINER wcj 723185985@qq.com
VOLUME /tmp
ADD littlenote-0.0.1-SNAPSHOT.jar little-note.jar
RUN bash -c 'touch /little-note.jar'
ENTRYPOINT ["java","-jar","/little-note.jar"]