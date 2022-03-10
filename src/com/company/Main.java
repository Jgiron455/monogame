package com.company;

import java.util.Optional;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
	// write your code here


        Player player1 = new Player("John", 100);
        Player player2 = new Player("Henry", 100);

        HouseSquare house1 = new HouseSquare("house1", 10, 20);
        HouseSquare house2 = new HouseSquare("house2", 20, 20);
        HouseSquare house3 = new HouseSquare("house3", 30, 20);
        HouseSquare house4 = new HouseSquare("house4", 30, 20);
        HouseSquare house5 = new HouseSquare("house5", 30, 20);


        BoardGame game = new BoardGame(asList(player1, player2), asList(house1, house2, house3, house4, house5));

        int currentPlayerSelected = 0;

        while(!game.isGameOver){
            System.out.println("\n-----------------------\n");

            // make sure we keep the loop within the player size
            if (currentPlayerSelected >= game.playerList.size()) {
//                game.isGameOver = true;
                currentPlayerSelected = 0;
            }
            // check to make sure game is not over
            if(game.playerList.size() == 0) {
                game.isGameOver = true;
            }


            // Current Player
            Player curPlyr = game.playerList.get(currentPlayerSelected);
            System.out.println("Its: " + curPlyr.getName() + " turn");

            // Move Player
            int rolled = game.dice.rollDice(3);
            System.out.println("Player: "+ curPlyr.getName() + " rolls " + rolled);
            curPlyr.setBoardPosition(curPlyr.getBoardPosition() + rolled);


            // if player is over the board limit reset them to the start
            if(curPlyr.getBoardPosition() >= game.board.size()) {
                curPlyr.setBoardPosition(0);
            }

            // Player lands on a Square do stuff
            Square currentSquare = game.board.get(curPlyr.getBoardPosition());
            if(currentSquare.isOwner(curPlyr)){
                // sell
            } else {
                if(!currentSquare.isOwned) {
                    // buy square
                    currentSquare.buy(curPlyr);
                } else {
                    // charge player
                    currentSquare.chargePlayer(curPlyr);

                    // increase owner's money
                    game.playerList.stream()
                            .forEach(player -> {
                                Optional<String> square = player.getPropertiesOwned().stream()
                                    .filter(property -> property.equalsIgnoreCase(currentSquare.name)).findFirst();
                                if(square.isPresent()){
                                    player.setMoney(player.getMoney()+currentSquare.chargeCost);
                                }
                            });
                }
            }

            // if player doesn't have money remove them from board
            if(curPlyr.getMoney() <= 0 && game.playerList.size()>0){
                game.playerList.remove(game.playerList.indexOf(curPlyr));
            }

            // Summary
            System.out.println("Summary: " + curPlyr.getName() +
                    " owns : " + curPlyr.getPropertiesOwned() +
                    " balance: $" + curPlyr.getMoney() +
                    " position: " + curPlyr.getBoardPosition());

            // Next player
            currentPlayerSelected +=1;
        }

    }
}
