package xyz.sadiulhakim.customer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomController {
    private final ReactiveMongoTemplate mongoTemplate;

    @PostMapping("/")
    public Mono<Customer> save(@RequestBody Customer customer) {
        return mongoTemplate.save(customer);
    }

    @GetMapping("/all")
    public Flux<Customer> findAll() {
        return mongoTemplate.findAll(Customer.class)
                .log();
    }

//    @GetMapping("/{id}")
//    public Mono<Customer> findById(@PathVariable int id){
//        return mongoTemplate.findById(id, Customer.class);
//    }

    @GetMapping("/{id}")
    public Mono<Customer> findById(@PathVariable int id) {
        Criteria criteria = Criteria.where("id").is(id);
        Query query = Query.query(criteria);
        return mongoTemplate.findOne(query, Customer.class);
    }
}
