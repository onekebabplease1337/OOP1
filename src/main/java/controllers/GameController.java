package controllers;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

import models.Enemy;

public class GameController {

    @FXML
    private Canvas gameCanvas;

    private GraphicsContext gc;
    private List<Enemy> enemies = new ArrayList<>();

    @FXML
    public void initialize() {
        gc = gameCanvas.getGraphicsContext2D();

        // создаем первого врага
        enemies.add(new Enemy(0, 280));

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                render();
            }
        };
        gameLoop.start();
    }

    private void update() {
        for (Enemy enemy : enemies) {
            enemy.update();
        }
    }

    private void render() {
        gc.setFill(Color.DARKOLIVEGREEN);
        gc.fillRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight());

        for (Enemy enemy : enemies) {
            enemy.render(gc);
        }
    }
}
