package nyz.calculadora.utils

class Validate {
    fun isNull(value1 : Double, value2 : Double): Boolean {
        val value1Text = value1.toString()
        val value2Text = value2.toString()

        return !(value1Text.isBlank() || value2Text.isBlank())
    }
}