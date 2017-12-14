package es.liquidsquad.katamarsrover.modelo

import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class RoverTest {
    private lateinit var sut:Rover
    private val TEST_X = 3
    private val TEST_Y = 2
    private val TEST_DIR_NORTH: Char = 'N'
    private val TEST_DIR_SOUTH: Char = 'S'
    private val TEST_DIR_EAST: Char = 'E'
    private val TEST_DIR_WEST: Char = 'W'
    private val TEST_RIGTH = "R"
    private val TEST_LEFT = "L"

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
        assertEquals(TEST_DIR_NORTH,sut.direction)
    }
    @Test
    fun changeDirectionRigthPointsEast() {
        //Arrange
        //Act
        sut.applyCommand(command = TEST_RIGTH)
        //Assert
        assertEquals('E',sut.direction)
    }
    @Test
    fun changeDirectionRigthRigthPointsSouth() {
        //Arrange
        //Act
        sut.applyCommand(command = (TEST_RIGTH + TEST_RIGTH))
        //Assert
        assertEquals('S',sut.direction)
    }
    @Test
    fun changeDirectionRigthRigthRigthPointsWest() {
        //Arrange
        //Act
        sut.applyCommand(command = (TEST_RIGTH + TEST_RIGTH+ TEST_RIGTH))
        //Assert
        assertEquals('W',sut.direction)
    }
    @Test
    fun changeDirectionRigthRigthRigthRigthPointsNorth() {
        //Arrange
        //Act
        sut.applyCommand(command = (TEST_RIGTH + TEST_RIGTH+ TEST_RIGTH + TEST_RIGTH))
        //Assert
        assertEquals('N',sut.direction)
    }
    @Test
    fun changeDirectionRigthFromEastPointsSouth() {
        //Arrange
        sut = Rover(direction= TEST_DIR_EAST)
        //Act
        sut.applyCommand(command =  TEST_RIGTH)
        //Assert
        assertEquals('S',sut.direction)
    }

}