package rpg;
import java.util.Random;
import java.util.Scanner;

/**
 * Represents the human player and holds their units in this role-playing game.
 */
public class HumanPlayer {

  /**
   * Human Unit 1: Falia
   */
  Unit falia;

  /**
   * Human Unit 2: Erom
   */
  Unit erom;

  /**
   * Human Unit 3: Ama
   */
  Unit ama;

  /**
   * A random number generator to be used for returning random levels and jobs.
   */
  Random random = new Random();

  /**
   * A scanner to be used for selecting moves and targets.
   */
  Scanner scan = new Scanner(System.in);

  /**
   * Constructs a human player.
   */
  public HumanPlayer(){
    this.falia = new Unit("Falia", generateLevel(),generateJob());
    this.erom = new Unit("Erom", generateLevel(),generateJob());
    this.ama = new Unit("Ama", generateLevel(),generateJob());
  }

  // Getters and Setters

  /**
   * Returns the falia Unit.
   * Note: This method does not take any parameters.
   * @return falia
   */
  public Unit getFalia(){
    return falia;
  }

  /**
   * Returns the erom Unit.
   * Note: This method does not take any parameters.
   * @return erom
   */
  public Unit getErom() {
    return erom;
  }

  /**
   * Returns the ama Unit.
   * Note: This method does not take any parameters.
   * @return ama
   */
  public Unit getAma() {
    return ama;
  }

  /**
   * Randomly chooses a string representing the level of a unit by generating a random integer.
   * There are three possible levels: low, medium, high.
   * Note: This method does not take any parameters.
   * @return String of the generated level of a human's unit
   */
  private String generateLevel(){
    String generatedLevel;

    // generate a random integer from 0 to 2
    int randomInt = this.random.nextInt(3);

    // assign generatedLevel a level based on randomInt's value
    if(randomInt == 0){
      generatedLevel = "low";
    }
    else if(randomInt == 1){
      generatedLevel = "medium";
    }
    else{
      generatedLevel = "high";
    }

    return generatedLevel;
  }

  /**
   * Randomly chooses a string representing the job of a unit by generating a random integer.
   * There are three possible jobs: mage, knight, archer.
   * Note: This method does not take any parameters.
   * @return String of the generated job a human's unit will take on
   */
  private String generateJob(){
    String generatedJob;

    // generate a random integer from 0 to 2
    int randomInt = this.random.nextInt(3);

    // assign generatedJob a level based on randomInt's value
    if(randomInt == 0){
      generatedJob = "mage";
    }
    else if(randomInt == 1){
      generatedJob = "knight";
    }
    else{
      generatedJob = "archer";
    }

    return generatedJob;
  }

  /**
   * Checks if the user entered a valid move string, meaning it begins with one of the following letters: 'a' 'A' 'b' 'B'
   * Prints a friendly message to enter a valid input and returns null if the string is invalid.
   * @param move String representing the move to be performed by a human unit, for example, "attack" or "block"
   * @return String of "attack" or "block" or null
   */
  public String validateMove(String move){

    // Students: your code goes here.
	  
	//Convert move string to lowercase to ensure method is case-sensitive
	  move = move.toLowerCase();
	 
	//Check first letter of move
	  //if first letter is 'a', return string "attack"
	  if(move.charAt(0) == 'a'){
		  return "attack"; 
	  }
	 //if first letter is 'b', return string "block"
	  else if(move.charAt(0) == 'b') {
		  return "block";  
	  }
	 
	 //if first letter is neither 'a' nor 'b', print friendly message to prompt player to input a correct move
	  else{
			  System.out.println("Please enter a valid move.");
			  return null; //return null to indicate the move was invalid  
	  }
		
   }  
 
	  /**
	   * Checks if the computer target selected by the human is alive and returns said target if it exists.
	   * If the target with the given name is not alive or does not exist, print a message saying so and return null.
	   * @param targetName String that should be the name of a computer unit
	   * @param computer ComputerPlayer that the human is currently playing against
	   * @return Unit representing the target belonging to the computer or null
	   */
	  public Unit selectTarget(String targetName, ComputerPlayer computer) {
	   
     // Students: your code goes here.
		  
		  
	// Check if the target name matches Criati
	   if (targetName.equalsIgnoreCase("Criati")) {
		   // Check if Criati's HP is greater than 0
	       if (computer.getCriati().getHp() > 0) {
	    	   // If Criati is alive, return Unit criati object
	           return computer.getCriati();
	     } else {
	    	 //If Criati is not alive, print informative message and return null
	         System.out.println("Criati has already been vanquished.");
	         return null;
	      }
	  }

	 // Check if the target name matches Ledde
	    if (targetName.equals("Ledde")) {
	    	// Check if Ledde's HP is greater than 0
	        if (computer.getLedde().getHp() > 0) {
	        	// If Ledde is alive, return Unit criati object
	            return computer.getLedde();
	      } else {
	    	   //If Ledde is not alive, print informative message and return null
	            System.out.println("Ledde has already been vanquished.");
	            return null;
	        }
	    }

	   // Check if the target name matches Tyllion
	    if (targetName.equals("Tyllion")) {
	    	// Check if Tyllion's HP is greater than 0
	        if (computer.getTyllion().getHp() > 0) {
	        	// If Tyllion is alive, return Unit criati object
	              return computer.getTyllion();
	       } else {
	    	 //If Tyllion is not alive, print informative message and return null
	            System.out.println("Tyllion has already been vanquished.");
	            return null;
	        }
	    }

	      // If none of the names match, print a message and return null
	      System.out.println("The target is not a member of the enemy's forces.");
	      return null;
  }

