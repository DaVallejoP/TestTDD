package es.liquidsquad.katamarsrover.modelo

import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class RoverTest {
    private lateinit var sut:Rover
    private val TEST_X = 3
    private val TEST_Y = 2
    private val TEST_DEFAULT_DIR: Char = 'N'
    private val TEST_RIGTH = 'R'

    @Before
    fun setUp() {
        sut = Rover()
    }

    @After
    fun tearDown() {
    }


    @Test
    fun sutIsNotNil() {
        assertNotNull(sut)
    }

    @Test
    fun initialXPositionis_O() {
        //Arrange
        //Act
        //Assert
        assertEquals(0,Rover.DEFAULT_X)
    }

    @Test
    fun initialYPositionis_O() {
        //Arrange
        //Act
        //Assert
        assertEquals(0,Rover.DEFAULT_Y)
    }

    @Test
    fun initialRoverIsAtDefault_X() {
        //Arrange
        //Act
        //Assert
        assertEquals(Rover.DEFAULT_X,sut.x)

    }
    @Test
    fun initialRoverIsAtDefault_Y() {
        assertEquals(Rover.DEFAULT_Y,sut.y)

    }

    @Test
    fun initRoverWithYPersists() {
        //Arrange
        sut = Rover(y= TEST_Y)
        //Act
        //Assert
        assertEquals(TEST_Y,sut.y)
    }
    @Test
    fun initRoverWithXPersists() {
        //Arrange
        sut = Rover(x= TEST_X)
        //Act
        //Assert
        assertEquals(TEST_X,sut.x)
    }


    @Test
    fun defaultDirectionIsNorth() {
        //Arrange
        //Act
        //Assert
        assertEquals(TEST_DEFAULT_DIR,sut.defaultDirection)
    }
    @Test
    fun changeDirectionRigthModifiesDirection() {
        //Arrange
        //Act
        sut.applyCommand(command = TEST_RIGTH)
        //Assert
        assertEquals('E',sut.defaultDirection)
    }

}