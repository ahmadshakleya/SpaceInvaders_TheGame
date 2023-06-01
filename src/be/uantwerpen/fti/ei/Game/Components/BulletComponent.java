package be.uantwerpen.fti.ei.Game.Components;

public class BulletComponent {
    private boolean BulletActief;

    public BulletComponent(boolean bulletActief) {
        BulletActief = bulletActief;
    }

    public boolean isBulletActief() {
        return BulletActief;
    }

    public void setBulletActief(boolean bulletActief) {
        BulletActief = bulletActief;
    }
}
