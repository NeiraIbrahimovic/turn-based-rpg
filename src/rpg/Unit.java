package rpg;
import java.util.Random;

/**
 * Represents a unit that can belong to either the computer or human player.
 */
public class Unit {

  /**
   * The unit's name.
   */
  String name;

  /**
   * The unit's level, which is randomly generated based on a given level range.
   */
  private int level = 0;

  /**
   * The unit's job, such as mage, knight or archer.
   */
  private String job;

  /**
   * The unit's current health points or HP.
   */
  private int hp = 0;

  /**
   * The unit's attack stat, which is determined by level and impacts damage dealt to a target.
   */
  private int attack = 0;

  /**
   * The unit's defense stat, which is determined by level and impacts damage received by this unit.
   */
  private int defense = 0;

  /**
   * The unit's temporary defense stat, which is granted by the "block" move.
   */
  private int temporaryDefense = 0;

  /**
   * The unit's evasion stat, which is determined by level and impacts whether this unit dodges the incoming attack.
   */
  private int evasion = 0;

  /**
   * A random number generator to be used in this class.
   */
  Random random = new Random();

  /**
   * Constructs a unit by assigning the given name and job as well as calculating other stats.
   * The level must be randomly generated given the level range that is passed.
   * @param name String representing the name of this unit
   * @param levelRange String representing the level range of this unit, such as low, medium or high
   * @param job String representing the job of this unit
   */
  public Unit(String name, String levelRange, String job){

    // Students: your code goes here.

    // Assign name and job to this unit based on given parameters
	  this.name = name; // assign name to unit
	  this.job = job; //assign job to unit
	  
    /*
     * Randomly assign this unit's level based on the given levelRange
     *   - "low" means the level can be set to an int from 1 to 3
     *   - "medium" means the level can be set to an int from 4 to 6
     *   - "high" means the level can be set to an int from 7 to 10
     */
	  
	  //Randomly assign an int from 1 to 3 for levelRange "low"
	  if(levelRange == "low"){
		this.level = this.random.nextInt(3) + 1; //generate a random integer from 0 to 2, then add 1, so generate a random int 1 to 3
	  }
	  //Randomly assign an int from 4 to 6 for levelRange "medium"
	  else if(levelRange == "medium"){
		this.level = this.random.nextInt(3) + 4; //generate a random integer from 0 to 2, then add 4, so generate a random int 4 to 6
	  }
	  //Randomly assign an int from 7 to 10 for levelRange "high"
	  else{
		this.level = this.random.nextInt(3) + 7; //generate a random integer from 0 to 2, then add 7, so generate a random int 7 to 10
	  }

    /*
     *Calculate and assign this unit's stats of hp, attack, defense and evasion.
     *  calculate and set the multiplier variable to a tenth of the level. Ex: (this.level / 10)
     *  multiply the calculated multiplier with the stat's specific max value, which are given below.
     *  - max HP value: 100
     *  - max attack value: 20
     *  - max defense: 20
     *  - max evasion: 5
     * Hint: avoid integer division by using decimals and round the final value to an integer
     * set the rounded value to this unit's stat (Ex: this.hp)
     */
	  
	    //Calculate the multiplier based on the level (e.g., level / 10.0)
	  		double multiplier = this.level / 10.0;
	    
	    //Calculate and assign this unit's hp stats
	  		this.hp = (int)Math.round(multiplier * 100); //multiply the multiplier with the max HP value, round the value, then cast to an int
	
	    //Calculate and assign this unit's attack stats
	  		this.attack = (int)Math.round(multiplier * 20); //multiply the multiplier with the max attack value, round the value, then cast to an int
	  		
		//Calculate and assign this unit's defense stats
	  		this.defense = (int)Math.round(multiplier * 20); //multiply the multiplier with the max defense value, round the value, then cast to an int
	  		
	  	//Calculate and assign this unit's evasion stats
	  		this.evasion = (int)Math.round(multiplier * 5); //multiply the multiplier with the max evasion value, round the value, then cast to an int  
  }

  // Getters and Setters

  /**
   * Returns this unit's level.
   * Note: This method does not take any parameters.
   * @return level
   */
  public int getLevel() {

    // Students: your code goes here.
	  return this.level;

  }

  /**
   * Returns this unit's job.
   * Note: This method does not take any parameters.
   * @return job
   */
  public String getJob() {

    // Students: your code goes here.
	  return this.job;

  }

  
  /**
   * Returns this unit's hp.
   * Note: This method does not take any parameters.
   * @return hp
   */
  public int getHp() {

    // Students: your code goes here.
	  return this.hp;

  }

  /**
   * Sets this unit's hp stat to the given hp.
   * Note: This method does not return anything.
   * @param hp int representing given health points value
   */
  public void setHp(int hp) {

    // Students: your code goes here.
	  this.hp = hp;

  }

  /**
   * Sets this unit's temporary defense stat to the given temporary defense.
   * Note: This method does not return anything.
   * @param temporaryDefense int representing given temporary defense value
   */
  public void setTemporaryDefense(int temporaryDefense) {

    // Students: your code goes here.
	  this.temporaryDefense = temporaryDefense;

  }

  /**
   * DO NOT MODIFY, REQUIRED FOR TESTING
   *
   * Returns this unit's temporary defense stat.
   * Note: This method does not take any parameters.
   * @return temporaryDefense
   */
  public int getTemporaryDefense() {
    return this.temporaryDefense;
  }

