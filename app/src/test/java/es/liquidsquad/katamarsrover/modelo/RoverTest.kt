package es.liquidsquad.katamarsrover.modelo

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class RoverTest {
    private lateinit var sut: Rover
    private val TEST_X = 3
    private val TEST_Y = 2
    val TEST_RIGTH = "R"
    val TEST_EAST = "L"

    class DirectionMock(val expectedDirection: Direction = Direction.NORTH) : IDirection {
        var trcalled = false
        var tlcalled = false
        override fun turnRigth(): Direction {
            trcalled = true
            return expectedDirection
        }

        override fun turnLeft(): Direction {
            tlcalled = true
            return expectedDirection
        }
    }

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
        assertEquals(0, Rover.DEFAULT_X)
    }

    @Test
    fun initialYPositionis_O() {
        //Arrange
        //Act
        //Assert
        assertEquals(0, Rover.DEFAULT_Y)
    }

    @Test
    fun initialRoverIsAtDefault_X() {
        //Arrange
        //Act
        //Assert
        assertEquals(Rover.DEFAULT_X, sut.x)
    }
    @Test
    fun initialRoverIsAtDefault_Y() {
        assertEquals(Rover.DEFAULT_Y, sut.y)
    }

    @Test
    fun initRoverWithYPersists() {
        //Arrange
        sut = Rover(y = TEST_Y)
        //Act
        //Assert
        assertEquals(TEST_Y, sut.y)
    }
    @Test
    fun initRoverWithXPersists() {
        //Arrange
        sut = Rover(x = TEST_X)
        //Act
        //Assert
        assertEquals(TEST_X, sut.x)
    }

    @Test
    fun defaultDirectionIsNorth() {
        //Arrange
        //Act
        //Assert
        assertEquals(Direction.NORTH, sut.direction)
    }

    @Test
    fun changeDirectionRigthPointsEast() {
        //Arrange
        //Act
        sut.applyCommand(command = TEST_RIGTH)
        //Assert
        assertEquals(Direction.EAST, sut.direction)
    }
    @Test
    fun changeDirectionRigthRigthPointsSouth() {
        //Arrange
        //Act
        sut.applyCommand(command = (TEST_RIGTH + TEST_RIGTH))
        //Assert
        assertEquals(Direction.SOUTH, sut.direction)
    }
    @Test
    fun changeDirectionRigthRigthRigthPointsWest() {
        //Arrange
        //Act
        sut.applyCommand(command = (TEST_RIGTH + TEST_RIGTH + TEST_RIGTH))
        //Assert
        assertEquals(Direction.WEST, sut.direction)
    }
    @Test
    fun changeDirectionRigthRigthRigthRigthPointsNorth() {
        //Arrange
        //Act
        sut.applyCommand(command = (TEST_RIGTH + TEST_RIGTH + TEST_RIGTH + TEST_RIGTH))
        //Assert
        assertEquals(Direction.NORTH, sut.direction)
    }
    @Test
    fun changeDirectionRigthFromEastPointsSouth() {
        //Arrange
        sut = Rover(direction = Direction.EAST)
        //Act
        sut.applyCommand(command = TEST_RIGTH)
        //Assert
        assertEquals(Direction.SOUTH, sut.direction)
    }

    @Test
    fun testRoverTurnRigthCallDirectionTurnRigth() {
        //Arrange
        val mock = DirectionMock()
        //Act
        sut.direction = mock
        sut.applyCommand("R")
        //Assert
        assertTrue(mock.trcalled)
    }
    @Test
    fun testRoverTurnLeftallDirectionTurnLeft() {
        //Arrange
        val mock = DirectionMock()
        //Act
        sut.direction = mock
        sut.applyCommand("L")
        //Assert
        assertTrue(mock.tlcalled)
    }

    @Test
    fun testRoverTurnRigthStoreDirectionTurnRigth() {
        //Arrange
        val mock = DirectionMock(Direction.SOUTH)
        //Act
        sut.direction = mock
        sut.applyCommand("R")
        //Assert
        assertEquals(Direction.SOUTH, sut.direction)
    }

    @Test
    fun testRoverTurnLeftStoreDirectionTurnLeft() {
        //Arrange
        val mock = DirectionMock(Direction.SOUTH)
        //Act
        sut.direction = mock
        sut.applyCommand("L")
        //Assert
        assertEquals(Direction.SOUTH, sut.direction)
    }

    @Test
    fun testRoverTurnRigthStoreDirectionTurnRigthCopy() {
        //Arrange
        val mock = DirectionMock(Direction.NORTH)
        //Act
        sut.direction = mock
        sut.applyCommand("R")
        //Assert
        assertEquals(Direction.NORTH, sut.direction)
    }

    @Test
    fun testRoverTurnLeftStoreDirectionTurnLeftCopy() {
        //Arrange
        val mock = DirectionMock(Direction.NORTH)
        //Act
        sut.direction = mock
        sut.applyCommand("L")
        //Assert
        assertEquals(Direction.NORTH, sut.direction)
    }

    @Test
    fun moveForwarfFromInitialStateIncermentsYNotX() {
        //Arrange
        //Act
        sut.applyCommand("F")
        //Assert
        assertEquals(1, sut.y)
        assertEquals(0, sut.x)
    }

    @Test
    @Parameters("1,1,NORTH,F,1,2", "1,1,EAST,F,2,1")
    fun moveFromStatechangesCoordinatesParameters( x: Int, y: Int, direction: Direction, command: String, expectedX: Int, expectedY: Int) {
        //Arrange
        sut = Rover(x, y)
        sut.direction = direction
        //Act
        sut.applyCommand(command)
        //Assert
        assertEquals(expectedX , sut.x)
        assertEquals(expectedY , sut.y)
    }

    @Test
    @Parameters(method = "parametersMove")
    fun moveFromStatechangesCoordinates( x: Int, y: Int, direction: Direction, command: String, expectedX: Int, expectedY: Int) {
        //Arrange
        sut = Rover(x, y)
        sut.direction = direction
        //Act
        sut.applyCommand(command)
        //Assert
        assertEquals(expectedX , sut.x)
        assertEquals(expectedY , sut.y)
    }

    fun parametersMove(): List<Any> {
        return listOf(
                listOf<Any>(1, 1, Direction.NORTH, "F", 1, 2),
                listOf<Any>(1, 1, Direction.EAST, "F", 2, 1),
                listOf<Any>(1, 1, Direction.SOUTH, "F", 1, 0),
                listOf<Any>(1, 1, Direction.WEST, "F", 0, 1))
    }

    @Test
    fun moveForwarfFromOtherStateIncermentsYNotX() {
        //Arrange
        sut = Rover(TEST_X, TEST_Y)
        //Act
        sut.applyCommand("F")
        //Assert
        assertEquals(TEST_Y + 1 , sut.y)
        assertEquals(TEST_X , sut.x)
    }
    @Test
    fun moveRigthFromOtherStateIncermentsXNotY() {
        //Arrange
        sut = Rover(TEST_X, TEST_Y)
        sut.direction = Direction.EAST
        //Act
        sut.applyCommand("F")
        //Assert
        assertEquals(TEST_X + 1 , sut.x)
        assertEquals(TEST_Y , sut.y)
    }
    @Test
    fun moveLeftFromOtherStateDecrementsXNotY() {
        //Arrange
        sut = Rover(TEST_X, TEST_Y)
        sut.direction = Direction.WEST
        //Act
        sut.applyCommand("F")
        //Assert
        assertEquals(TEST_X - 1 , sut.x)
        assertEquals(TEST_Y , sut.y)
    }

    @Test
    fun moveBackFromOtherStateDecrementsYNotX() {
        //Arrange
        sut = Rover(TEST_X, TEST_Y)
        sut.direction = Direction.SOUTH
        //Act
        sut.applyCommand("F")
        //Assert
        assertEquals(TEST_X , sut.x)
        assertEquals(TEST_Y - 1 , sut.y)
    }
}