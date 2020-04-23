/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;


/**
 *
 * @author alvel
 */
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.Bind;
import com.github.dockerjava.api.model.Volume;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.command.WaitContainerResultCallback;
public class TestDockerr {

    /**
     * @param args the command line arguments
     */
          public final static String WORK_DIR = "/work/csv";
         private static final String DOCKER_CMD_2 = "/work/GenInvoiceB.jar";
        
        public final static String FILEPATH = "C:/Printing/";
         private static final String DOCKER_CMD_1 = "java -jar C:/Users/alvel/Desktop/GenInvoiceB.jar jdbc:oracle:thin:@192.168.20.210:1521:DB11G mprint d4t4 C:/Users/alvel/Desktop/ B0323859643 B0323859643 04201510 adxuat com.ds.geninvb.GenInvB.java";
    public static void main(String[] args) {
         
       
       String dbUrl = "jdbc:oracle:thin:@192.168.20.210:1521:DB11G";
       String dbUsername = "mprint";
       String dbPassword = "d4t4";
       String docker_host="tcp://localhost:2375";
       String invoice="B0323859643";
        String blbInvoice="B0323859643";
        String tail="04201510";
        String dbScheme="adxuat";
        
        
        
            DockerClient dockerClient = DockerClientBuilder.getInstance(docker_host).build();
           
            Volume volume1 = new Volume(WORK_DIR);

            CreateContainerResponse container = dockerClient.createContainerCmd("va/geninvb3:latest")
                    .withName(invoice)
                    .withVolumes(volume1)
                    .withBinds(new Bind(FILEPATH, volume1))
                    .withCmd("java", "-jar", DOCKER_CMD_2, dbUrl, dbUsername, dbPassword, WORK_DIR, invoice, blbInvoice, tail, dbScheme) 
                    .exec();
          
            dockerClient.startContainerCmd(container.getId()).exec();

            int exitCode = dockerClient.waitContainerCmd(container.getId()).exec(new WaitContainerResultCallback())
                    .awaitStatusCode();
            
            System.out.println(exitCode);

            dockerClient.removeContainerCmd(container.getId()).withForce(Boolean.TRUE).exec();
         
//            {"message":"json: cannot unmarshal object into Go struct field ContainerConfigWrapper.Binds of type string"}
              
        
    }
    
}



