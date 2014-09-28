package fr.mowitnow

import spock.lang.Specification

/**
 * Created by guillaume on 25/09/2014.
 */
class LawnTest extends Specification {
    def "The lawn should have the coordinate equals to 0 and axis equals to 0 on the bottom left corner"() {
        when:
        Lawn rectangle = new Lawn(2,3);

        then:
        rectangle.bottomLeftCorner.x == 0;
        rectangle.bottomLeftCorner.y == 0;
    }

    def "The lawn should have the coordinate and axis equals to the width and height on the top right corner"() {
        expect:
        new Lawn(x,y).topRightCorner == new Position(x,y)

        where:
        x << [1, 2]
        y << [4, 5]
    }

    def "The lawn shouldn't have a negative width"() {
        when:
        new Lawn(-3,5)

        then:
        thrown(IllegalArgumentException)
    }

    def "The lawn shouldn't have a negative height"() {
        when:
        new Lawn(5,-5)

        then:
        thrown(IllegalArgumentException)
    }
}
