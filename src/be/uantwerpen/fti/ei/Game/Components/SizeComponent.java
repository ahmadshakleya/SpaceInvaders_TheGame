package be.uantwerpen.fti.ei.Game.Components;

public class SizeComponent {
    private boolean reachedEnd = false;

    private int Screenwidth;
    private int ScreenHeight;

    private int Size;

    public SizeComponent(int screenwidth, int screenHeight, int size) {
        Screenwidth = screenwidth;
        ScreenHeight = screenHeight;
        Size = size;
    }

    public boolean isReachedEnd() {
        return reachedEnd;
    }

    public void setReachedEnd(boolean reachedEnd) {
        this.reachedEnd = reachedEnd;
    }

    public int getScreenwidth() {
        return Screenwidth;
    }

    public void setScreenwidth(int screenwidth) {
        Screenwidth = screenwidth;
    }

    public int getScreenHeight() {
        return ScreenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        ScreenHeight = screenHeight;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }
}
