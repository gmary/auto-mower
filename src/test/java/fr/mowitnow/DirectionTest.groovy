package fr.mowitnow

import spock.lang.Specification

/**
 * Direction test
 * Created by guillaume on 29/09/2014.
 */
class DirectionTest extends Specification {
    def "The direction should turn on left in this order N -> W -> S -> E -> N"() {
        expect:
        Direction.N.turnLeft() == Direction.W;
        Direction.N.turnLeft().turnLeft() == Direction.S;
        Direction.N.turnLeft().turnLeft().turnLeft() == Direction.E;
        Direction.N.turnLeft().turnLeft().turnLeft().turnLeft() == Direction.N;
    }

    def "The direction should turn on right in this order N -> E -> S -> W -> N"() {
        expect:
        Direction.N.turnRight() == Direction.E;
        Direction.N.turnRight().turnRight() == Direction.S;
        Direction.N.turnRight().turnRight().turnRight() == Direction.W;
        Direction.N.turnRight().turnRight().turnRight().turnRight() == Direction.N;
    }
}
