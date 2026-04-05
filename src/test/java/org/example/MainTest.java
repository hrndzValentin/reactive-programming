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

}