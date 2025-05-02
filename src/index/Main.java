package index;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	ArrayList<Entity> entity = new ArrayList<>();
	ArrayList<String> rewards = new ArrayList<>();
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		entity.add(new player(100, 20, null));
		entity.add(new goblin(80, 20));
		entity.add(new thief(60, 15));
		rewards.add("Excalibur");
		rewards.add("Ring of Health");
		
		int menu = 0;
		
		do {
			System.out.println();
			System.out.println("Dark Knight");
			System.out.println("1. Play");
			System.out.println("2. Exit");
			System.out.print(">> ");
			menu = scan.nextInt();
			scan.nextLine();
			
			switch (menu) {
			case 1:
				start();
				break;

			default:
				break;
			}
		} while (menu != 2);
	}
	
	public void start() {
		String name = "";
		
		do {
			System.out.print("Input name [>=5]: ");
			name = scan.nextLine();
		} while (name.length() < 5);
		System.out.println("Welcome to Dark Knight, " + name);
		System.out.print("Press Enter to continue...");
		scan.nextLine();
		
		battle();
	}
	
	public void battle() {
		Random random = new Random();
		int randomIdx = random.nextInt(entity.size());
		Entity randomElement = entity.get(randomIdx);
		double simpenHP = randomElement.getHp();
		do {
			System.out.println();
			System.out.println("Your HP : " + entity.get(0).getHp());
			System.out.println("Your Damage : " + entity.get(0).getBasedmg());
			System.out.println("-------");
			if(!(entity.get(1) instanceof player)) {
				if(randomElement instanceof goblin) {
					System.out.println("Enemy is : Goblin");
					System.out.println("Enemy HP : " + randomElement.getHp());
				} else if(randomElement instanceof thief) {
					System.out.println("Enemy is : Thief");
					System.out.println("Enemy HP : " + randomElement.getHp());
					double chance = 0.25; // 30% probability
			        if (Math.random() < chance) {
			        	System.out.println();
			            System.out.println("Oh no... Somehow you lost your item");
			            System.out.print("Press Enter to continue...");
			            scan.nextLine();
			            System.out.println();
			        }
				} else {
					System.out.println("The Enemy is yourself hahaha..");
					break;
				}
			}
			entity.get(0).attack(randomElement);
			entity.get(0).takeDamage(randomElement);
			System.out.print("Press Enter to continue...");
			scan.nextLine();
		} while(randomElement.getHp() > 0 && entity.get(0).getHp() > 0);
		
		if(randomElement.getHp() <= 0) {
			double chances = 0.25; // 30% probability
	        if (Math.random() < chances) {
	        	Random rands = new Random();
				int randomIdx2 = rands.nextInt(rewards.size());
				String randomRewards = rewards.get(randomIdx2);
				System.out.println();
				if(randomRewards.equals("Excalibur")) {
					System.out.println("You obtained Excalibur!");
					System.out.println("Increase the wearer's damage by 10%");
					double temp = 20;
					double temp2 = temp * 0.1;
					entity.get(0).setBasedmg(temp + temp2);
					entity.get(0).setHp(100);
				} else {
					System.out.println("You obtained Ring of Health!");
					System.out.println("Increase the wearer's HP by 40%");
					double temp = 100;
					double temp2 = temp * 0.4;
					entity.get(0).setHp(temp + temp2);
					entity.get(0).setBasedmg(20);
				}
				randomElement.setHp(simpenHP);
				System.out.print("Press Enter to continue...");
				scan.nextLine();
	        } else {
	        	System.out.println();
	        	System.out.println("You Won!");
	        	System.out.print("Press Enter to continue...");
	        	scan.nextLine();
	        }
		} else if (entity.get(0).getHp() <= 0) {
			System.out.println("You died...");
			return;
		}
	}

}
