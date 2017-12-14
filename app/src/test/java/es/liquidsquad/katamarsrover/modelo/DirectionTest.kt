package es.liquidsquad.katamarsrover.modelo

import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class DirectionTest {
    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun turnRigthFromNorthIsEast() {
        //Arrange
        var sut = Direction.NORTH
        assertEquals(Direction.EAST,sut.turnRigth())
        //Act
        //Assert

    }
}