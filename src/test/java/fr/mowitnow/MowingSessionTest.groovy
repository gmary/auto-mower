package fr.mowitnow

import spock.lang.Specification

/**
 * Created by guillaume on 28/09/2014.
 */
class MowingSessionTest extends Specification {

    def "The mowing session should have a lawn with a specified width and height"() {
        when:
        def mowingSession = new MowingSession(new Lawn(5,5));

        then:
        mowingSession.lawn == new Lawn(5,5);
    }

    def "We could add a mower to the mowing session with specified position and direction on the lawn"() {
        setup:
        def mowingSession = new MowingSession(new Lawn(5,5));
        def initMowerLocation = new Location(new Position(1,2),Direction.N)

        when:
        def mower = mowingSession.addMower(initMowerLocation);

        then:
        mower.location == initMowerLocation;
    }

    def "Test"() {
        setup:
        def mowingSession = new MowingSession(new Lawn(5, 5));
        def mower1 = mowingSession.addMower(new Location(new Position(1, 2), Direction.N));
        def mower2 = mowingSession.addMower(new Location(new Position(3, 3), Direction.E));

        when:
        mower1 = mower1.move("GAGAGAGAA");
        mower2 = mower2.move("AADAADADDA")

        then:
        mower1.location == new Location(new Position(1, 3), Direction.N);
        mower2.location == new Location(new Position(5, 1), Direction.E);
    }
}
