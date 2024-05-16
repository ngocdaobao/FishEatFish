package fisheater;

import music.Music;
import music.MusicThread;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Random;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

import javax.swing.JPanel;

public class Board extends JPanel implements Runnable {
    public Graphics2D g2d;
    private int B_WIDTH;
    private int B_HEIGHT;
    private int score = 0;

    private float frameRate;
    private Thread thread;
    private final int DELAY = 16;

    private Player player;
    private Background bg;
    private PowerUp pUp;
    private EatShark SharkEat;
    private Menu menu;
    private int baseSpeed;
    private ArrayList<Fish> fish;
    private ArrayList<Shark> sharks;

    private boolean inGame, inMenu, GameOver, quitGame, printDuration, sharkDuration;
    private Font font;
    private Music gameMusic = new Music("fisheater/resources/sounds/gameMusic.wav", 0.3);
    private MusicThread eat = new MusicThread("fisheater/resources/sounds/eat.wav", 0.5);
    private MusicThread gameOver = new MusicThread("fisheater/resources/sounds/gameOver.wav", 0.5);
    private MusicThread powerUp = new MusicThread("fisheater/resources/sounds/powerUp.wav", 0.5);

    public Board(int width, int height) {
        addMouseListener(new mouseAdapter());
        addKeyListener(new keyAdapter());
        setFocusable(true);
        B_WIDTH = width;
        B_HEIGHT = height;

        inMenu = true;
        inGame = false;
        GameOver = false;
        quitGame = false;

        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        font = new Font("Helvetica", Font.BOLD, 24);

        initGame();
    }

    public void initGame() {
        menu = new Menu(B_WIDTH, B_HEIGHT);
        bg = new Background(0, 0);
        pUp = new PowerUp(0, 0, 0);
        SharkEat = new EatShark(0, 0, 0);
        fish = new ArrayList();
        sharks = new ArrayList();
        player = new Player(300, 200, 2);
        printDuration = false;

        frameRate = 0;
        score = 0;
        baseSpeed = 0;
        pUp.setAlive(false);
        SharkEat.setAlive(false);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        thread = new Thread(this);
        thread.start();
    }

    public void genFish() {
        Fish temp = new Fish(-100, -100, 0, "L");
        int spawn = temp.getHeight();
        temp.setVisible(false);

        Random gen = new Random();
        String direction = "";
        int x, y, speed;
        int numFish = gen.nextInt(10) + 10;

        for (int i = 0; i < numFish; i++) {
            y = spawn + gen.nextInt(B_HEIGHT - spawn * 3);
            speed = gen.nextInt(5) - 2;
            if (speed > 0) {
                speed += baseSpeed;
                x = gen.nextInt(1000) + B_WIDTH;
                direction = "L";
            } else {
                speed -= baseSpeed + 1;
                x = gen.nextInt(1000) - (B_WIDTH + 400);
                direction = "R";
            }
            fish.add(new Fish(x, y, speed, direction));
        }
    }

    public void genSharks() {
        Shark temp = new Shark(-100, -100, 0, "L");
        int spawn = temp.getHeight();

        Random gen = new Random();
        String direction = "";
        int x, y, speed;
        int numSharks = gen.nextInt(9) + 1;

        for (int i = 0; i < numSharks; i++) {
            y = spawn + gen.nextInt(B_HEIGHT - spawn * 3);
            speed = gen.nextInt(5) - 2;
            if (speed > 0) {
                speed += baseSpeed;
                x = gen.nextInt(1000) + B_WIDTH;
                direction = "L";
            } else {
                speed -= baseSpeed + 1;
                x = gen.nextInt(1000) - (B_WIDTH + 400);
                direction = "R";
            }
            sharks.add(new Shark(x, y, speed, direction));
        }
    }

    public void genPowerUp() {
        Random gen = new Random();
        int x = (pUp.getWidth() + gen.nextInt(B_WIDTH - pUp.getWidth() * 3)),
                y = -gen.nextInt(B_HEIGHT) - 500,
                speed = gen.nextInt(5) + 3;

        pUp = new PowerUp(x, y, speed);
    }

