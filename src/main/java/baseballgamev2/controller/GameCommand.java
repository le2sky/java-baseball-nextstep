package baseballgamev2.controller;

public enum GameCommand {

    REPLAY("1"), CLOSE("2");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand withCommand(String target) {
        if (REPLAY.isMe(target)) {
            return REPLAY;
        }
        if (CLOSE.isMe(target)) {
            return CLOSE;
        }

        throw new IllegalArgumentException();
    }

    private boolean isMe(String target) {
        return command.equals(target);
    }

    public boolean isReplay() {
        return this == REPLAY;
    }
}