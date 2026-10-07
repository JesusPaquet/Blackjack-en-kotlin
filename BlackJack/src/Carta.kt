class Carta {

    enum class Palo {
        CORAZONES, DIAMANTES, TREBOLES, PICAS
    }

    enum class Valor(val puntos: Int) {
        DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), OCHO(8), NUEVE(9),
        DIEZ(10), JOTA(10), REINA(10), REY(10), AS(11)
    }

    data class Carta(val palo: Palo, val valor: Valor) {
        override fun toString(): String {
            return "$valor de $palo"
        }
    }
    }