    public void genEatShark() {
        Random gen = new Random();
        int x = (SharkEat.getWidth() + gen.nextInt(B_WIDTH - SharkEat.getWidth() * 3)),
                y = -gen.nextInt(B_HEIGHT) - 500,
                speed = gen.nextInt(5) + 3;

        SharkEat = new EatShark(x, y, speed);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.addRenderingHints(rh);

        if (inGame) {
            bg.paint(g);
            player.paint(g);

            for (Object fish1 : fish) {
                Fish f = (Fish) fish1;
                f.paint(g);
            }

            for (Object shark1 : sharks) {
                Shark sh = (Shark) shark1;
                sh.paint(g);
            }

            if (pUp.isAlive() && pUp.isVisible()) {
                pUp.paint(g);
            }
            if (printDuration && pUp.isAlive()) {
                g.drawString(pUp.getName() + " Buff Duration: " + pUp.getDuration() / 63 + "s", 10, 30);
            }

            if (SharkEat.isAlive() && SharkEat.isVisible()) {
                SharkEat.paint(g);
            }
            if (sharkDuration && SharkEat.isAlive()) {
                g.drawString(SharkEat.getName() + " Buff Duration: " + SharkEat.getDuration() / 63 + "s", 10, 20);
            }

            g.setColor(Color.black);
            g.drawString("Score: " + score, 0, 10);
        }

        else if (inMenu) {
            // g2d.drawImage(menu.getMenu(), 0, 0, this);
            g2d.drawImage(menu.getMenu("welcome"), 0, 0, this);
        }

        else if (GameOver) {
            // g2d.drawImage(menu.getGameOver(), 0, 0, this);
            g2d.drawImage(menu.getMenu("gameover"), 0, 0, this);

            g2d.setColor(Color.yellow);
            g2d.setFont(font);
            g2d.drawString("" + score, B_WIDTH / 2 - 10, B_HEIGHT / 2 - 50);

            g2d.setFont(new Font("Helvetica", Font.PLAIN, 12));

        }

        g2d.setColor(Color.white);
        g2d.drawString("Framerate = " + frameRate, B_WIDTH / 2, 15);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void run() {
        long beforeTime, timeDiff, sleep, frameRateTimer;
        int frameRateCounter = 0;
        Random gen = new Random();

        beforeTime = System.currentTimeMillis();
        frameRateTimer = System.currentTimeMillis();

        while (!quitGame) {
            if (inGame) {
                gameMusic.loop();
                if (pUp.isAlive()) {
                    pUp.move();
                }

                if (SharkEat.isAlive()) {
                    SharkEat.move();
                }

                for (int i = 0; i < fish.size(); i++) {
                    Fish f = (Fish) fish.get(i);
                    if (f.isVisible()) {
                        if ((f.getSpeed() < 0 && f.getX() > -30) || (f.getSpeed() > 0 && f.getX() < 1280)) {
                            f.move();
                        } else {
                            fish.remove(i);
                        }
                    } else {
                        fish.remove(i);
                    }
                }

                for (int i = 0; i < sharks.size(); i++) {
                    Shark s = (Shark) sharks.get(i);
                    if (s.isVisible()) {
                        if ((s.getSpeed() < 0 && s.getX() > -100) || (s.getSpeed() > 0 && s.getX() < 1280)) {
                            s.move();
                        } else {
                            sharks.remove(i);
                        }
                    } else {
                        sharks.remove(i);
                    }
                }

                if (fish.size() < 3) {
                    genFish();
                }
                if (fish.size() > 5 && gen.nextInt(100) > 50 && sharks.isEmpty()) {
                    genSharks();
                }
                if (pUp.isAlive() == false && gen.nextInt(200) > 15) {
                    genPowerUp();
                }
                if (pUp.getDuration() < 0) {
                    player.setSpeedUp(false);
                    printDuration = false;
                    pUp.setAlive(false);
                }

                if (SharkEat.isAlive() == false && gen.nextInt(200) > 15) {
                    genEatShark();
                }
                if (SharkEat.getDuration() < 0) {
                    player.setSharkEat(false);
                    sharkDuration = false;
                    SharkEat.setAlive(false);
                }
                player.move();
                checkCollisions();
            } else if (inMenu) {
                gameMusic.stop();
            } else if (GameOver) {
                gameMusic.stop();
            }

            repaint();

            frameRateCounter++;
            timeDiff = System.currentTimeMillis() - frameRateTimer;
            if (timeDiff >= 1000) {
                frameRate = (float) (frameRateCounter * 1000) / timeDiff;
                frameRateCounter = 0;
                frameRateTimer = System.currentTimeMillis();
            }

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;
            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }

            beforeTime = System.currentTimeMillis();
        }
    }

    public void checkCollisions() {

        for (int i = 0; i < fish.size(); i++) {
            Fish f = (Fish) fish.get(i);

            if (player.EllipseCollision(f)) {
                eat.play();
                f.setVisible(false);
                score += f.getPoints();
                baseSpeed = (int) (Math.log(score/25.0)/Math.log(2));
                System.out.println(baseSpeed);
                if (baseSpeed < 0)
                    baseSpeed = 0;
                if (baseSpeed > 8)
                    baseSpeed = 8;
                player.setSpeed(baseSpeed + 2);
            }
        }

        for (int i = 0; i < sharks.size(); i++) {
            Shark s = (Shark) sharks.get(i);

            if (player.EllipseCollision(s)) {
                if (player.getSharkEat()) {
                    eat.play();
                    score += s.getPoints();
                    baseSpeed = (int) (Math.log(score/25.0)/Math.log(2));
                    if (baseSpeed < 0)
                        baseSpeed = 0;
                    if (baseSpeed > 8)
                        baseSpeed = 8;
                    player.setSpeed(baseSpeed + 2);
                    s.setVisible(false);
                } else {
                    player.setVisible(false);
                    inGame = false;
                    GameOver = true;
                    gameOver.play();
                }
            }
        }

        if (player.EllipseCollision(pUp)) {
            powerUp.play();
            player.setSpeedUp(true);
            pUp.setVisible(false);
            pUp.setY(-10);
            printDuration = true;
        }

        if (player.EllipseCollision(SharkEat)) {
            powerUp.play();
            player.setSharkEat(true);
            SharkEat.setVisible(false);
            SharkEat.setY(-10);
            sharkDuration = true;
        }
    }

    private class keyAdapter extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    }

    private class mouseAdapter extends MouseAdapter {
        public void mouseReleased(MouseEvent m) {

        }

        public void mousePressed(MouseEvent m) {
            int mouseDown = m.getButton();
            if (mouseDown == m.BUTTON1) {
                if (inMenu) {
                    if (menu.startPressed(m)) {
                        inGame = true;
                        inMenu = false;
                        initGame();
                    }
                }

                if (GameOver) {
                    if (menu.replayPressed(m)) {
                        inGame = true;
                        GameOver = false;
                        initGame();
                    }
                    if (menu.menuPressed(m)) {
                        inMenu = true;
                        GameOver = false;
                        player.setVisible(true);
                    }
                }
            }
        }

    }
}
