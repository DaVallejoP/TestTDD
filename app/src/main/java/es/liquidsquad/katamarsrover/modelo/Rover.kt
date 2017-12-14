package es.liquidsquad.katamarsrover.modelo


class Rover(val x: Int = DEFAULT_X, val y: Int = DEFAULT_Y, var defaultDirection: Char = DEFAULT_DIR) {
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
            defaultDirection= 'E'
    }

}