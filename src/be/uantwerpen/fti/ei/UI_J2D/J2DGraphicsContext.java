package be.uantwerpen.fti.ei.UI_J2D;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * The J2DGraphicsContext class manages the graphical context in a Java 2D-based game.
 * It handles rendering, loading images, and setting up the game dimensions.
 *
 * @author Ahmad Shakleya
 */
public class J2DGraphicsContext {
    private int ScreenWidth;
    private int ScreenHeight;
    private final JFrame frame;
    private final JPanel panel;
    private BufferedImage g2dimage;     // used for drawing
    private Graphics2D g2d;             // always draw in this one
    public BufferedImage backgroundImg;
    public BufferedImage playerSprite;
    public BufferedImage enemySprite;
    public BufferedImage positiveBonusSprite;
    public BufferedImage negativeBonusSprite;
    public BufferedImage enemyBulletSprite;
    public BufferedImage barrierSprite;
    public BufferedImage playerBulletSprite;
    private int size;                   // cel size

    /**
     * Get the Graphics2D object for drawing.
     *
     * @return The Graphics2D object.
     */
    public Graphics2D getG2d() {
        return g2d;
    }

    /**
     * Get the JFrame object associated with the graphics context.
     *
     * @return The JFrame object.
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Get the size of the cell.
     *
     * @return The cell size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Resize the given BufferedImage to the specified target width and height.
     *
     * @param originalImage The original BufferedImage to be resized.
     * @param targetWidth   The target width for resizing.
     * @param targetHeight  The target height for resizing.
     * @return The resized BufferedImage.
     */
    public BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_4BYTE_ABGR_PRE);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }
    /**
     * Load the required images for the game from files.
     */
    private void loadImages() {
        backgroundImg = null;
        playerSprite = null;
        enemySprite = null;
        enemyBulletSprite = null;
        positiveBonusSprite = null;
        negativeBonusSprite = null;
        barrierSprite = null;
        playerBulletSprite = null;
        try {
            backgroundImg = ImageIO.read(new File("src/resource/Sprites/ScreenshotStarfield.png"));
        } catch (IOException e) {
            System.out.println("Unable to load ScreenshotStarfield.png!");
        }
        try {
            playerSprite = ImageIO.read(new File("src/resource/Sprites/player-sprite.png"));
        } catch (IOException e) {
            System.out.println("Unable to load player-sprite.png!");
        }
        try {
            enemySprite = ImageIO.read(new File("src/resource/Sprites/enemy.png"));
        } catch (IOException e) {
            System.out.println("Unable to load enemy.png!");
        }
        try {
            positiveBonusSprite = ImageIO.read(new File("src/resource/Sprites/positiveBonus.png"));
        } catch (IOException e) {
            System.out.println("Unable to load positiveBonus.png!");
        }
        try {
            enemyBulletSprite = ImageIO.read(new File("src/resource/Sprites/enemyBullet.png"));
        } catch (IOException e) {
            System.out.println("Unable to load enemyBullet.png!");
        }
        try {
            playerBulletSprite = ImageIO.read(new File("src/resource/Sprites/playerBullet.png"));
        } catch (IOException e) {
            System.out.println("Unable to load playerBullet.png!");
        }
        try {
            barrierSprite = ImageIO.read(new File("src/resource/Sprites/barrier.png"));
        } catch (IOException e) {
            System.out.println("Unable to load barrier.png!");
        }
        try {
            negativeBonusSprite = ImageIO.read(new File("src/resource/Sprites/negativeBonus.png"));
        } catch (IOException e) {
            System.out.println("Unable to load negativeBonus.png!");
        }

    }
    /**
     * Constructs a J2DGraphicsContext with the specified screen width and height.
     *
     * @param screenWidth  The width of the screen.
     * @param screenHeight The height of the screen.
     */
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
        frame.setTitle("Space Invaders");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(ScreenWidth, ScreenHeight);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Repaints the panel.
     */
    public void render() {
        panel.repaint();
    }
    /**
     * Removes the game graphics.
     */
    public void close() {
        frame.dispose();
    }
    /**
     * Draws the graphics using the specified Graphics object.
     *
     * @param g The Graphics object used for drawing.
     */
    private void doDrawing(Graphics g) {
        Graphics2D graph2d = (Graphics2D) g;
        Toolkit.getDefaultToolkit().sync();
        graph2d.drawImage(g2dimage, 0, 0, null);   // copy buffered image
        graph2d.dispose();
        if (g2d != null)
            g2d.drawImage(backgroundImg, 0, 0, null);
    }

    /**
     * Sets the game dimensions and updates the necessary components.
     *
     * @param GameCellsX The number of cells in the X-axis.
     * @param GameCellsY The number of cells in the Y-axis.
     */
    public void setGameDimensions(int GameCellsX, int GameCellsY) {
        size = Math.min(ScreenWidth / GameCellsX, ScreenHeight / GameCellsY);
        frame.setLocation(50, 50);
        frame.setSize(ScreenWidth, ScreenHeight);
        loadImages();
        try {
            backgroundImg = resizeImage(backgroundImg, frame.getWidth(), frame.getHeight());
        } catch (Exception e) {
            e.printStackTrace();
        }
        g2dimage = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_4BYTE_ABGR_PRE);
        g2d = g2dimage.createGraphics();
        g2d.drawImage(backgroundImg, 0, 0, null);
    }

    /**
     * Get the width of the screen.
     *
     * @return The screen width.
     */
    public int getScreenWidth() {
        return ScreenWidth;
    }

    /**
     * Set the width of the screen.
     *
     * @param screenWidth The screen width.
     */
    public void setScreenWidth(int screenWidth) {
        ScreenWidth = screenWidth;
    }

    /**
     * Get the height of the screen.
     *
     * @return The screen height.
     */
    public int getScreenHeight() {
        return ScreenHeight;
    }

    /**
     * Set the height of the screen.
     *
     * @param screenHeight The screen height.
     */
    public void setScreenHeight(int screenHeight) {
        ScreenHeight = screenHeight;
    }
}
