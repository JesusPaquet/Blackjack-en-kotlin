import Carta.Carta
import Carta.Valor

class Mano {
    val cartas = mutableListOf<Carta>()

    fun añadirCarta(carta: Carta) {
        cartas.add(carta)
    }

    fun calcularPuntuacion(): Int {
        var puntos = cartas.sumOf { it.valor.puntos }
        var cantidadDeAses = cartas.count { it.valor == Valor.AS }

        while (puntos > 21 && cantidadDeAses > 0) {
            puntos -= 10
            cantidadDeAses--
        }

        return puntos
    }
}

