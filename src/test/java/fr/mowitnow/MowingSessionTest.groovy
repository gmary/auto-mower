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


}
