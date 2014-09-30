package fr.mowitnow

import spock.lang.Specification

/**
 * Position test
 * Created by guillaume on 30/09/2014.
 */
class PositionTest extends Specification {

    def "The position shouldn't be defined like this : null"() {
        when:
        Position.valueOf(null);

        then:
        thrown(NullPointerException)
    }

    def "The position shouldn't be defined like this : 1 g"() {
        when:
        Position.valueOf("1 g");

        then:
        thrown(IllegalArgumentException)
    }

    def "The position shouldn't be defined like this : 12"() {
        when:
        Position.valueOf("12");

        then:
        thrown(IllegalArgumentException)
    }

    def "The position should be defined like this : 1 2"() {
        when:
        def position = Position.valueOf("1 2");

        then:
        position.toString() == "1 2"
    }
}
