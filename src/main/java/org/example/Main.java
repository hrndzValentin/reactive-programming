package org.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public Flux<String> fluxNames(){
        return Flux.fromIterable(List.of("valentin","luana","anibal"));
    }

    public Mono<String> monoName(){
        return Mono.just("Valentin");
    }
    public static void main(String[] args) {
        Main myMain = new Main();
        myMain.fluxNames()
                .subscribe(System.out::println);
        myMain.monoName()
                .subscribe(System.out::println);
    }
}