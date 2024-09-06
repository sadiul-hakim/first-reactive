package xyz.sadiulhakim;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        doSomething().subscribe(System.out::println);
    }

    private static Flux<Integer> doSomething() {
        return Flux.range(1, 10)
                .map(num -> {
                    if (num == 5) {
                        throw new RuntimeException("This is 5");
                    }

                    return num;
                }).onErrorResume(throwable -> Mono.just(5));
    }

    private static Flux<List<Integer>> textFlux() {
        return Flux.range(1, 1_000)
                .delayElements(Duration.ofMillis(20))
                .buffer(Duration.ofMillis(10));
    }

    private static Mono<String> testString() {
        return Mono.just("Hakim")
                .log();
    }
}

/**
 * Mono.just()
 * Flux.just()
 * delayElements()
 * Flux.range()
 * subscribe()
 * map()
 * flatMap()
 * collect()
 * collectList()
 * concat()
 * merge()
 * zip()
 * buffer()
 * skip()
 * collectMap()
 * doOnEach()
 * doOnComplete()
 * doOnNext()
 * doOnCancel()
 * doOnError()
 * onErrorContinue()
 * onErrorReturn()
 * onErrorResume()
 * onErrorMap()
 */
