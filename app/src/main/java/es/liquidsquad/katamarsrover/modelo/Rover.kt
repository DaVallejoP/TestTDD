package es.liquidsquad.katamarsrover.modelo


class Rover(val x: Int = DEFAULT_X, val y: Int = DEFAULT_Y, var direction: Direction = DEFAULT_DIR) {
    companion object {
        const val DEFAULT_X = 0
        const val DEFAULT_Y = 0
        val DEFAULT_DIR = Direction.NORTH
    }

    fun applyCommand(command: String) {
        command.map { it -> doCommand(it) }
    }

    private fun doCommand(c: Char) {
        if(c == 'R'){
            direction = direction.let { it.turnRigth() }
        }
        if(c == 'L'){
            direction = direction.turnLeft()
        }
    }
}