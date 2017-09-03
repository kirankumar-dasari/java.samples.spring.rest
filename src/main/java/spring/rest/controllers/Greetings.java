package spring.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.rest.models.ErrorMessage;
import spring.rest.models.Greeting;
import spring.rest.models.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/v1/greetings", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class Greetings {
    //    @RequestMappin
    // @g(method = RequestMethod.GET)
    @GetMapping
    public Greeting hello() {
        return new Greeting("Hello..!");
    }

    //    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    @GetMapping(path = "/{name}")
    public Greeting hello(@PathVariable("name") String name) {
        return new Greeting("Hello..! " + name);
    }

    //    @RequestMapping(path = "/2", method = RequestMethod.GET)
    @GetMapping(path = "/2")
    public Greeting hello2(@RequestParam("name") String name) {
        return new Greeting("Hello..! " + name);
    }

    //    @RequestMapping(path = "/3", method = RequestMethod.GET)
    @GetMapping(path = "/3")
    public Greeting hello3(@RequestParam("name") String name, @RequestHeader("User-Agent") String userAgent) {
        return new Greeting("Hello..! " + name + ". Your User-Agent is " + userAgent);
    }

    //    @RequestMapping(path = "/{firstName}/{lastName}", method = RequestMethod.GET)
    @GetMapping(path = "/{firstName}/{lastName}")
    public ResponseEntity hello(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        return new ResponseEntity(new Greeting("Hello..! " + firstName + " " + lastName), HttpStatus.OK);
    }

    //    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity hello(@RequestBody Greeting greeting) {
        System.out.println(greeting);

        if (greeting.message.toLowerCase().contains("kiran")) {
            System.out.println("Error..");
            return new ResponseEntity(new ErrorMessage(greeting.message + " already existed!"), HttpStatus.CONFLICT);
        }

        return new ResponseEntity(new Id(UUID.randomUUID()), HttpStatus.CREATED);
    }

    //    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @GetMapping(path = "/all")
    public ResponseEntity all() {
        List<Greeting> greetings = new ArrayList();
        greetings.add(new Greeting("Hello"));
        greetings.add(new Greeting("Bye"));
        return new ResponseEntity(greetings, HttpStatus.OK);
    }

}
