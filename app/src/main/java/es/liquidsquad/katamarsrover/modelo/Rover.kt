package es.liquidsquad.katamarsrover.modelo


class Rover(var x: Int = DEFAULT_X, var y: Int = DEFAULT_Y, var direction: IDirection = DEFAULT_DIR) {
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
            direction = direction.let { it.turnLeft() }
        }
        if(c == 'F'){
            y = 1
        }
    }


}