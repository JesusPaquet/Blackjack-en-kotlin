fun main() {
    println("BLACKJACK")
    val partida = Partida()
    partida.iniciarJuego()

    var juegoTerminado = false

    //Inicio el bucle while para repartir las cartas iniciales y comprobar directamente si ha perdido
    while (!juegoTerminado) {

        //Muestro solo la primera carta del crupier para que el jugador pueda pensar su estrategia
        val cartaVisible = partida.manoCrupier.cartas[0]
        println("Carta visible del crupier: [$cartaVisible] (Valor: ${cartaVisible.valor.puntos})")

        println("TURNO DEL JUGADOR")
        println("Tus cartas: ${partida.manoJugador.cartas}")
        println("Tu puntuación: ${partida.manoJugador.calcularPuntuacion()}")

        //Dentro del while meto este if para calcular si la puntuación es mayor que 21
        if (partida.manoJugador.calcularPuntuacion() > 21) {
            println("¡Te has pasado de 21! Gana el crupier.")
            break
        }

        //Pregunto al jugador si quiere pedir más cartas o plantarse
        println("¿Qué quieres hacer? (1) Pedir carta  (2) Plantarse")
        val opcion = readln()

        //Hago el if con 2 opciones anteriores y se repite el proceso
        if (opcion == "1") {
            partida.jugadorPideCarta()
        } else if (opcion == "2") {
            println("TURNO DEL CRUPIER")
            partida.turnoCrupier()

            val puntosJugador = partida.manoJugador.calcularPuntuacion()
            val puntosCrupier = partida.manoCrupier.calcularPuntuacion()

            println("Cartas del crupier: ${partida.manoCrupier.cartas}")
            println("Puntuación crupier: $puntosCrupier")

            when {
                puntosCrupier > 21 -> println("¡El crupier se pasa! ¡Tu ganas!")
                puntosCrupier > puntosJugador -> println("Gana el Crupier.")
                puntosCrupier < puntosJugador -> println("¡Tu ganas!")
                else -> println("¡Empate!")
            }
            juegoTerminado = true
        } else {
            println("Opción no válida, escribe 1 o 2.")
        }
    }
    println(" FIN DEL JUEGO ")
}