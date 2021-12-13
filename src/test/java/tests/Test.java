package tests;

import Utils.UppercaseConverter;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

class Test {
    final TestPublisher<String> testPublisher = TestPublisher.create();
    @org.junit.jupiter.api.Test
    void testUpperCase() {
        UppercaseConverter uppercaseConverter = new UppercaseConverter(testPublisher.flux());
        StepVerifier.create(uppercaseConverter.getUpperCase())
                .then(() -> testPublisher.emit("datos", "GeNeRaDoS", "Sofka"))
                .expectNext("DATOS", "GENERADOS", "SOFKA")
                .verifyComplete();
    }
}
