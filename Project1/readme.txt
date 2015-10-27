CSCI-140 Project 01: README
===============================
(please use the RETURN key to make multiple lines; don't assume autowrap.)

0. Author Information
---------------------

CS Username: 	txl2747		Name:  		Tommy Li

-------------------
1. Problem Analysis
-------------------

Summarize the analysis work you did. 
What new information did it reveal?  How did this help you?
How much time did you spend on problem analysis?

At first, given the questions that were given, I believed that
I was able to jam everything into just 1 class and have it work.
The unknowns of the problem were the players and board size,
which could be just variables defined in just the class. I would
need to have a method to check if the move is legal, a method to
make the move itself, and the individual methods for the good,
bad, human, and random players themselves. With this in mind, I
finished coding the game within four hours. It worked as it should
have, and I was happy with the result. However, in class, it
was revealed that if statements crammed inside the main method 
stating what players were what could cause me to lose points.
I turned to inheritance to solve that problem, and reformatting
the entire project took another 2 hours. However, the final result
successful.

------------------
2a. General Design
------------------

Explain the design you developed to use and why. 
What are the major components? What connects to what?
How much time did you spend on design?

To me, the main components of the game consisted of the players,
the board, and something to check if the various moves the players
made were legal. First, I wrote BritishSquare, whcih would house the
the game itself. It contains the board, as well as the turns of
each player. The main method initiates the game, and makes each player
by initiating a new player of the types specified by the command
line arguments. The main method checks if it id the first turn, and
makes the moves by calling each player's getMove() method, which will
modify the board. The getMove() method finds an appropriate move by calling
the methods in MoveChecker, which will check the space to see if that is
an appropriate move. Afterward, getMove() obtains the move and then
passes the move to makeMove(), which modifies the board. Then, the board
is sent back to the main method, which updates the board and goes to the
next player's turn. When no moves are available, the game ends.

-----------------------------
2b. Design of the Good Player
-----------------------------

Explain the design behind your "good" player.  What was your overall
idea of a good move?

A good move was one that blocked off the most spaces for the other player.
For example, if a space blocked off 3 squares for an opposing player
and another one blocked off 4, then the 4 blocker move would be
made. I designed the move so that it would use the already existing
MoveChecker to detect if the spaces left, right, up, and down were legal.
The space with the most adjacent legal moves whas made.

-----------------------------
3. Implementation and Testing
-----------------------------

Describe your implementation efforts here; this is the coding and testing.

What did you put into code first?
I originally put everything into BritishSquare.java, and it worked. However,
Professor Duncan told us that we were not allowed to use if statements in the
turns, so I made a Player class that was extended to make the various other
classes.

How did you test it?
I tested it first with non-human inputs. When that worked, I went on implementing
the human input, using the non-human ones as a guide. I tried to break the code by
putting bad command line arguments. Once I found something went wrong, I attempted
to clear the problem ASAP. So far, its been working, even against bad human input.

How well does the solution work?
As of now, I feel like it works into the project's standards. I haven't seen anything
break for a while, and I have been testing it pretty often for any problems.

Does it completely solve the problem?
It should solve the problem completely. I've implemented the following:
- First turn, on odd sized boards, the middle spot is illegal.
- Adjacent spaces with opponent's pieces are illegal.
- Random Player chooses a random spot.
- Bad player chooses first abailable spot.
- Good player chooses a "good" spot, meaning the spot that blocks off the most
spots for the opponent.
- When no moves are available, game ends.

Is anything missing?
Not that I know of.

How could you do it differently?
I could have had less java files by cramming everything into BritishSquare,
but it would have been harder to read. In addition, I could have not done
inheritance at all, but it was easier with it.

How could you improve it?
I could definitely write some of the code better, but the way my
original BritishSquare was set up, this was the only way I could
think of to implement it without destroying all my old methods.

How much total time would you estimate you worked on the project? 
I spent maybe 8 hours on it.

If you had to do this again, what would you do differently?
Definitely the way I coded it. I feel like everything had way
too many parameters because I wanted to stay with my old methods.
Making a board class might have helped out so I didnt have to control
everything in the main method.

----------------------
4. Development Process
----------------------

Describe your development process here; this is the overall process.

How much problem analysis did you do before your initial coding effort?
I usually code as I read. Probably not the best idea for this project
in particular, but it worked in the end. I skimmed to see what classes
I might need, and sat down to code everything.

How much design work and thought did you do before your initial coding effort?
Not much, honestly. As stated before, I skimmed it to find the bare minimum of
what I needed before I began.

How many times did you have to go back to assess the problem?
Quite frequently. I had to constantly check to see if my output matched the
output that was given, as I didn't read the assignment carefully enough.

What did you learn about software development?
It is very important to read a problem before attempting any code whatsoever.
You'll have a solid foundation to work with, and won't have to reassess the problem
as frequently as someone like I did. Once done with the implementation, it is
important to test your code as many ways as possible until you are positive that
there are no more problems.
