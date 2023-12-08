import java.util.Random;
public interface Equiment_ {
    String getDescribe();
}
interface Armor_ extends Equiment_{
    int defenseIncrease();
}
interface Neckless_ extends Equiment_{
    int attackIncrease();
}
interface MagicArmor_ extends Armor_{
    int perfectGuard();
}
interface HolyArmor_ extends Armor_{
    int healing();
}
interface AncientNeckless_ extends Neckless_{
    int criticalHit();
}
class Equiment implements Equiment_{
    protected String discription;
    Equiment(String discribe){
        this.discription = discribe;
    }
//    Show describe of this equipment
//    @return describe of this equipment
    @Override
    public String getDescribe() {
        return discription;
    }
}
class Armor extends Equiment implements Armor_{
    Armor(String discribe){
        super(discribe);
    }

    @Override
//    Increase hero's defense who equip this armor
//    @return increase def 8 units(fixed number)
    public int defenseIncrease() {
        return 8;
    }
}
class Neckless extends Equiment implements Neckless_{
    Neckless(String describe){
        super(describe);
    }

    @Override
//    Increase hero's attack who equip this neckless
//    @return increase atk 15 units(fixed number)
    public int attackIncrease() {
        return 15;
    }
}
class MagicArmor extends Armor implements MagicArmor_{
    MagicArmor(String discribe){
        super(discribe);
    }

    @Override
//    Have a change for no damage when got attacked
//    @return def 8888(can block any damage) iff true
    public int perfectGuard() {
        Random random = new Random();
        boolean randomBoolean = random.nextBoolean();
        if(randomBoolean){
            return 8888;
        }
        else return 8;
    }
}
class HolyArmor extends Armor implements HolyArmor_{
    HolyArmor(String discribe){
        super(discribe);
    }

    @Override
//    Healing hero's hp who equip this equipment
//    @return healing hp 30(fix numbered) units
    public int healing() {
        return 30;
    }
}
class AncientNeckless extends Neckless implements AncientNeckless_{
    AncientNeckless(String describe) {
        super(describe);
    }

    @Override
//    Random power of critical damages
//    @return atk can increase 1 to 3 times
    public int criticalHit() {
        Random random = new Random();
        int critical = random.nextInt(1, 3);
        return critical;
    }

    @Override
//    Increase damage
//    @return damage can increase from atk 1 to 3 times
    public int attackIncrease() {
        return 15*criticalHit();
    }
}
