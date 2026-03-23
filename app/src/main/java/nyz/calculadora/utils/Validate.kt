package nyz.calculadora.utils

class Validate {
    fun isNull(value1 : String, value2 : String): Boolean {

        if(value1.isBlank() || value2.isBlank()) {
            return false
        }

        return true
    }
}