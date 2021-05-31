package com.example.testcratorspring.passed_test_answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PassedTestAnswerController {
    @Autowired
    private PassedTestAnswerService passedTestAnswerService;

    @RequestMapping(value = "/passedTestAnswers")
    public Iterable<PassedTestAnswer> getAllPost(){return passedTestAnswerService.getAllPassedTestAnswer();}

    @RequestMapping(value = "/passedTestAnswers/{Id}")
    public Optional<PassedTestAnswer> getPassedTestAnswer(@PathVariable String Id){
        return passedTestAnswerService.getPassedTestAnswer(Id);
    }

    @RequestMapping(value = "/passedTestAnswers", method = RequestMethod.POST)
    public void addPassedTestAnswer(@RequestBody PassedTestAnswer passedTestAnswer){
        passedTestAnswerService.addPassedTestAnswer(passedTestAnswer);
    }
    @RequestMapping(value = "/passedTestAnswers/{Id}" , method = RequestMethod.PUT)
    public void updatePassedTestAnswer(@PathVariable ("Id") String id,
                           @RequestBody PassedTestAnswer passedTestAnswer){
        passedTestAnswerService.addPassedTestAnswer(id, passedTestAnswer);
    }

    @RequestMapping(value = "/passedTestAnswers/{Id}", method = RequestMethod.DELETE)
    public void deletePassedTestAnswer(@PathVariable ("Id") String id){
        passedTestAnswerService.deletePassedTestAnswer(id);
    }
}
