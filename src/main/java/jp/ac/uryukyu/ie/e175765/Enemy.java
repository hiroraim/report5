package jp.ac.uryukyu.ie.e175765;

public class Enemy extends LivingThing {
    public Enemy(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);

    }
    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */

    @Override
    public void wounded(int damage){
        setHitPoint(getHitPoint() - damage);
        if( getHitPoint() < 0 ) {
            setDead(true) ;
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }

    public void attack(LivingThing bio) {
        if(!isDead()){
            int damage = (int) (Math.random() * getAttack());
            int r = (int)(Math.random()*100);
            if (r <= 30 && damage >0) {
                damage = damage * 2;
                System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", getName(), bio.getName(), damage);
                bio.wounded(damage);
            }else{
                switch (damage) {
                    case 0:
                        System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), bio.getName(), damage);
                        break;
                    default:
                        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), bio.getName(), damage);
                        bio.wounded(damage);
                }
            }
        }

    }
}