package be.uantwerpen.fti.ei.Game.Components;

/**
 * Represents a sound component in the Space Invaders game.
 * The sound component stores information about a sound in the game.
 *
 *
 * @author Ahmad Shakleya
 */
public class SoundComponent {
    /**
     * The sound associated with the component.
     */
    private final String sound;

    /**
     * Constructs a new SoundComponent with the specified sound.
     *
     * @param sound the sound to set
     */
    public SoundComponent(String sound) {
        this.sound = sound;
    }

    /**
     * Retrieves the sound associated with the component.
     *
     * @return the sound
     */
    public String getSound() {
        return sound;
    }
}
