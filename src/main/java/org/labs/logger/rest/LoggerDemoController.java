package org.labs.logger.rest;

import org.labs.logger.factory.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoggerDemoController {

    private static final LoggerFactory LOGGER = LoggerFactory.getLogger();

    @GetMapping(value="/log", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<Object> loggerTest(@RequestParam("q") String q){
        Map<String, String> response = new HashMap<>();
        try{
            LOGGER.info("started");
            response.put("message","normal flow of the application");
            if(q.equalsIgnoreCase("exception")){
                throw new RuntimeException("Testing the exception logging mechanism");
            }
            LOGGER.info("before sending response");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            LOGGER.error("Exception" + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }


}

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//public class LoggerDemoController {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerDemoController.class);
//
//    @GetMapping(value = "/log", consumes = MediaType.ALL_VALUE)
//    public ResponseEntity<Object> loggerTest(@RequestParam("q") String q){
//        Map<String, String> response = new HashMap<>();
//        try {
//            LOGGER.info("started...");
//            response.put("message", "normal flow of the application");
//            if(q.equalsIgnoreCase("exception")){
//                throw new RuntimeException("Testing the exception logging mechanism");
//            }
//            LOGGER.info("before sending response");
//            LOGGER.trace("response: "+ response);
//            return ResponseEntity.ok(response);
//        }catch (Exception ex){
//            LOGGER.error("Exception: "+ex.getMessage());
//            return ResponseEntity.internalServerError().build();
//        }
//    }
//}
