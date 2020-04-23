FROM realsoft/alpine-java:8
MAINTAINER Vasil Angelov

RUN mkdir /work
RUN mkdir /work/csv
COPY GenInvoiceB.jar /work/GenInvoiceB.jar

#VOLUME /home/docker/jobs/cd:/work/csv

WORKDIR /work/csv/

CMD ["java","-jar","/work/GenInvoiceB.jar"]
#CMD ["/bin/sh"]