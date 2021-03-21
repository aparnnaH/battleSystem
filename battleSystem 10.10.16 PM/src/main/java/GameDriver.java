import java.util.Scanner;

/**
 * Class to test and run the game 
 */
public class GameDriver {
	static Scanner scanner= new Scanner(System.in); //System.in is a standard input stream.

	public static void main(String[] args) {
		homescreen();

		Player player;
  		Player enemy;

		Move move1 = new Move("Vine Whip", "Grass", 45, 1.0f);
		Move move2 = new Move("Tackle", "Normal", 50, 1.0f);
		Move move3 = new Move("Take Down", "Normal", 90, 0.85f);
		Move move4 = new Move("Razor Leaf", "Grass", 55, 0.95f);
		Monster bulbasaur = new Monster("Bulbasaur", "Grass", 240, 40, 49, 49, move1, move2, move3, move4);

		move1 = new Move("Thunder Shock", "Electric", 40, 1.0f);
		move2 = new Move("Quick Attack", "Normal", 30, 1.0f);
		move3 = new Move("Thunderbolt", "Electric", 95, 1.0f);
		move4 = new Move("Slam", "Normal", 85, 1.0f);
		Monster pikachu = new Monster("Pikachu", "Electric", 235, 90, 55, 40, move1, move2, move3, move4);

		move1 = new Move("Tackle", "Normal", 50, 1.0f);
		move2 = new Move("Facade", "Normal", 70, 1.0f);
		move3 = new Move("Self-Destruct", "Normal", 150, 1.0f);
		move4 = new Move("Hyper Beam", "Normal", 130, 0.90f);
		Monster sorlax = new Monster("Snorlax", "Normal", 360, 30, 110, 65, move1, move2, move3, move4);
		
		move1 = new Move("Scratch", "Normal", 40, 1.0f);
		move2 = new Move("Ember", "Fire", 40, 1.0f);
		move3 = new Move("Peck", "Flying", 35, 1.0f);
		move4 = new Move("Fire Spin", "Fire", 35, 0.85f);
		Monster torchic = new Monster("Torchic", "Fire", 240, 45, 60, 40, move1, move2, move3, move4);
		
		move1 = new Move("Smog", "Posion", 20, 0.7f);
		move2 = new Move("Shadow Ball", "Ghost", 80, 1.0f);
		move3 = new Move("Headbutt", "Normal", 70, 1.0f);
		move4 = new Move("Dark Pulse", "Dark", 75, 1.0f);
		Monster gengar = new Monster("Gengar", "Ghost", 260, 110, 65, 60, move1, move2, move3, move4);
		
		move1 = new Move("Scratch", "Normal", 40, 1.0f);
		move2 = new Move("Fury Swipes", "Normal", 18, 0.8f);
		move3 = new Move("Earthquake", "Ground", 90, 1.0f);
		move4 = new Move("Flash Cannon", "Steel", 85, 1.0f);
		Monster alolanDugtrio = new Monster("Alolan Dugtrio", "Ground", 240, 45, 60, 40, move1, move2, move3, move4);

		System.out.println("\nWhich battle do you want to play?");
		System.out.println("1. Bulbasaur vs Torchic" + "\n2. Pikachu vs Gengar" + "\n3. Snorlax vs Alolan Dugtrio");

		int option = scanner.nextInt();

		switch(option) {
  			case 1:
  				player = new HumanPlayer(bulbasaur);
  				enemy = new CPUPlayer(torchic);
			    break;
			case 2:
			    player = new HumanPlayer(pikachu);
  				enemy = new CPUPlayer(gengar);
				break;
			case 3:
			    player = new HumanPlayer(sorlax);
  				enemy = new CPUPlayer(alolanDugtrio);
				break;
			default:
			    player = new HumanPlayer(bulbasaur);
  				enemy = new CPUPlayer(torchic);
		}

		game(player, enemy);

	}

	public static void game(Player player, Player enemy) {
		while ((!player.hasLost()) && (!enemy.hasLost())) {
			// print both monsters' HP
			System.out.println("");
			System.out.printf("%s has %d HP\n", player.getMonster().getName(), player.getMonster().getHP());
			System.out.printf("%s has %d HP\n", enemy.getMonster().getName(), enemy.getMonster().getHP());
			
			// decide the next move
			int playerMove = player.chooseMove();
			int enemyMove = enemy.chooseMove();
			
			 //execute the next move
			if (player.isFasterThan(enemy)) {
				player.attack(enemy, player, playerMove);
				if (!enemy.hasLost()) {
					enemy.attack(player, enemy, enemyMove);
				}
			} else {
				enemy.attack(player, enemy, enemyMove);
				if (!player.hasLost()) {
					player.attack(enemy, player, playerMove);
				}
			}
		}
		
		if (player.hasLost()) {
			System.out.printf("\nYou and %s have lost the battle.\n", player.getMonster().getName());
		} else {
			System.out.printf("\nYou and %s are victorious!\n", player.getMonster().getName());
		}	
	}

	public static void homescreen(){
		System.out.println("______     _                               ______       _   _   _       ");
		System.out.println("| ___ \\   | |                              | ___ \\     | | | | | |      ");
		System.out.println("| |_/ /__ | | _____ _ __ ___   ___  _ __   | |_/ / __ _| |_| |_| | ___  ");
		System.out.println("|  __/ _ \\| |/ / _ \\ '_ ` _ \\ / _ \\| '_ \\  | ___ \\/ _` | __| __| |/ _ \\ ");
		System.out.println("| | | (_) |   <  __/ | | | | | (_) | | | | | |_/ / (_| | |_| |_| |  __/ ");
		System.out.println("\\_|  \\___/|_|\\_\\___|_| |_| |_|\\___/|_| |_| \\____/ \\__,_|\\__|\\__|_|\\___| ");

		return;
	}


}
