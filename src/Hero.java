public interface Hero {
    public void lvUp();
    public void attackTarget(Character a);
    public void getJobClass(String job);
    public void equip(Equiment a);
}
interface Magee extends Hero{
    void fireball(Character a);
}
interface Knightt extends Hero{
    public void swordDance();
}
interface Summonerr extends Magee{
    public void summonDemons();
}
interface ArchSwordmagee extends Magee, Knightt{
    void flameSword(Character target);
}
interface Warriorr extends Knightt{
    void quickSlash(Character target);
}

class Character implements Hero{
    protected String name;
    protected String job;
    protected int lv = 1;
    protected int atk, hp, def;

    Character(String name){
        this.name = name;
    }
    @Override
//    Increase level and some stat
//    effects: increase 1 level 5atk per level and 3def per level
    public void lvUp() {
        lv++;
        atk+= 5;
        def+= 3;
    }

    @Override
//    Select target to do damage
//    effects: decrease hp of target
//    @param Character target select only 1 target to do damage to target
    public void attackTarget(Character target) {
        target.hp = this.atk - target.def;
    }

    @Override
//    Select job for this hero
//    effects: change job for this hero
//    @param String job choose only 1 job for this hero
    public void getJobClass(String job) {
        this.job = job;
    }

    @Override
//    Equip an equipment for this hero
//    effects: iff this item is armor increase def iff neckless increase atk
//    @param Equipment item select only 1 item for this hero
    public void equip(Equiment item) {
        if(item instanceof Armor){
            def+= ((Armor) item).defenseIncrease();
        }
        else if(item instanceof Neckless){
            atk+= ((Neckless) item).attackIncrease();
        }
    }
}
class Mage extends Character implements Magee{
    Mage(String name) {
        super(name);
    }

    @Override
//    Select target to do damage
//    effects: decrease hp of target but damage increase 2 times of atk
//    @param Character target select only 1 target to do damage to target
    public void fireball(Character target) {
        target.hp = this.atk*2 - target.def;
    }
}
class Knight extends Character implements Knightt{
    Knight(String name){
        super(name);
    }

    @Override
//    increase permanent atk
//    effects:increase 2 times of atk permanent
    public void swordDance() {
        atk*=2;
    }
}
class Summoner extends Mage implements Summonerr{
    Summoner(String name){
        super(name);
    }

    class Demon{
        int atk;
        int summonerLV;
//        set damage for demon
//        effects: demon's damage equal 5times of user's level
//        @param Summoner a get level of Summoner a for calculate demon's damage
        public void getLevelOfSummoner(Summoner a){
            summonerLV = a.lv;
        }
        Demon(){
            atk = 5*summonerLV;
        }
    }

    @Override
//    summon demons
//    effects: generate 1 demon
    public void summonDemons() {
        Demon newbieDemon = new Demon();
    }
}
class ArchSwordMage extends Mage implements ArchSwordmagee{
    ArchSwordMage(String name){
        super(name);
    }

    @Override
    //    Select target to do damage
//    effects: decrease hp of target but damage increase 2 times of atk
//    @param Character target select only 1 target to do damage to target
    public void flameSword(Character target) {
        target.hp = this.atk*2 - target.def;
    }

    @Override
    //    increase permanent atk
//    effects:increase 2 times of atk permanent
    public void swordDance() {
        atk*= 2;
    }
}
class Warrior extends Knight implements Warriorr{
    Warrior(String name){
        super(name);
    }

    @Override
    //    Select target to do damage
//    effects: decrease hp of target but damage increase 2 times of atk
//    @param Character target select only 1 target to do damage to target
    public void quickSlash(Character target) {
        target.hp = this.atk*2 - target.def;
    }
}