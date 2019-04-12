package rplg_lab;

public interface Target {


    int getHealth();

    void takeAttack(int attackPoints);


    int giveExperience();


    boolean isDead();

    Axe getLoot();
}


