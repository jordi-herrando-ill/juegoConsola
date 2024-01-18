package com.example.juegoconsola;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Coordinates playerCoordinates = new Coordinates(random.nextInt(26) + 5, random.nextInt(26) + 5);
        Coordinates enemyCoordinates = new Coordinates(random.nextInt(30), random.nextInt(30));

        Player player = new Player(playerCoordinates);
        Enemy enemy = new Enemy(playerCoordinates, enemyCoordinates);

        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.print("Ingrese la dirección (a: izquierda, d: derecha, w: arriba, s: abajo): ");
                String direction = scanner.nextLine();

                // Crear una instancia de la clase Player y llamar al método move
                player.move(direction);

                enemy.updateEnemy();

                if (playerCoordinates.getX() == enemyCoordinates.getX() && playerCoordinates.getY() == enemyCoordinates.getY()) {
                    System.out.println("¡Te han atrapado!");
                    break;
                }
            }

            System.out.println("Pasos realizados por el jugador: " + player.getSteps());
        } finally {
            scanner.close();
        }
    }
}




