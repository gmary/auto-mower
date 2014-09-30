package fr.mowitnow

import spock.lang.Specification

/**
 * Location test
 * Created by guillaume on 30/09/2014.
 */
class LocationTest extends Specification {

    def "The location shouldn't be defined like this : null"() {
        when:
        Location.valueOf(null);

        then:
        thrown(NullPointerException)
    }

    def "The location shouldn't be defined like this : 1 2 X"() {
        when:
        Location.valueOf("1 2 X");

        then:
        thrown(IllegalArgumentException)
    }

    def "The location shouldn't be defined like this : 1 2 NN"() {
        when:
        Location.valueOf("1 2 NN");

        then:
        thrown(IllegalArgumentException)
    }

    def "The location should be defined like this : 1 2 N"() {
        when:
        def location = Location.valueOf("1 2 N");

        then:
        location.toString() == "1 2 N"
    }
}
