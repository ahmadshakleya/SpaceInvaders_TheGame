package be.uantwerpen.fti.ei.UI_CUBE;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Represents the graphics context for the CUBE game.
 * Manages the graphical rendering of the game entities.
 *
 * @author Ahmad Shakleya
 */
public class GraphicsContextCUBE {
    private int ScreenWidth;
    private int ScreenHeight;
    private final JFrame frame;
    private final JPanel panel;
    private BufferedImage g2dimage;     // used for drawing
    private Graphics2D g2d;             // always draw in this one
    private int size;                   // cell size

    /**
     * Gets the Graphics2D object for drawing.
     *
     * @return The Graphics2D object.
     */
    public Graphics2D getG2d() {
        return g2d;
    }

    /**
     * Gets the JFrame object.
     *
     * @return The JFrame object.
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Gets the cell size.
     *
     * @return The cell size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Resizes an image to the specified dimensions.
     *
     * @param originalImage The original image to be resized.
     * @param targetWidth   The target width of the resized image.
     * @param targetHeight  The target height of the resized image.
     * @return The resized BufferedImage object.
     */
    public BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_4BYTE_ABGR_PRE);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }

    /**
     * Constructs a new GraphicsContextCUBE object.
     *
     * @param screenWidth  The screen width.
     * @param screenHeight The screen height.
     */
    public GraphicsContextCUBE(int screenWidth, int screenHeight) {
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
     * Renders the game graphics.
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
     * Draws the game graphics on the panel.
     *
     * @param g The Graphics object used for drawing.
     */
    private void doDrawing(Graphics g) {
        Graphics2D graph2d = (Graphics2D) g;
        Toolkit.getDefaultToolkit().sync();
        graph2d.drawImage(g2dimage, 0, 0, null);   // copy buffered image
        graph2d.dispose();
        if (g2d != null) {
            g2d.setColor(new Color(0, 0, 0));
            g2d.fillRect(0, 0, frame.getWidth(), frame.getHeight());
        }
    }


    /**
     * Sets the dimensions of the game grid.
     *
     * @param GameCellsX The number of cells in the x-direction.
     * @param GameCellsY The number of cells in the y-direction.
     */
    public void setGameDimensions(int GameCellsX, int GameCellsY) {
        size = Math.min(ScreenWidth / GameCellsX, ScreenHeight / GameCellsY);
        frame.setLocation(50, 50);
        frame.setSize(ScreenWidth, ScreenHeight);
        g2dimage = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_4BYTE_ABGR_PRE);
        g2d = g2dimage.createGraphics();
        //g2d.drawImage(backgroundImg,0, 0, null);
        g2d.fillRect(0, 0, frame.getWidth(), frame.getHeight());
    }

    /**
     * Gets the screen width.
     *
     * @return The screen width.
     */
    public int getScreenWidth() {
        return ScreenWidth;
    }

    /**
     * Sets the screen width.
     *
     * @param screenWidth The screen width.
     */
    public void setScreenWidth(int screenWidth) {
        ScreenWidth = screenWidth;
    }

    /**
     * Gets the screen height.
     *
     * @return The screen height.
     */
    public int getScreenHeight() {
        return ScreenHeight;
    }

    /**
     * Sets the screen height.
     *
     * @param screenHeight The screen height.
     */
    public void setScreenHeight(int screenHeight) {
        ScreenHeight = screenHeight;
    }
}
