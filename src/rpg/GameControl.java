package rpg;

/**
 * This is a simplified version of a role-playing game.
 */
public class GameControl {

  /**
   * Creates a human player to play the game.
   */
  HumanPlayer human = new HumanPlayer();

  /**
   * Creates a computer player to play the game.
   */
  ComputerPlayer computer = new ComputerPlayer();

  /**
   * Prints the game's context and rules.
   * Note: This method does not take any parameters and does not return anything.
   */
  public void printInstructions(){
    System.out.println();
    System.out.println("Welcome to the final battle against enemy forces. You will be facing off against the computer.");
    System.out.println("Each of you will have 3 units with randomly generated jobs and levels.");
    System.out.println("The jobs are: mage, knight, and archer. Archers are strong against mages, but weak against knights.");
    System.out.println("Mages are strong against knights, but weak against archers. Knights are strong against archers, but weak against mages.");
    System.out.println("There are two moves: attack (deal damage to one target) and block (temporarily increase defense).");
    System.out.println("Combat is turn based; all your live units will take a turn and then all the computer's live units will take a turn.");
    System.out.println("You have 10 turns to defeat the computer. If both players still have units standing, you only win ");
    System.out.println("if the combined HP of your units exceeds the computer's.");
    System.out.println();
  }
  
  /**
   * Prints the current status of all human units and all computer units.
   * Note: This method does not take any parameters and does not return anything.
   */
  public void printStatus(){
    System.out.println();
    System.out.println("Your units:");
    this.human.getFalia().printCurrentStatus();
    this.human.getErom().printCurrentStatus();
    this.human.getAma().printCurrentStatus();
    System.out.println();
    System.out.println("Computer units:");
    this.computer.getCriati().printCurrentStatus();
    this.computer.getLedde().printCurrentStatus();
    this.computer.getTyllion().printCurrentStatus();
    System.out.println();
  }

  /**
   * Takes the human player's turn by calling moveUnit on each of the human player's three units: Falia, Erom, and Ama.
   * Prints the unit's job and level before moving it. Checks if there is no winner before proceeding to the next move.
   * If there is a winner between the first and second unit's turn or between the second and third unit's turn,
   * then return out of the method to end the human turn.
   * Resets any computer temporary defense after all human units have made their move.
   * Note: This method does not return anything.
   * @param turn int representing the current turn that the game is on.
   */
  public void takeHumanTurn(int turn){

    // Students: your code goes here.
	 
	  //Unit turn for Falia
	  
	  //Initialize Unit variable for Falia
	  Unit falia = human.getFalia();
	  
	  //Print Falia's job and level
	  System.out.println(); //Print blank line
	  System.out.println(falia.getJob().toUpperCase() + " " + falia.name + "(Lv: " + falia.getLevel() + ") is ready to act:" ); 
	  
	  //Allow Falia to take an action using the moveUnit method
	  human.moveUnit(falia, computer);
	  
	  //Call getWinner to check for a winner after Falia's action
	  getWinner(turn);
	  
	  
	  //Unit turn for Erom
	  
	  //Initialize Unit variable for Erom
	  Unit erom = human.getErom();
	  
	  //Print Erom's job and level
	  System.out.println(); //Print blank line
	  System.out.println(erom.getJob().toUpperCase() + " " + erom.name + "(Lv: " + erom.getLevel() + ") is ready to act:" ); 
	  
	  //Allow Erom to take an action using the moveUnit method
	  human.moveUnit(erom, computer);
	  
	  //Call getWinner to check for a winner after Erom's action
	  getWinner(turn);
	  

	  //Unit turn for Ama
	  
	  //Initialize Unit variable for Ama
	  Unit ama = human.getAma();
	  
	  //Print Ama's job and level
	  System.out.println(); //Print blank line
	  System.out.println(ama.getJob().toUpperCase() + " " + ama.name + "(Lv: " + ama.getLevel() + ") is ready to act:" ); 
	  
	  //Allow Ama to take an action using the moveUnit method
	  human.moveUnit(ama, computer);
	  
	  //Call getWinner to check for a winner after Ama's action
	  getWinner(turn);
	  
	  //Reset computer's temporary defenses by calling resetTemporaryDefense() method
	  computer.resetTemporaryDefense();

  }

  /**
   * Takes the computer player's turn and resets any human temporary defense after the computer has made its moves.
   * Note: This method does not take any parameters and does not return anything.
   */
  public void takeComputerTurn(){

    // Students: your code goes here.
	 
	 //Call computer strategy method to take compuer's turn
	 computer.strategy(human.getFalia(), human.getErom(), human.getAma());
	  
	//Reset human's temporary defenses by calling resetTemporaryDefense() method
	  human.resetTemporaryDefense(); 

  }

