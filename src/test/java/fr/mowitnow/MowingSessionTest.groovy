package fr.mowitnow

import spock.lang.Specification

/**
 * Created by guillaume on 28/09/2014.
 */
class MowingSessionTest extends Specification {

    def "The mowing session should start with a lawn defined like this : 5 5"() {
        when:
        def mowingSession = new MowingSession("5 5");

        then:
        mowingSession.lawn.toString() == "5 5";
    }

    def "The mowing session should start with a lawn defined like this : 15 50"() {
        when:
        def mowingSession = new MowingSession("15 50");

        then:
        mowingSession.lawn.toString() == "15 50";
    }

    def "The mowing session shouldn't start with an empty lawn"() {
        when:
        new MowingSession(null);

        then:
        thrown(NullPointerException)
    }

    def "The mowing session start with a lawn : 1 2 3 should fail"() {
        when:
        new MowingSession("1 2 3");

        then:
        thrown(IllegalArgumentException)
    }

    def "The mowing session start with a lawn : 4 X should fail"() {
        when:
        new MowingSession("4 X");

        then:
        thrown(IllegalArgumentException)
    }

    def "The mowing session start with a lawn : 45 should fail"() {
        when:
        new MowingSession("45");

        then:
        thrown(IllegalArgumentException)
    }

    def "We could add a mower to the mowing session with specified position and direction on the lawn like this 1 2 N"() {
        setup:
        def mowingSession = new MowingSession("5 5");
        def initMowerLocation = "1 2 N"

        when:
        def mower = mowingSession.addMower(initMowerLocation);

        then:
        mower.location.toString() == initMowerLocation;
    }

    def "Final test"() {
        setup: "Add two mower on the lawn 5 5, mower1:1 2 N, mower2: 3 3 E"
        def mowingSession = new MowingSession("5 5");
        def mower1 = mowingSession.addMower("1 2 N");
        def mower2 = mowingSession.addMower("3 3 E");

        when: "Move the mowers : mower1:GAGAGAGAA, mower2:AADAADADDA"
        mower1 = mower1.move("GAGAGAGAA");
        mower2 = mower2.move("AADAADADDA")

        then: "Expected locations : mower1:1 3 N, mower2: 5 1 E"
        mower1.location.toString() == "1 3 N";
        mower2.location.toString() == "5 1 E";
    }
}
