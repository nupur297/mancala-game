Introduction to Mancala

Mancala is a two-player game from Africa in which players moves stones around a board

(shown above), trying to capture as many as possible.

In the board above, player 1 owns the bottom row of stones and player 2 owns the top row.

There are also two special pits on the board, called Mancalas, in which each player

accumulates his or her captured stones (player 1's Mancala is on the right and player 2's

Mancala is on the left).

On a player's turn, he or she chooses one of the pits on his or her side of the board (not

the Mancala) and removes all of the stones from that pit. The player then places one stone in

each pit, moving counterclockwise around the board, starting with the pit immediately next to the

chosen pit, including his or her Mancala but NOT his or her opponent's Mancala, until he or she

has run out of stones. If the player's last stone ends in his or her own Mancala, the player gets

another turn. If the player's last stone ends in an empty pit on his or her own side, the player

captures all of the stones in the pit directly across the board from where the last stone was

placed (the opponent's stones are removed from the pit and placed in the player's Mancala) as

well as the last stone placed (the one placed in the empty pit). The game ends when one player

cannot move on his or her turn, at which time the other player captures all of the stones

remaining on his or her side of the board.

Note: it is possible to have so many stones in one’s pit that you cover the whole board in one

turn. If you make the full circle, you can just continue placing the stones until the ‘hand’ is empty.

If your last stone is in the pit you just emptied by starting your turn, the ‘ending-in-an-empty-pit’

rule above applies as well.


## To compile and run the game application.
mvn compile
mvn exec:java -Dexec.mainClass=com.mancala.MancalaGame -Dexec.args="name1 name2"
where, name1 and name2 are names of players playing Mancala.

Player1 is starting...
-------------------------------------------------------------
         08      09      10      11      12      13     
        [04]    [04]    [04]    [04]    [04]    [04]                      Player  2(  name2)
[00]                                                    [00]
        [04]    [04]    [04]    [04]    [04]    [04]                -->Player  1(  name1)
         06      05      04      03      02      01     
-------------------------------------------------------------
Enter  a  pit  to  move from:  

--> display indicator which tells the current player
Current player will enter the pit number from which he wants to play. In case of invalid move, current player needs to go again.



