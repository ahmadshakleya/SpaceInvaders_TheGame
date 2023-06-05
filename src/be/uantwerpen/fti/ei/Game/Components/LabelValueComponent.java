package be.uantwerpen.fti.ei.Game.Components;

/**
 * Represents a label value component in the Space Invaders game.
 * The label value component stores an integer value associated with a label.
 *
 *
 * @author Ahmad Shakleya
 */
public class LabelValueComponent {
    /**
     * The integer value associated with the label.
     */
    private int labelValue;

    /**
     * Constructs a new LabelValueComponent with the specified value.
     *
     * @param labelValue the integer value associated with the label
     */
    public LabelValueComponent(int labelValue) {
        this.labelValue = labelValue;
    }

    /**
     * Retrieves the integer value associated with the label.
     *
     * @return the integer value associated with the label
     */
    public int getLabelValue() {
        return labelValue;
    }

    /**
     * Sets the integer value associated with the label.
     *
     * @param labelValue the new integer value to be associated with the label
     */
    public void setLabelValue(int labelValue) {
        this.labelValue = labelValue;
    }
}
