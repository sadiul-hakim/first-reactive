package xyz.sadiulhakim.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;

    public Mono<Student> save(Student student) {
        return studentRepo.save(student);
    }

    public Flux<Student> findAll() {
        return studentRepo.findAll()
                .delayElements(Duration.ofSeconds(1));
    }

    public Flux<Student> findAllByFirstname(String firstname) {
        return studentRepo.findAllByFirstname(firstname);
    }

    public Mono<Student> findById(int id) {
        return studentRepo.findById(id);
    }
}
