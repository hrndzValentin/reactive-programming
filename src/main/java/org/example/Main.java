package org.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Main myMain = new Main();
        myMain.fluxNames()
                .subscribe(System.out::println);
        myMain.monoName()

                .subscribe(System.out::println);


    }
    public Flux<String> fluxNames(){
        return Flux.fromIterable(List.of("valentin","luana","anibal"));
    }

    public Mono<String> monoName(){
        return Mono.just("Valentin");
    }

    public Mono<String> namesMono_map_filter(int stringLength){
        return Mono.just("valentin")
                .map(String::toUpperCase)
                .filter(name -> name.length()>stringLength)
                .defaultIfEmpty("default")
                .log();
    }

    public Mono<String> namesMono_map_filter_switchIfEmpty(int stringLength){
        return Mono.just("valentin")
                .map(String::toUpperCase)
                .filter(name -> name.length()>stringLength)
                .switchIfEmpty(Mono.just("default"))
                .log();
    }

    public Flux<String> explore_concatwith(){
        var abcFlux = Flux.just("A","B","C");
        var defFlux = Flux.just("D","E","F");
        return Flux.concat(abcFlux,defFlux).log();
    }

    public Flux<String> explore_concatwith_mono(){
        var abcFlux = Mono.just("A");
        var defFlux = Mono.just("B");
        return abcFlux.concatWith(defFlux).log();
    }


    public Flux<String> explore_merge(){
        var abcFlux = Flux.just("A","B","C")
                .delayElements(Duration.ofMillis(100));
        var defFlux = Flux.just("D","E","F")
                .delayElements(Duration.ofMillis(200));
        return Flux.merge(abcFlux,defFlux).log();
    }
    public Flux<String> explore_mergeWith(){
        var abcFlux = Flux.just("A","B","C")
                .delayElements(Duration.ofMillis(100));
        var defFlux = Flux.just("D","E","F")
                .delayElements(Duration.ofMillis(125));
        return abcFlux.mergeWith(defFlux).log();
    }

    public Flux<String> explore_mergeWithMono(){
        var aMono = Mono.just("A")
                .delayElement(Duration.ofMillis(100));
        var bMono = Mono.just("B")
                .delayElement(Duration.ofMillis(125));
        return aMono.mergeWith(bMono).log();
    }
}