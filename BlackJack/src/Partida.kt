class Partida {
    val baraja = Baraja()
    val manoJugador = Mano()
    val manoCrupier = Mano()

    fun iniciarJuego() {
        // Repartimos dos cartas a cada uno para empezar
        manoJugador.añadirCarta(baraja.repartir())
        manoCrupier.añadirCarta(baraja.repartir())
        manoJugador.añadirCarta(baraja.repartir())
        manoCrupier.añadirCarta(baraja.repartir())
    }

    fun jugadorPideCarta() {
        manoJugador.añadirCarta(baraja.repartir())
    }

    fun turnoCrupier() {
        // Regla estándar del Blackjack: El crupier pide carta hasta tener 17 o más
        while (manoCrupier.calcularPuntuacion() < 17) {
            manoCrupier.añadirCarta(baraja.repartir())
        }
    }
}

