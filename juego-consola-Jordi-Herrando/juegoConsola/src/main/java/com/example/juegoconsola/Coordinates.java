package com.example.juegoconsola;


import java.util.Observable;
import java.util.Observer;


class Coordinates extends Observable {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
        setChanged();
        notifyObservers();
    }
}

class Player implements Observer {
    private Coordinates coordinates;
    private int steps;

    public Player(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.steps = 0;
        coordinates.addObserver(this);
    }

    public void move(String direction) {
        int x = coordinates.getX();
        int y = coordinates.getY();

        switch (direction) {
            case "a":
                x--;
                break;
            case "d":
                x++;
                break;
            case "w":
                y++;
                break;
            case "s":
                y--;
                break;
        }

        coordinates.setCoordinates(x, y);
        steps++;
    }

    public int getSteps() {
        return steps;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("El jugador se ha movido a la posición (" + coordinates.getX() + ", " + coordinates.getY() + ").");
    }
}





class Enemy implements Observer {
    private Coordinates playerCoordinates;
    private Coordinates enemyCoordinates;

    public Enemy(Coordinates playerCoordinates, Coordinates enemyCoordinates) {
        this.playerCoordinates = playerCoordinates;
        this.enemyCoordinates = enemyCoordinates;
        playerCoordinates.addObserver(this);
    }

    public void updateEnemy() {
        int playerX = playerCoordinates.getX();
        int playerY = playerCoordinates.getY();
        int enemyX = enemyCoordinates.getX();
        int enemyY = enemyCoordinates.getY();

        if (playerX < enemyX) {
            enemyX -= 2;
        } else if (playerX > enemyX) {
            enemyX += 2;
        }
        if (playerY < enemyY) {
            enemyY -= 2;
        } else if (playerY > enemyY) {
            enemyY += 2;
        }

        enemyCoordinates.setCoordinates(enemyX, enemyY);
    }

    @Override
    public void update(Observable o, Object arg) {
        updateEnemy();
        System.out.println("El enemigo se ha movido a la posición (" + enemyCoordinates.getX() + ", " + enemyCoordinates.getY() + ").");
    }
}

