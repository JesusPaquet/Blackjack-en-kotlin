import Carta.Carta
import Carta.Palo
import Carta.Valor

class Baraja {
    private val cartas = mutableListOf<Carta>()

    init {
        for (palo in Palo.entries) {
            for (valor in Valor.entries) {
                cartas.add(Carta(palo, valor))
            }
        }
        cartas.shuffle()
    }

    fun repartir(): Carta{
        return  cartas.removeAt(0)
    }
}