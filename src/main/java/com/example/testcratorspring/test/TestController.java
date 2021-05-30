package com.example.testcratorspring.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping(value = "/tests")
    public Iterable<Test> getAllPost(){return testService.getAllTest();}

    @RequestMapping(value = "/tests/{Id}")
    public Optional<Test> getTest(@PathVariable String Id){
        return testService.getTest(Id);
    }

    @RequestMapping(value = "/tests", method = RequestMethod.POST)
    public void addTest(@RequestBody Test test){
        testService.addTest(test);
    }
    @RequestMapping(value = "/tests/{Id}" , method = RequestMethod.PUT)
    public void updateTest(@PathVariable ("Id") String id,
                           @RequestBody Test test){
        testService.addTest(id, test);
    }

    @RequestMapping(value = "/tests/{Id}", method = RequestMethod.DELETE)
    public void deleteTest(@PathVariable ("Id") String id){
        testService.deleteTest(id);
    }
}
