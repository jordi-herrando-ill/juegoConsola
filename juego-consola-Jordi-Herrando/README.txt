Juego de Consola

Este es un juego de consola simple implementado en Java, donde el jugador controla un personaje que se mueve en un campo bidimensional. El objetivo es evitar ser atrapado por un enemigo que se mueve automáticamente. El juego termina cuando las coordenadas del jugador y del enemigo coinciden.

Estructura del Código

El código consta de tres clases principales:
Coordinates

La clase Coordinates representa las coordenadas en el campo bidimensional. Esta clase extiende la clase Observable y notifica a los observadores cuando las coordenadas se actualizan.

Player

La clase Player implementa la interfaz Observer y representa al jugador en el juego. El jugador puede moverse en el campo bidimensional en respuesta a las entradas del usuario. Se registra como observador de las coordenadas para recibir actualizaciones cuando el jugador se mueve.

Enemy

La clase Enemy también implementa la interfaz Observer y representa al enemigo en el juego. El enemigo se mueve automáticamente hacia la posición del jugador. Al igual que el jugador, también se registra como observador de las coordenadas para seguir al jugador.

Main

La clase Main contiene el método principal que inicia el juego. Crea instancias de Player y Enemy junto con las coordenadas iniciales. Utiliza un bucle para permitir que el jugador se mueva ingresando direcciones desde la consola. El juego termina cuando las coordenadas del jugador y del enemigo coinciden, y se imprime la cantidad de pasos realizados por el jugador.

Instrucciones para Ejecutar

    Asegúrate de tener Java instalado en tu sistema.
    Compila el código utilizando tu entorno de desarrollo preferido o mediante el comando javac en la línea de comandos.
    Ejecuta la aplicación resultante.

Controles del Juego

    "a": Moverse hacia la izquierda.
    "d": Moverse hacia la derecha.
    "w": Moverse hacia arriba.
    "s": Moverse hacia abajo.

¡Evita ser atrapado por el enemigo y trata de sobrevivir el mayor tiempo posible!
