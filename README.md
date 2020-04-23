# Docker-java-container

java -jar GenInvB.jar db_url db_username db_password output_dir invoice blb_invoice tail adx_db_scheme com.ds.geninvb.GenInvB.java

Example:

java -jar C:\\Users\\alvel\\Desktop\\GenInvoiceB.jar jdbc:oracle:thin:@192.168.20.210:1521:DB11G mprint d4t4 C:\\Users\\alvel\\Desktop\\ B0323859643 B0323859643 04201510 adxuat com.ds.geninvb.GenInvB.java


Run on host:


docker run -it --name geninvb -v /home/docker/csv:/work/csv --rm va/geninvb:latest java -jar /work/csv/GenInvoiceB.jar jdbc:oracle:thin:@pt2elpdb.mobiltel.bg:1521:p2elp mprint mprint /work/csv B0323962792 B0323962792 04201510 adxuat com.ds.geninvb.GenInvB.java