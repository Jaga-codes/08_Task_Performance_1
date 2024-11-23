import java.util.Scanner;

interface GameMode {
    void play();
}

interface PlayerInput {
    String getPlayerName();
    int selectMode();
}

interface GameActions {
    void startGame();
}

class StoryMode implements GameMode {
    public void play() {
        System.out.println("Story mode selected. Goodluck!");
    }
}

class SurvivalMode implements GameMode {
    public void play() {
        System.out.println("Survival mode selected. Goodluck!");
    }
}

class Game implements PlayerInput, GameActions {
    private String playerName;
    private GameMode gameMode;

    @Override
    public String getPlayerName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        playerName = scanner.nextLine();
        return playerName;
    }

    @Override
    public int selectMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 or 2 to select your game mode.");
        System.out.println("1 - Story");
        System.out.println("2 - Survival");
        return scanner.nextInt();
    }

    @Override
    public void startGame() {
        System.out.println("Press P to start playing, " + playerName + ".");
    }

    public void playGame() {
        String name = getPlayerName();
        int mode = selectMode();

        if (mode == 1) {
            gameMode = new StoryMode();
        } else if (mode == 2) {
            gameMode = new SurvivalMode();
        } else {
            System.out.println("Invalid mode selected.");
            return;
        }

        startGame();
        gameMode.play();
    }
}

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }
}
