package be.uantwerpen.fti.ei.Game.Components;

public class BonusComponent {
    private boolean bonusActief;

    public BonusComponent(boolean bonusActief) {
        this.bonusActief = bonusActief;
    }

    public boolean isBonusActief() {
        return bonusActief;
    }

    public void setBonusActief(boolean bonusActief) {
        this.bonusActief = bonusActief;
    }
}
