package de.brunokrams;

public class Experiment {

    private static final int NR_OF_ITERATIONS = 1000;

    public static void main(String[] args) {
        System.out.println(perform(Strategy.STAY));
        System.out.println(perform(Strategy.CHANGE));
    }

    private static Result perform(Strategy strategy) {
        int nrOfWins = 0;
        for (int i = 0; i < NR_OF_ITERATIONS; i++) {
            Game game = new Game();
            boolean hasWon = game.play(strategy);
            if (hasWon) {
                nrOfWins++;
            }
        }
        return new Result(strategy, nrOfWins, nrOfWins * 1.0 / NR_OF_ITERATIONS);
    }

    private record Result(Strategy strategy, int nrOfWins, double relativeNrOfWins) {
    }

}

