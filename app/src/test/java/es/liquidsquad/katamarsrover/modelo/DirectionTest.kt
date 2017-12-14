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
        //Act
        //Assert
        assertEquals(Direction.EAST,sut.turnRigth())
    }
    @Test
    fun turnRigthFromEastIsSouth() {
        //Arrange
        var sut = Direction.EAST
        //Act
        //Assert
        assertEquals(Direction.SOUTH,sut.turnRigth())
    }
    @Test
    fun turnRigthFroMSouthIsWest() {
        //Arrange
        var sut = Direction.SOUTH
        //Act
        //Assert
        assertEquals(Direction.WEST,sut.turnRigth())
    }
    @Test
    fun turnRigthFromWestIsNorth() {
        //Arrange
        var sut = Direction.WEST
        //Act
        //Assert
        assertEquals(Direction.NORTH,sut.turnRigth())
    }
    @Test
    fun turnLeftFromNorthIsWest() {
        //Arrange
        var sut = Direction.NORTH
        //Act
        //Assert
        assertEquals(Direction.WEST,sut.turnLeft())
    }
    @Test
    fun turnLeftFromEastIsSouth() {
        //Arrange
        var sut = Direction.WEST
        //Act
        //Assert
        assertEquals(Direction.SOUTH,sut.turnLeft())
    }
    @Test
    fun turnLeftFromSouthIsEast() {
        //Arrange
        var sut = Direction.SOUTH
        //Act
        //Assert
        assertEquals(Direction.EAST,sut.turnLeft())
    }
    @Test
    fun turnLeftFroEastIsNorth() {
        //Arrange
        var sut = Direction.WEST
        //Act
        //Assert
        assertEquals(Direction.SOUTH,sut.turnLeft())
    }
}