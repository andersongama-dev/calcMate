package nyz.calculadora.operations

class Calculate {
    fun sum(n1: Double, n2: Double): Double {
        return n1 + n2
    }

    fun sub(n1: Double, n2: Double): Double {
        return n1 - n2
    }

    fun mul(n1: Double, n2: Double): Double {
        return n1 * n2
    }

    fun div(n1: Double, n2: Double): Double {
        if(n2 == 0.0) {
            return 0.0
        }
        return n1 / n2
    }
}