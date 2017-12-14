package es.liquidsquad.katamarsrover.modelo


class Rover(val x: Int = DEFAULT_X, val y: Int = DEFAULT_Y, var defaultDirection: Char = TEST_DEFAULT_DIR) {
    companion object {
        const val DEFAULT_X = 0
        const val DEFAULT_Y = 0
        const val TEST_DEFAULT_DIR = 'N'
    }

    fun applyCommand(command: Char) {
            defaultDirection= 'E'
    }

}