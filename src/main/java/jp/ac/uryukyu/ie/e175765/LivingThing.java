package jp.ac.uryukyu.ie.e175765;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    //コンストラクタ
    public LivingThing(String name, int hitPoint, int attack) {
        this.name = name;
        this.hitPoint = hitPoint;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, hitPoint, attack);
    }
    //カプセル化
    //hitPoint's getter
    public int getHitPoint() {
        return hitPoint;
    }
    //hitPoint's setter
    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    //dead's getter
    public boolean isDead() {
        return dead;
    }
    //dead's setter
    public void setDead(boolean dead) {
        this.dead = dead;
    }

    //name's getter
    public String getName() {
        return name;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }
    public int getAttack() { return attack; }




    public void attack(LivingThing bio){
        if(!this.dead){
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, bio.getName(), damage);
            bio.wounded(damage);
        }

    }

    public void wounded(int damage) {
        hitPoint -= damage;
        if(hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }



}

