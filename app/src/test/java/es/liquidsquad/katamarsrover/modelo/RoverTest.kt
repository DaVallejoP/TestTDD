package es.liquidsquad.katamarsrover.modelo

import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class RoverTest {
    private lateinit var sut:Rover
    private val TEST_X = 3
    private val TEST_Y = 2
    val TEST_RIGTH = "R"
    val TEST_EAST = "L"

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
        assertEquals(Direction.NORTH,sut.direction)
    }


    @Test
    fun changeDirectionRigthPointsEast() {
        //Arrange
        //Act
        sut.applyCommand(command = TEST_RIGTH)
        //Assert
        assertEquals(Direction.EAST,sut.direction)
    }
    @Test
    fun changeDirectionRigthRigthPointsSouth() {
        //Arrange
        //Act
        sut.applyCommand(command = (TEST_RIGTH + TEST_RIGTH))
        //Assert
        assertEquals(Direction.SOUTH,sut.direction)
    }
    @Test
    fun changeDirectionRigthRigthRigthPointsWest() {
        //Arrange
        //Act
        sut.applyCommand(command = (TEST_RIGTH + TEST_RIGTH+ TEST_RIGTH))
        //Assert
        assertEquals(Direction.WEST,sut.direction)
    }
    @Test
    fun changeDirectionRigthRigthRigthRigthPointsNorth() {
        //Arrange
        //Act
        sut.applyCommand(command = (TEST_RIGTH + TEST_RIGTH+ TEST_RIGTH + TEST_RIGTH))
        //Assert
        assertEquals(Direction.NORTH,sut.direction)
    }
    @Test
    fun changeDirectionRigthFromEastPointsSouth() {
        //Arrange
        sut = Rover(direction= Direction.EAST)
        //Act
        sut.applyCommand(command =  TEST_RIGTH)
        //Assert
        assertEquals(Direction.SOUTH,sut.direction)
    }

}