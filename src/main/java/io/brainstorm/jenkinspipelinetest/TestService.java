package io.brainstorm.jenkinspipelinetest;

import org.springframework.stereotype.Service;

/**
 * Created by chetan on 01/08/18.
 */
@Service
public class TestService {

    public String getData(){
        return "Jenking Pipeline Test!";
    }

    public Integer add(Integer a,Integer b)
    {
        return a+b;
    }
}
