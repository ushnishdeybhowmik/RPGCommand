public class Character {
    private int atk;
    private int def;
    private int energy;
    private int xp;
    private int level;
    private int money;
    private int health;
    private String name;
    private String uid;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
        this.level = this.xp / 200;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Character(int atk, int def, int energy, int xp, int level, int money, int health, String name, String uid) {
        this.atk = atk;
        this.def = def;
        this.energy = energy;
        this.xp = xp;
        this.level = level;
        this.money = money;
        this.health = health;
        this.name = name;
        this.uid = uid;
    }

    public Character(int atk, int def, int energy, int xp, int level, int money, int health, String name) {
        this.atk = atk;
        this.def = def;
        this.energy = energy;
        this.xp = xp;
        this.level = level;
        this.money = money;
        this.health = health;
        this.name = name;
    }

    public Character(String name, String uid) {
        this.name = name;
        this.uid = uid;
        this.atk = 25;
        this.def = 25;
        this.energy = 1000;
        this.xp = 0;
        this.health = 100;
        this.money = 500;
        this.level = this.xp / 200;
    }
}
