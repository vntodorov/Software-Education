package ExamPreparation.viceCity.models.guns;

import static ExamPreparation.viceCity.common.ExceptionMessages.*;

public abstract class BaseGun implements Gun {

    private String name;

    private int bulletsPerBarrel;

    private int totalBullets;

    private boolean canFire;

    protected BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        setName(name);
        setBulletsPerBarrel(bulletsPerBarrel);
        setTotalBullets(totalBullets);
        setCanFire();
    }

    protected void setCanFire() {
        if (bulletsPerBarrel > 0) {
            this.canFire = true;
        } else {
            this.canFire = false;
        }
    }

    protected void setTotalBullets(int totalBullets) {
        if (totalBullets < 0) {
            throw new IllegalArgumentException(TOTAL_BULLETS_LESS_THAN_ZERO);
        }
        this.totalBullets = totalBullets;
    }

    protected void setBulletsPerBarrel(int bulletsPerBarrel) {
        if (bulletsPerBarrel < 0) {
            throw new IllegalArgumentException(BULLETS_LESS_THAN_ZERO);
        }
        this.bulletsPerBarrel = bulletsPerBarrel;

    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(NAME_NULL);
        }
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        return canFire;
    }

    @Override
    public int getTotalBullets() {
        return totalBullets;
    }

}
