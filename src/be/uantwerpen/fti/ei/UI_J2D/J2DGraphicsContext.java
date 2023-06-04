package be.uantwerpen.fti.ei.UI_J2D;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class J2DGraphicsContext {
    private int ScreenWidth;
    private int ScreenHeight;
    private JFrame frame;
    private JPanel panel;
    private BufferedImage g2dimage;     // used for drawing
    private Graphics2D g2d;             // always draw in this one
    public BufferedImage backgroundImg;
    public BufferedImage playerSprite;
    public BufferedImage enemySprite;
    public BufferedImage positiveBonusSprite;
    public BufferedImage negativeBonusSprite;
    public BufferedImage bulletSprite;
    public BufferedImage barrierSprite;
    private int size;                   // cel size
    private int GameCellsX;
    private int GameCellsY;

    public Graphics2D getG2d() {
        return g2d;
    }
    public JFrame getFrame() {
        return frame;
    }
    public int getSize() {
        return size;
    }

    public BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight){
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_4BYTE_ABGR_PRE);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }

    private void loadImages() {
        backgroundImg = null;
        playerSprite = null;
        enemySprite = null;
        bulletSprite = null;
        positiveBonusSprite = null;
        negativeBonusSprite = null;
        barrierSprite = null;
        try {
            backgroundImg = ImageIO.read(new File("src/resource/ScreenshotStarfield.png"));
        } catch (IOException e) {
            System.out.println("Unable to load ScreenshotStarfield.png!");
        }
        try {
            playerSprite = ImageIO.read(new File("src/resource/player-sprite.png"));
        } catch (IOException e) {
            System.out.println("Unable to load player-sprite.png!");
        }
        try {
            enemySprite = ImageIO.read(new File("src/resource/enemy.png"));
        } catch (IOException e) {
            System.out.println("Unable to load enemy.png!");
        }
        try {
            positiveBonusSprite = ImageIO.read(new File("src/resource/positiveBonus.png"));
        } catch (IOException e) {
            System.out.println("Unable to load positiveBonus.png!");
        }
        try {
            bulletSprite = ImageIO.read(new File("src/resource/bullet.png"));
        } catch (IOException e) {
            System.out.println("Unable to load bullet.png!");
        }
        try {
            barrierSprite = ImageIO.read(new File("src/resource/barrier.png"));
        } catch (IOException e) {
            System.out.println("Unable to load barrier.png!");
        }
        try {
            negativeBonusSprite = ImageIO.read(new File("src/resource/negativeBonus.png"));
        } catch (IOException e) {
            System.out.println("Unable to load barrier.png!");
        }

    }

    public J2DGraphicsContext(int screenWidth, int screenHeight) {
        ScreenWidth = screenWidth;
        ScreenHeight = screenHeight;
        frame = new JFrame();
        panel = new JPanel(true) {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                doDrawing(g);
            }
        };
        frame.setFocusable(true);
        frame.add(panel);
        frame.setTitle("Graphics example");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(ScreenWidth, ScreenHeight);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void render() {
        panel.repaint();
    }

    private void doDrawing(Graphics g) {
        Graphics2D graph2d = (Graphics2D) g;
        Toolkit.getDefaultToolkit().sync();
        graph2d.drawImage(g2dimage, 0, 0, null);   // copy buffered image
        graph2d.dispose();
        if (g2d != null)
            g2d.drawImage(backgroundImg,0, 0, null);
    }

    public void setGameDimensions(int GameCellsX, int GameCellsY) {
        this.GameCellsX = GameCellsX;
        this.GameCellsY = GameCellsY;
        size = Math.min(ScreenWidth/GameCellsX, ScreenHeight/GameCellsY);
        frame.setLocation(50,50);
        frame.setSize(ScreenWidth, ScreenHeight);
        loadImages();
        try {
            backgroundImg = resizeImage(backgroundImg, frame.getWidth(), frame.getHeight());
        } catch(Exception e) {
            System.out.println(e.getStackTrace());
        }
        g2dimage = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_4BYTE_ABGR_PRE);
        g2d = g2dimage.createGraphics();
        g2d.drawImage(backgroundImg,0, 0, null);
    }

    public int getScreenWidth() {
        return ScreenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        ScreenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return ScreenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        ScreenHeight = screenHeight;
    }

    public int getGameCellsX() {
        return GameCellsX;
    }

    public void setGameCellsX(int gameCellsX) {
        GameCellsX = gameCellsX;
    }

    public int getGameCellsY() {
        return GameCellsY;
    }

    public void setGameCellsY(int gameCellsY) {
        GameCellsY = gameCellsY;
    }

}
