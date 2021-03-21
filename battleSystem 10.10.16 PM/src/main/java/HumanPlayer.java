import java.util.Scanner;
import java.util.Random;

/**
 * A child class that implements from it's parent class Player
 */
public class HumanPlayer extends Player{
    Scanner scanner= new Scanner(System.in); //System.in is a standard input stream.
    /**
    * An instance variable from the Monster class to represent the player's battling monster
    */ 
    private Monster monster;

    /**
    * A constructor for class HumanPlayer
    * @param monster  to initialize the monster member variable
    */
    public HumanPlayer(Monster monster){
        this.monster = monster;
    }
    
    /**
    * A get method to return the value of monster
    * @return   the value of monster
    */
    public Monster getMonster(){ return monster;}

    /**
    * Ask user to input an option for player's move from 1-4 
    *
    * @return   the user's integer option for this player's move
    */
    public int chooseMove(){
        System.out.println("1." + monster.getMove1().getName() + "\n2." + monster.getMove2().getName() + "\n3." + monster.getMove3().getName() + "\n4." + monster.getMove4().getName());
        System.out.println(monster.getName() + " which move would you like to use to attck? Enter the number corresponding to your option: ");
        int option = scanner.nextInt();

        return option;
    
    }

    /**
    * Function to determine if player is alive (true if hp>0 and false if hp<=0)
    *
    * @return   true or false depending on player's hp
    */
    public Boolean hasLost(){
        if (monster.getHP()<=0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
    * Boolean function to determine which player goes first (player with higher speed)
    *
    * @param opponent   the enemy which this player is battling
    * @return           true or false depending on player and enemy's speed
    */
    public Boolean isFasterThan(Player opponent){
        if (this.monster.getSpeed() > opponent.getMonster().getSpeed()){
            return true;
        }
        else{ 
            return false; 
        }
    }
   
    /**
    * Function which displays the battle with damage dealt and updates enemy's hp
    *
    * @param monster       the player
    * @param opponent      the enemy which this player is battling
    * @param moveOption    the integer representing the option of player's move
    * 
    */
   public void attack(Player monster, Player opponent, int moveOption){
    Random random = new Random();
    float randNum = random.nextFloat() * (1.0f - 0.0f) + 0.0f;
    if (moveOption == 1){
        System.out.println(this.monster.getName() + " uses " + this.monster.getMove1().getName() + ".");
        if (randNum > this.monster.getMove1().getAccuracy()){
            System.out.println(this.monster.getName() + " misses and no damage is done!");
        }
        else{
            int damageDealt = this.monster.getAttack() + this.monster.getMove1().getPower() - monster.getMonster().getDefense();
            monster.getMonster().calculateHP(damageDealt);
            System.out.println(this.monster.getName() + " hits for " + damageDealt + " points of damage.");  
        }
    }
    else if (moveOption == 2){
        System.out.println(this.monster.getName() + " uses " + this.monster.getMove2().getName() + ".");
        if (randNum > this.monster.getMove2().getAccuracy()){
            System.out.println(this.monster.getName() + " misses and no damage is done!");
        }
        else{
            int damageDealt = this.monster.getAttack() + this.monster.getMove2().getPower() - monster.getMonster().getDefense();
            monster.getMonster().calculateHP(damageDealt);
            System.out.println(this.monster.getName() + " hits for " + damageDealt + " points of damage.");  
        }  
    }
    else if (moveOption == 3){
        System.out.println(this.monster.getName() + " uses " + this.monster.getMove3().getName() + ".");
        if (randNum > this.monster.getMove3().getAccuracy()){
            System.out.println(this.monster.getName() + " misses and no damage is done!");
        }
        else{
            int damageDealt = this.monster.getAttack() + this.monster.getMove3().getPower() - monster.getMonster().getDefense();
            monster.getMonster().calculateHP(damageDealt);
            System.out.println(this.monster.getName() + " hits for " + damageDealt + " points of damage.");  
        }
    }
    else{
        System.out.println(this.monster.getName() + " uses " + this.monster.getMove4().getName() + ".");
        if (randNum > this.monster.getMove4().getAccuracy()){
            System.out.println(this.monster.getName() + " misses and no damage is done!");
        }
        else{
            int damageDealt = this.monster.getAttack() + this.monster.getMove4().getPower() - monster.getMonster().getDefense();
            monster.getMonster().calculateHP(damageDealt);
            System.out.println(this.monster.getName() + " hits for " + damageDealt + " points of damage.");  
        }
    }

    }
    

    

}