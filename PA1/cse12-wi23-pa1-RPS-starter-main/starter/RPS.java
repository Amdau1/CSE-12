import java.util.Scanner;
public class RPS extends RPSAbstract {
    // Messages for the game.
    protected static final String GAME_NOT_IMPLEMENTED =
            "Game not yet implemented.";
    /**
     * Construct a new instance of RPS with the given possible moves.
     * @param moves all possible moves in the game.
     */
    public RPS(String[] moves) {
        this.possibleMoves = moves;
        this.playerMoves = new String[MAX_GAMES];
        this.cpuMoves = new String[MAX_GAMES];
    }
    public int determineWinner(String playerMove, String cpuMove) {
        // TODO
        int valid = 0;
        for(int k = 0; k < possibleMoves.length; k++){
            if(possibleMoves[k].equals(playerMove)){
                valid ++;
            }
            if(possibleMoves[k].equals(cpuMove)){
                valid ++;
            }
        }
        if(valid < 2){
            return -1;
        }
        for(int i = 0; i < possibleMoves.length; i++){
            if(possibleMoves[i].equals(playerMove)){
                if(i == possibleMoves.length -1){
                   if( possibleMoves[0].equals(cpuMove)){
                    return 1;
                   }
                   else{
                    return 0;
                   } 
                }
                if(possibleMoves[i + 1].equals(cpuMove)){
                    return 1;
                }
            }
            if(possibleMoves[i].equals(cpuMove)){
                if(i == possibleMoves.length -1){
                   if( possibleMoves[0].equals(playerMove)){
                    return 2;
                   }
                   else{
                    return 0;
                   } 
                }
                if(possibleMoves[i + 1].equals(playerMove)){
                    return 2;
                }
            }
        }
        return 0;  // replace this when you implement the method
    }
    public static void main(String[] args) {
        System.out.println(PROMPT_MOVE);
        String[] moves = new String[args.length];
        if (args.length >= MIN_POSSIBLE_MOVES) {
            for (int i = 0; i < args.length; i++) {
                moves[i] = args[i];
            }
        } else {
            moves = RPS.DEFAULT_MOVES;
        }
        // Create new game and scanner
        RPS game = new RPS(moves);
        Scanner in = new Scanner(System.in);
        String determine = in.next();
        while(!(determine.equals("q"))){
            if(game.isValidMove(determine) == false){
                System.out.println(INVALID_INPUT);
                game.genCPUMove();
            }
            else {
                String cpumove = game.genCPUMove();
                System.out.printf(CPU_MOVE, cpumove);
                game.playRPS(determine, cpumove);
            }
            System.out.println(PROMPT_MOVE);
            String playersinput = in.next();
            determine = playersinput;
        } 
        game.displayStats();
        in.close();
    }
}