  /**
   * DO NOT MODIFY, REQUIRED FOR TESTING
   *
   * Sets this unit's evasion stat to the given evasion value.
   * Note: This method does not return anything.
   * @param evasion int representing given value for evasion
   */
  public void setEvasion(int evasion) {
    this.evasion = evasion;
  }

  /**
   * Prints the unit's name, level, job, and remaining HP.
   * If the unit has no remaining hp, prints that this unit is knocked out.
   * Note: This method does not take any parameters and does not return anything.
   */
  public void printCurrentStatus(){

    // Students: your code goes here.
	  
	  // if hp is less than or equal to 0, print that the unit is knocked out
	  if(this.hp < 1) {
		  System.out.println(this.name + " is knocked out and cannot move.");
	  }
	  // otherwise, print unit's name, level, job, and remaining HP
	  else {
		  System.out.println(this.name + " is a level " + this.level + " " + this.job + " with " + this.hp + " HP remaining.");
	  }

  }

  /**
   * Calculates damage based on this unit's attack stat, maximum attack, and attacker strength relative to target.
   * @param attackerStrength String representing the attacker's strength relative to the target
   * @return int representing the total damage this unit will deal when attacking
   */
  public int attack(String attackerStrength){

    // Students: your code goes here.

    /*
     * Check the value of attackerStrength to determine the multiplier which will be applied to the damage
     *  later in this method
     *   - "same" results in an unchanged multiplier of 1.0
     *   - "strong" results in a multiplier that will increase the damage by 20%
     *   - "weak" results in a multiplier that halves damage or decreases by 50%
     */
	  
	// Initialize a multiplier variable to 1.0, assuming a neutral strength as the default
	// Don't need an if statement for "same" attackerStrength because this will result in an unchanged multiplier
	  double multiplier = 1.0;
	
	// If attackerStrength is "strong", set multiplier to 1.2 to represent a 20% increase in damage
	  if(attackerStrength.equals("strong")) {
		  multiplier = 1.2;
	  }

	// If attackerStrength is "weak", set multiplier to 0.5 to represent a 50% reduction in damage
	  if(attackerStrength.equals("weak")) {
		  multiplier = 0.5;
	  }

    //Assign attackMax variable to the maximum attack value of 50.0
	  double attackMax = 50.0;

    //Get the raw damage by dividing this unit's attack stat by 30.0 then multiplying this by the max attack value
	  double rawDamage = (this.attack/30.0) * attackMax;

    //Multiply the raw damage by the multiplier variable you assigned above
    // Hint: make sure to round and convert to an integer before returning the result
	  int damage = (int)Math.round(rawDamage * multiplier);

	// Return the total damage this unit will deal when attacking
	  return damage;
  }

  /**
   * Provides temporary defensive buff to reduce damage taken during the current turn.
   * Note: This method does not take any parameters and does not return anything.
   */
  public void block(){

    // Students: your code goes here.
	
	this.temporaryDefense += 2; //Add 2 points to the temporaryDefense stat

  }

  /**
   * Uses this unit's evasion, temporaryDefense, and defense stats to either dodge the attack or adjust damage.
   * If the attack is not dodged, applies the adjusted damage to this unit's remaining HP.
   * Prints a message containing the damage received and the remaining HP.
   * Note: This method does not return anything.
   * @param damage int representing the incoming damage from an opposing unit
   */
  public void receiveDamage(int damage){

    // Students: your code goes here.
    
    /*
     * Perform evasion check to determine whether this unit will take damage:
     *   - generate a random number between 0 and 20
     *   - if the number is less than or equal to this unit's evasion stat, the unit will dodge the attack
     *   - if the attack is dodged, print a message and return out of this method
     */
	  
	  // Check if unit has evasion stat greater than 0
	  if(this.evasion > 0) {
		// If evasion stat is greater than 0, generate a random number between 0 and 20 and store it in variable
		  int randomNumber = this.random.nextInt(21);
		  
		// If generated number is less than or equal to the unit's evasion stat, the unit successfully dodges or avoids the attack
		  if(randomNumber <= this.evasion) {
			  System.out.println(this.name + " dodged!"); //print statement that the unit dodged the attack
			  return; // return out of the method
		  }
	  }
    

    // Calculate the defense adjustment by adding this unit's defensive stats (temporary and normal defense)
    // divide this sum by 10.0
	// cast to float
	  float defenseAdjustment = (float) ((this.temporaryDefense + this.defense)/ 10.0 );

    //Calculate the actual damage received by dividing the given damage value by the calculated defense adjustment
	//Round to nearest integer
	  int damageReceived = (int)Math.round(damage/defenseAdjustment); //cast to int after rounding

    //Update this unit's HP stat by subtracting the damage
	  this.hp -= damageReceived;  

    //Set this unit's HP to 0 if the damage received exceeds the remaining HP
	//Check if resulting HP is less than or equal to 0
	  if(this.hp <= 0) {
		  //If so, set unit's HP to 0 to prevent negative values from being displayed
		  this.hp = 0;
	  }

    //Print how much damage was received and the remaining HP
	  System.out.println(this.name + " takes " + damageReceived + " damage. Remaining HP: " + this.hp);
  }
}