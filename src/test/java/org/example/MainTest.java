package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private static Main mainVar;


    @BeforeAll
    static void setup(){
        mainVar = new Main();
    }

    @Test
    void fluxNamesTest(){
        var names = mainVar.fluxNames();
        StepVerifier.create(names)
                .expectNext("valentin","luana","anibal")
                .verifyComplete();
    }

    @Test
    void monoNamesTest(){
        var names = mainVar.monoName();
        StepVerifier.create(names)
                .expectNext("Valentin")
                .verifyComplete();
    }

    @Test
    void namesMono_map_filter() {
        //given
        var strLength = 3;
        //when
        var monoName = mainVar.namesMono_map_filter(strLength);

        //then
        StepVerifier.create(monoName)
                .expectNext("VALENTIN")
                .verifyComplete();
    }

    @Test
    void explore_concatwith() {
        //given
        //when
        var firstOperator = mainVar.explore_concatwith();
        //then
        StepVerifier.create(firstOperator)
                .expectNext("A","B","C","D","E","F")
                .verifyComplete();
    }

    @Test
    void explore_concatwith_mono() {
        //given
        //when
        var firstOperator = mainVar.explore_concatwith_mono();
        //then
        StepVerifier.create(firstOperator)
                .expectNext("A","B")
                .verifyComplete();
    }

    @Test
    public void explore_merge(){
        //given
        //when
        var value = mainVar.explore_merge();
        //then
        StepVerifier.create(value)
                .expectNext("A","D","B","E","C","F")
                .verifyComplete();

    }

    @Test
    public void explore_mergeWith(){
        //given
        //when
        var value = mainVar.explore_mergeWith();
        //then
        StepVerifier.create(value)
                .expectNext("A","D","B","E","C","F")
                .verifyComplete();

    }


    @Test
    void explore_mergeWithMono() {
        //given
        //when
        var value = mainVar.explore_mergeWithMono();
        //then
        StepVerifier.create(value)
                .expectNext("A","B")
                .verifyComplete();
    }
}