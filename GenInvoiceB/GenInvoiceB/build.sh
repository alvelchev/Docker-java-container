#!/bin/bash
IMAGE_NAME=va/geninvb3

docker build -t $IMAGE_NAME .

if [ $? -ne 0 ]
then
    echo "Build failed!"
else
    echo "GenInvoiceB docker image has been built. This image is for the CD module - for dymanic generation of large invoices!"
    echo "To start a new test container, execute: docker run -it --name geninvb -v /home/docker/csv:/work/csv --rm va/geninvb:latest java -jar /work/GenInvoiceB.jar jdbc:oracle:thin:@pt2elpdb.mobiltel.bg:1521:p2elp mprint mprint /work/csv B0323859643 B0323859643 04201510 adxuat"
fi
