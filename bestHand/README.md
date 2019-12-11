# Best Hand Card Game

Console game written in Java. 

## Rules

There are 5 rounds where players can exchange the cards in their hand in 0, 1, 2, 3, 5, and 8 increments.

Exchanges greater then 2 require the player to sacrifice a face card unless they don't have any face cards.

At the end, the players are scored depending on their given hand.

## Red Wedding

After the rounds are over, if any players have the same facecard, it is removed.

## Points

All card numbers are summed with points being added in special cases:

+2 pts per matching card

+5 pts per face card remaining at end

+3 pts per 3 card straight and an additional +3 pts for every extra card in straight


### Code Review

Game fully functional, needs refactoring and bug checks for scoring
