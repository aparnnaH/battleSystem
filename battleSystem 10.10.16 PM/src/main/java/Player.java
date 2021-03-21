/**
 * Player is an abstract class with abstract methods 
 * It is the Parent class of the HumanPlayer and CPUPlayer classes
 * Player is associated with the Monster class (composition)
 */
public abstract class Player{
    /**
    * An instance variable from the Monster class to represent the player's battling monster
    */ 
    private Monster monster;
    
    public Monster getMonster() {return monster;} 

    //abstract functions which the classes inheriting this class will implement
    public abstract Boolean hasLost();
    public abstract int chooseMove();
    public abstract Boolean isFasterThan(Player opponent);
	public abstract void attack(Player player, Player enemy, int numOption);    
}