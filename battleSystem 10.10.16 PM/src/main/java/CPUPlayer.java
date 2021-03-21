import java.util.Random;

/**
 * A child class that implements from it's parent class Player
 */
public class CPUPlayer extends Player{
    /**
    * An instance variable from the Monster class to represent the player's battling monster
    */ 
    private Monster monster;

    /**
    * A constructor for class CPUPlayer
    * @param monster  to initialize the monster member variable
    */
    public CPUPlayer(Monster monster){
        this.monster = monster;
    }

    /**
    * A get method to return the value of monster
    * @return   the value of monster
    */
    public Monster getMonster(){ return monster;}
    
    /**
    * Generate a random number between 1-4 to decide on which move to use
    *
    * @return   the randomly generated integer for this player's move
    */
    public int chooseMove(){
        Random random = new Random();
        int moveOption = random.nextInt(4 - 1 + 1) +1;
        return moveOption;
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
        if (monster.getSpeed() > opponent.getMonster().getSpeed())
        {
            return true;
        }
        else{ 
            return false; 
        }
    }

    /**
    * Function which displays the battle with damage dealt and updates enemy's hp
    *
    * @param monster       the CPU
    * @param opponent      the enemy which this player is battling
    * @param moveOption    the integer representing the option of player's move
    */
    public void attack(Player monster, Player opponent, int moveOption){
        // Monster AI
        // Depending on the damage dealt, the AI will choose the most appropiate move

        int damageDealt[] = {0, 0, 0, 0};
        int power[] = {this.monster.getMove1().getPower(), this.monster.getMove2().getPower(), this.monster.getMove3().getPower(), this.monster.getMove4().getPower()};
        for (int i = 0; i < 4; i++) {
            damageDealt[i] = this.monster.getAttack() + power[i] - monster.getMonster().getDefense();
            if (opponent.getMonster().getHP() < damageDealt[i]) {
                monster.getMonster().calculateHP(damageDealt[i]);
                System.out.println(this.monster.getName() + " hits for " + damageDealt[i] + " points of damage.");  
                return;
            }
        }

        //Find the greatest damage by sorting
        int temp;  
        for (int k = 0; k < 4; k++) {  
            for (int j = k + 1; j < 4; j++) {  
                if (damageDealt[k] > damageDealt[j]) {  
                    temp = damageDealt[k];  
                    damageDealt[k] = damageDealt[j];  
                    damageDealt[j] = temp;  
                }  
            }  
        }  
        //largest damageDealt is damageDealt[3]
        monster.getMonster().calculateHP(damageDealt[3]);
        System.out.println(this.monster.getName() + " hits for " + damageDealt[3] + " points of damage.");  
     }
}
