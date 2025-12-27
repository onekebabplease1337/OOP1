package models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Enemy {

    private double x;
    private double y;
    private double speed = 1.5;
    private int health = 100;

    public Enemy(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        x += speed;
    }

    public void render(GraphicsContext gc) {
        gc.setFill(Color.DARKRED);
        gc.fillOval(x, y, 30, 30);
    }

    public boolean isDead() {
        return health <= 0;
    }
}
