package diceGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DamageGame {

 private int numberOfDice;
 private int numberOfSides;
 private int armorClass;
 private int damageModifier;
 private boolean criticalHit = true;
 private boolean criticalMiss = false;

 public DamageGame() {


  System.out.println("Welcome to Dice Roll Damage Calculator\n");
  getModifiers();
  checkIfHitorMiss();

 }
 
 private void getModifiers() {
	  System.out.println("Enter the damage modifier");
	  setDamageModifier(readInteger(-100, 100));

	  System.out.println("Enter the armor class");
	  setArmorClass(readInteger(0, 100));

	  System.out.print("Damage Modifier: ");
	  System.out.println(getDamageModifier());
	  System.out.print("Armor Class: ");
	  System.out.println(getArmorClass());
	 
 }

 private void checkIfHitorMiss() {


  System.out.print("\nroll: ");
  Dice dice = new Dice20Side(20);
  dice.roll();

  System.out.println(dice.getValue());
 
  checkDiceValue(dice.getValue());

 }
 
 private void checkDiceValue(int value) {
	  if (value == 1) {
	   System.out.println("critical miss!!!");
	   setCriticalMiss(true);

	  }
	  if (value == 20) {
	   System.out.println("critical hit!!!");
	   setCriticalHit(true);

	  }

	  if (value + getDamageModifier() > getArmorClass()) {

	   System.out.println("you hit!!!");
	   hitDamageLogic();

	  } else {
	   System.out.println("You missed!!");

	  }

	 }

 private void hitDamageLogic() {

  System.out.println("Enter number of dice");
  setNumberOfDice(readInteger(1,100));

  System.out.println("Enter number of sides");
  setNumberOfSides(readInteger(1, 100));

  Dice20Side multiDie = new Dice20Side(numberOfSides);
  int sum = 0;
  int counter = 0;

  System.out.print("Rolls: ");

  while (counter < getNumberOfDice()) {
   counter++;
   multiDie.roll();
   sum += multiDie.getValue();


  }
  System.out.print("Damage Dealt: " + sum);
  if (isCriticalHit()) {
   int sumCritical = 0;
   counter = 0;
   while (counter < getNumberOfDice()) {
    counter++;
    multiDie.roll();
    sumCritical += multiDie.getValue();
   }
   System.out.print(" + " + sumCritical);

  }

 }


 public int getNumberOfDice() {
  return numberOfDice;
 }

 public void setNumberOfDice(int numberOfDice) {
  this.numberOfDice = numberOfDice;
 }

 public int getNumberOfSides() {
  return numberOfSides;
 }

 public void setNumberOfSides(int numberOfSides) {
  this.numberOfSides = numberOfSides;
 }

 public int getArmorClass() {
  return armorClass;
 }

 public void setArmorClass(int armorClass) {
  this.armorClass = armorClass;
 }

 public int getDamageModifier() {
  return damageModifier;
 }

 public void setDamageModifier(int damageModifier) {
  this.damageModifier = damageModifier;
 }
 public int readInteger(int min, int max) {

  String input = "0";
  int number = 0;


  while (number == 0) {
   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


   try {
	 
    input = reader.readLine();
    if(tryParseInt(input)) {
    
    	   if(Integer.parseInt(input) > min - 1 && Integer.parseInt(input) < max + 1) {
    		   number = Integer.parseInt(input);
    	   	   return number;
    		   
    	   }
    	
    } 
    System.out.println("Invalid Input!");



   } catch (IOException e) {

    e.printStackTrace();
   }

  }
  return number;


 }
 private boolean tryParseInt(String value) {
  try {
   Integer.parseInt(value);
   return true;
  } catch (NumberFormatException e) {
   return false;
  }
 }

 public boolean isCriticalHit() {
  return criticalHit;
 }

 public void setCriticalHit(boolean criticalHit) {
  this.criticalHit = criticalHit;
 }

 public boolean isCriticalMiss() {
  return criticalMiss;
 }

 public void setCriticalMiss(boolean criticalMiss) {
  this.criticalMiss = criticalMiss;
 }


}