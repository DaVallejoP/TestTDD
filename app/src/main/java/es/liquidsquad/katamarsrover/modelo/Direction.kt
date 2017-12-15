package es.liquidsquad.katamarsrover.modelo

interface IDirection {
    fun turnRigth(): Direction
    fun turnLeft(): Direction
}

enum class Direction : IDirection {
    NORTH, EAST, SOUTH, WEST;

    override fun turnRigth(): Direction = let {
        when (this) {
            NORTH -> EAST
            EAST -> SOUTH
            SOUTH -> WEST
            WEST -> NORTH
        }
    }

    override fun turnLeft(): Direction = let {
        when (this) {
            NORTH -> WEST
            EAST -> NORTH
            SOUTH -> EAST
            WEST -> SOUTH
        }
    }
}