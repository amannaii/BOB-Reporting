package com.sqli.client.rte.bob.reporting;

import static java.lang.System.exit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sqli.client.rte.bob.reporting.dao.CallProgramRepository;
import com.sqli.client.rte.bob.reporting.dao.ChronicleRepository;
import com.sqli.client.rte.bob.reporting.dao.PointRepository;
import com.sqli.client.rte.bob.reporting.model.CallProgram;
import com.sqli.client.rte.bob.reporting.model.Chronicle;
import com.sqli.client.rte.bob.reporting.model.Point;

@SpringBootApplication
public class BobReportingApplication implements CommandLineRunner {


    @Autowired
    DataSource dataSource;
   
    @Autowired
    CallProgramRepository callProgramRepository;
    
//    @Autowired
//    ChronicleRepository chronicleRepository;
//    
//    @Autowired
//    PointRepository pointRepository;
    
	public static void main(String[] args) {
		SpringApplication.run(BobReportingApplication.class, args);
	}
	
    @Override
    public void run(String... args) throws Exception {

        System.out.println("DATASOURCE = " + dataSource);

        System.out.println("\n1.PROGRAMME D APPEL...");
        for (CallProgram callProgram : callProgramRepository.findAll()) {
            System.out.println(callProgram.getPa_sender_name());
        }
//        System.out.println("\n1.CHRONICLE...");
//        for (Chronicle Chronicle : chronicleRepository.findAll()) {
//            System.out.println(Chronicle.getPac_mrid());
//        }
//        System.out.println("\n1.POINT...");
//        for (Point point : pointRepository.findAll()) {
//            System.out.println(point.getPosition());
//        }
        System.out.println("Done!");

       // exit(0);
    }
}
