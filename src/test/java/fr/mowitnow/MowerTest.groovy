package fr.mowitnow

import spock.lang.Specification

/**
 * Created by guillaume on 29/09/2014.
 */
class MowerTest extends Specification {

    def "The mower should be located on a lawn"() {
        setup:
        def initialLocation = new Location(new Position(1, 2), Direction.N);
        def lawn = new Lawn(5, 5);
        def mower = new Mower(lawn, initialLocation);

        expect:
        mower.location == initialLocation
        mower.lawn == lawn
    }


    def "The mower should accept only three orders : A,G,D"() {
        setup:
        def initialLocation = new Location(new Position(1, 2), Direction.N);
        def lawn = new Lawn(5, 5)
        def mower = new Mower(lawn, initialLocation);

        when:
        mower.move("AGJG")

        then:
        thrown(IllegalArgumentException)
    }

    def "On the G order, the mower should change his direction to the left"() {
        setup:
        def initialLocation = new Location(new Position(1, 2), Direction.N);
        def lawn = new Lawn(5, 5)
        def mower = new Mower(lawn, initialLocation);

        expect:
        mower.move("G").location == new Location(new Position(1, 2), Direction.W);
        mower.move("GG").location == new Location(new Position(1, 2), Direction.S);
        mower.move("GGG").location == new Location(new Position(1, 2), Direction.E);
        mower.move("GGGG").location == new Location(new Position(1, 2), Direction.N);
    }

    def "On the D order, the mower should change his direction to the right"() {
        setup:
        def initialLocation = new Location(new Position(1, 2), Direction.N);
        def lawn = new Lawn(5, 5)
        def mower = new Mower(lawn, initialLocation);

        expect:
        mower.move("D").location == new Location(new Position(1, 2), Direction.E);
        mower.move("DD").location == new Location(new Position(1, 2), Direction.S);
        mower.move("DDD").location == new Location(new Position(1, 2), Direction.W);
        mower.move("DDDD").location == new Location(new Position(1, 2), Direction.N);
    }

    def "On the A order, the mower should move forward according to his original direction"() {
        setup:
        def lawn = new Lawn(5, 5)

        expect:
        new Mower(lawn, new Location(new Position(1, 2), Direction.N)).move("A").location == new Location(new Position(1, 3), Direction.N);
        new Mower(lawn, new Location(new Position(1, 2), Direction.E)).move("A").location == new Location(new Position(2, 2), Direction.E);
        new Mower(lawn, new Location(new Position(1, 2), Direction.S)).move("A").location == new Location(new Position(1, 1), Direction.S);
        new Mower(lawn, new Location(new Position(1, 2), Direction.W)).move("A").location == new Location(new Position(0, 2), Direction.W);
        new Mower(lawn, new Location(new Position(1, 2), Direction.N)).move("AAA").location == new Location(new Position(1, 5), Direction.N);
    }
}
