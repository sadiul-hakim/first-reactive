package xyz.sadiulhakim.student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @PostMapping("/")
    public Mono<Student> save(@RequestBody Student student) {
        return service.save(student);
    }

    @GetMapping("/")
    public Flux<Student> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Student> findById(@PathVariable int id) {
        return service.findById(id);
    }

    @GetMapping("/find-all-by-name/{firstname}")
    public Flux<Student> findById(@PathVariable String firstname) {
        return service.findAllByFirstname(firstname);
    }
}
