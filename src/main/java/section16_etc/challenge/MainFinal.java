package section16_etc.challenge;

import section16_etc.challenge.pirate.PirateGame;

class SpecialGameConsole<T extends Game<? extends Player>> extends GameConsole<Game<? extends Player>> {

    public SpecialGameConsole(Game<? extends Player> game) {
        super(game);
    }
}

public class MainFinal {

    public static void main(String[] args) {

        SpecialGameConsole<PirateGame> game = new SpecialGameConsole<>(new PirateGame(""));

    }

}