  /**
   * Determines the strength of the attacker by comparing the attacker's job and the job of the target.
   * Mages are strong against knights, but weak against archers. Knights are strong against archers, but weak against mages.
   * There are three possible attacker strengths: same, strong, weak.
   * @param attacker Unit belonging to human that is attacking the target
   * @param target Unit belonging to computer that is being attacked by the human
   * @return String representing the strength of the attacker relative to the target
   */
  public String determineAttackerStrength(Unit attacker, Unit target){
    String determinedStrength;

    // assign determinedStrength by comparing job of attacker with job of the target
    if(attacker.getJob().equalsIgnoreCase(target.getJob())){
      determinedStrength = "same";
    }
    else if((attacker.getJob().equalsIgnoreCase("knight") && target.getJob().equalsIgnoreCase("archer")) ||
            (attacker.getJob().equalsIgnoreCase("archer") && target.getJob().equalsIgnoreCase("mage")) ||
            (attacker.getJob().equalsIgnoreCase("mage") && target.getJob().equalsIgnoreCase("knight"))){
      determinedStrength = "strong";
    }
    else{
      determinedStrength = "weak";
    }

    return determinedStrength;
  }

  /**
   * For the given unit, allow human player to pick between attacking a target of their choosing or blocking.
   * This human unit will carry out the selected move during its turn.
   * Note: This method does not return anything.
   * @param unit Unit that is currently taking a turn
   * @param computer ComputerPlayer that human is playing against
   */
  public void moveUnit(Unit unit, ComputerPlayer computer){

    // Students: your code goes here.
	  
	// Check if the unit is alive (HP > 0). 
	  if(unit.getHp() > 0){
		  
		  //Initialize a string to hold user input
		  String userInputMove = " ";
		  
		  //Check if the user input is equal to null or not equal to "attack" or "block" (which are the strings returned from the validateMove method)
		  while(userInputMove == null || (!userInputMove.equals("attack") && !userInputMove.equals("block"))){
			// If not, prompt the human player to select a move
			  System.out.println("Select a move ('a' for 'attack' or 'b' for 'block'):");
			  
			 // Get user's input
			 userInputMove = scan.next();
			  
			 //Validate user input using the validateMove method. This will return "attack" or "block" if input is valid, or null if input is invalid.
			 //If input is invalid the validateMove method will reprompt
			 userInputMove = validateMove(userInputMove);
		  }
		  
		//Initialize a variable to store the user's selected target
		  Unit userSelectedTarget = null;
		  
		  // Check if the move selected is "attack"
		  if(userInputMove.equals("attack")){
			  
			  //If the selectTarget method returns null, this means the selected target was not amongst the computer's units
			  while(userSelectedTarget == null) {
				
				  //Prompt the player to select a target from the computer's units
				  System.out.println("Pick a target that is alive:");
				 
				  //Get user's input
				  String userInputTarget = scan.next();
		  
				  
				  //Validate selected target using the selectTarget method. 
				  //This will return the target unit object if the unit is alive and null if the unit is vanquished
				  //This will also print an informative message if the unit is vanquished.
				  userSelectedTarget = selectTarget(userInputTarget, computer);
			  }
			  
			  //Once a valid target is selected, call the determineAttackerStrength method to get the strength of the attacker relative to the target
			  //eg "strong", "weak", "same"
			   String determinedStrength = determineAttackerStrength(unit, userSelectedTarget);
					   
		     //Call the unit's attack method with the determined strength to calculate the damage the unit will deal
			   int damage = unit.attack(determinedStrength);
			
			 // Call the receiveDamage method with the calculated damage to apply the damage to the selected target
			   userSelectedTarget.receiveDamage(damage);
		  }
		  
			// If the move selected is not "attack", check if the move selected is "block"
			  else if(userInputMove.equals("block")){
				  //Call the unit's block method to temporarily increase the temporaryDefense of the unit
				  unit.block();
			  }   
	
	  }
	  
	  // If the unit is knocked out, print a message and turn ends.
	  else {
		  System.out.println(unit.name + " is knocked out and cannot move." );
	  }

  }

  /**
   * Resets temporary defensive buff of each human unit by setting temporaryDefense back to 0.
   * Note: This method does not take any parameters and does not return anything.
   */
  public void resetTemporaryDefense(){
    this.erom.setTemporaryDefense(0);
    this.falia.setTemporaryDefense(0);
    this.ama.setTemporaryDefense(0);
  }

  /**
   * Determines if human player has lost or is knocked out.
   * This is done by checking if all of its three units are knocked out.
   * Note: This method does not take any parameters.
   * @return boolean true if human has no units left or false
   */
  public boolean isKnockedOut(){

    // return true if all human units have 0 HP or less
    return this.falia.getHp() <= 0 && this.erom.getHp() <= 0 && this.ama.getHp() <= 0;
  }
}