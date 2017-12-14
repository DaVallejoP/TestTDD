package es.liquidsquad.katamarsrover.modelo


class Rover(val x: Int = DEFAULT_X, val y: Int = DEFAULT_Y, var direction: Char = DEFAULT_DIR) {
    val EAST = 'E'
    val WEST = 'W'
    val NORTH = 'N'
    val SOUTH = 'S'
    companion object {
        const val DEFAULT_X = 0
        const val DEFAULT_Y = 0
        const val DEFAULT_DIR = 'N'
    }

    fun applyCommand(command: String) {
        command.map { it -> doCommand(it) }
    }

    private fun doCommand(c: Char) {
        if(c == 'R'){
            if(direction == NORTH)
                direction = EAST
            else if(direction == EAST)
                direction = SOUTH
            else if(direction == SOUTH)
                direction = WEST
            else if(direction == WEST)
                direction = NORTH
        }
    }
}