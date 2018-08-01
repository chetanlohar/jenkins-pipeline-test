package io.brainstorm.jenkinspipelinetest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chetan on 01/08/18.
 */
@RestController
@RequestMapping("rest")
public class TestController {

    @Autowired
    TestService service;

    @RequestMapping(value = {"/test"},method = RequestMethod.GET)
    public ResponseEntity<?> testAPI(){
        String data = service.getData();
        Map<String,String> m = new HashMap();
        m.put("data",data);
        System.out.println("sout: >> "+data);
        return new ResponseEntity<>(m, HttpStatus.OK);
    }
}
