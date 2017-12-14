package es.liquidsquad.katamarsrover.modelo

enum class Direction {
    NORTH,EAST,SOUTH,WEST;

    fun turnRigth(): Direction = let {
        when(this){
            NORTH -> EAST
            EAST  -> SOUTH
            SOUTH -> WEST
            WEST  -> NORTH
        }
    }

    fun turnLeft(): Direction = let {
        when(this){
            NORTH -> WEST
            EAST  -> NORTH
            SOUTH -> EAST
            WEST  -> SOUTH
        }
    }
}