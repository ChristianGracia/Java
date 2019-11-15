package diceGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DamageGame {

 private int numberOfDice;
 private int numberOfSides;
 private int armorClass;
 private int damageModifier;
 private boolean criticalHit = false;
 private boolean criticalMiss = false;

 public DamageGame() {


  System.out.println("Welcome to Dice Roll Damage Calculator\n");
  checkIfHitorMiss();

 }

 private void checkIfHitorMiss() {
  System.out.println("Enter the damage modifier");
  setDamageModifier(readInteger());

  System.out.println("Enter the armor class");
  setArmorClass(readInteger());

  System.out.print("Damage Modifier: ");
  System.out.println(getDamageModifier());
  System.out.print("Armor Class: ");
  System.out.println(getArmorClass());

  System.out.print("\nroll: ");
  Dice dice = new Dice20Side(20);
  dice.roll();

  System.out.println(dice.getValue());

  if (dice.getValue() == 1) {
   System.out.println("critical miss!!!");
   setCriticalMiss(true);
  }
  if (dice.getValue() == 20) {
   System.out.println("critical hit!!!");
   setCriticalHit(true);

  }

  if (dice.getValue() + getDamageModifier() <= getArmorClass()) {
   System.out.println("You missed!!");

  } else {
   System.out.println("you hit!!!");
   hitDamageLogic();


  }

 }

 private void hitDamageLogic() {

  System.out.println("Enter number of dice");
  setNumberOfDice(readInteger());

  System.out.println("Enter number of sides");
  setNumberOfSides(readInteger());

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
   System.out.print("+ " + sumCritical);


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
 public int readInteger() {

  String input = "0";
  int number = 0;


  while (tryParseInt(input) && Integer.parseInt(input) < 101 && Integer.parseInt(input) > -101) {
   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


   try {
    input = reader.readLine();
    number = Integer.parseInt(input);
    return number;


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