package index;

abstract class Entity {
	private double hp;
	private double basedmg;
	
	public Entity(int hp, int basedmg) {
		super();
		this.hp = hp;
		this.basedmg = basedmg;
	}
	
	public void attack(Entity enemy) {
		int dmg = 0;
		dmg = (int) (Math.random() * (this.getBasedmg()));
		System.out.println("You hit the enemy for " + dmg + " HP");
		double total = enemy.getHp() - dmg;
		enemy.setHp(total);
	}
	
	public void takeDamage(Entity enemy) {
		int atk = 0;
		atk = (int) (Math.random() * (enemy.getBasedmg()));
		if(enemy instanceof thief) {
			System.out.println("Thief hit you for " + atk + " HP");
		} else {
			System.out.println("Goblin hit you for " + atk + " HP");
		}
		double total = this.hp - atk;
		this.setHp(total);
	}

	public double getHp() {
		return hp;
	}

	public void setHp(double d) {
		this.hp = d;
	}

	public double getBasedmg() {
		return basedmg;
	}

	public void setBasedmg(double d) {
		this.basedmg = d;
	}
}
