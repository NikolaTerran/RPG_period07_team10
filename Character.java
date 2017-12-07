public class Character {

    public int hp;
    public int strength;
    public int defense;
    public double attackrating;
	public String name;

    public boolean isAlive() {
        return hp > 0;
    }

    public int getDefense() {
        return defense;
    }

    public void lowerHP(int dec) {
        hp -= dec;
    }

    public int attack(Protagonist protagonist) {
	int damage = (int) (strength * attackrating - protagonist.getDefense());
	protagonist.lowerHP(damage);
	return damage;
    }

    public int attack(Monster monster) {
	int damage = (int) (strength * attackrating - monster.getDefense());
	monster.lowerHP(damage);
	return damage;
    }

	public String toString(){
		this.toString();
	}
}