  /**
   * Gets the winner of the game based on the turn parameter and whether one of the players has been knocked out.
   * If the turn is less than 10, return null if both players are alive, otherwise return the winner if the opposing player is knocked out.
   * If both players still have living units after 10 turns, then the player with the greatest sum of HP wins, otherwise it is a tie.
   * @param turn int representing the current turn that the game is on.
   * @return String representing who won the game ("human" or "computer") or "tie" if there is a tie.
   * Return null if both players are still alive and the current turn is less than 10.
   */
  public String getWinner(int turn){

    // Students: your code goes here.
	  
	// Check if current turn parameter is less than 10
	  if(turn < 10) {
		  //If both the human player and computer player have some units with more than 0 HP, return null, indicating that there is no winner yet
		  if((human.getFalia().getHp() > 0 || human.getErom().getHp() > 0 || human.getAma().getHp() > 0) && (computer.getCriati().getHp() > 0 || computer.getLedde().getHp() > 0 || computer.getTyllion().getHp() > 0)) {
			  return null;
		  }
		  
		  //If all the computer's units have 0 or less HP, return "human", indicating that the human player has won
		  if(computer.getCriati().getHp() <= 0 && computer.getLedde().getHp() <= 0 && computer.getTyllion().getHp() <= 0) {
			  return "human";
		  }
		  
		  //If all the human's units have 0 or less HP, return "computer", indicating that the computer player has won
		  if(human.getFalia().getHp() <= 0 && human.getErom().getHp() <= 0 && human.getAma().getHp() <= 0) {
			  return "computer";
		  }
	  }
	  
	// Else, if the turn parameter is 10 or greater, evaluate the game based on the remaining HP of all units
	  else {
		  //Calculate the sum of the HP of all human units (Falia, Erom, Ana)
		  int sumHumanUnits = human.getFalia().getHp() + human.getErom().getHp() + human.getAma().getHp();
				  
		  //Calculate the sum of the HP of all computer units (Criati, Ledde, Tyllion)
		  int sumComputerUnits = computer.getCriati().getHp() + computer.getLedde().getHp() + computer.getTyllion().getHp();
		  
		  //If the human units' combined HP is greater than the computer unit's combined HP, return "human"
		  if(sumHumanUnits > sumComputerUnits) {
			  return "human";
		  }
		  
		  //If the computer units' combined HP is greater than the human unit's combined HP, return "computer"
		  if(sumComputerUnits > sumHumanUnits) {
			  return "computer";
		  }
		  
		  //If the combined HP of both sides is equal, return "tie"
		  if(sumComputerUnits == sumHumanUnits) {
			  return "tie";
		  }
	  }	
	  
	  //If no winner can be determined, return null
	  return null;
	
  }

  /**
   * Creates an instance of GameControl and contains the flow of this role-playing game.
   * Note: This method does not return anything.
   * @param args Not used.
   */
  public static void main(String[] args){

    // Students: your code goes here.

    //Create GameControl object and print the game instructions
	  GameControl game = new GameControl(); //Create instance of GameControl
	  game.printInstructions(); //Call printInstructions to display the game's context and rules
	  
    //Initialize a boolean variable to keep track of whether someone has won within 10 turns
	  boolean winnerFound = false;
	  
	//Initialize a String variable to store the winner
	  String winner = "";

    /*
     * Create a loop that runs 10 times or exits if there is a winner. In each iteration:
     *    - print the current turn number
     *    - print the current status of all units. Hint: printStatus() is given to you in this class
     *    - take the human player's turn
     *    - check for a winner and update your String variable and boolean variable accordingly
     *    - print the current status of all units. Hint: printStatus() is given to you in this class
     *    - take the computer player's turn
     *    - check for a winner and update your String variable and boolean variable accordingly
     */
	  
	  //Initialize the turn variable
	  int turn = 1;
	  
	  //Check if you're under 10 turns and there is no winner found yet
	  while(turn < 10 || winnerFound != true) {
		  
		  //Print current turn number
		  System.out.println("===================================================================="); //Print divider line
		  System.out.println("Turn " + turn);
		  System.out.println(); //Print blank line;
		  
		  //Call printStatus to show the current unit statuses
		  game.printStatus();
		  
		  //Call takeHumanTurn to execute the human player's actions
		  game.takeHumanTurn(turn);
		  
		  //Call getWinner to check for a winner after the human turn
		  winner = game.getWinner(turn);
		  
		  //Break out of the loop if a winner is found
		  if(winner != null) {
			  break; //break out of loop
		  }
		  
		  //Call printStatus to show the updated unit statuses
		  game.printStatus();
		  
		  //Call takeComputerTurn to execute the human player's actions
		  game.takeComputerTurn();
		  
		  //Check for winner after the call takeCOmputerTurn
		  winner = game.getWinner(turn);
		  
		  //Break out of the loop if a winner is found
		  if(winner != null) {
			  break; //break out of loop
		  }
		  
		  //Increase the turn
		  turn += 1;
		   
	  }

    //Find the winner if there wasn't one determined within the 10 turns
	  winner = game.getWinner(turn); // Call getWinner to determine the winner based on combined HP of all units

    //Print the end result of the game
	  
	  //If computer won, print informative message
	  if(winner.equals("computer")) {
		  System.out.println(); //Print blank line
		  System.out.println("All your heroes have been defeated, enemy forces have won!");
	  }
	  
	  //Else, if human won, print informative message
	  else if(winner.equals("human")) {
		  System.out.println(); //Print blank line
		  System.out.println("You've defeated the enemy!");
	  }
	  
	  //Else, print message that there was a tie
	  else {
		  System.out.println(); //Print blank line
		  System.out.println("Nobody wins!");
	  }

  }
}