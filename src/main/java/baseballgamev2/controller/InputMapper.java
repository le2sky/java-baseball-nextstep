package baseballgamev2.controller;

import baseballgamev2.domain.Balls;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputMapper {

    static Balls mapToBalls(String input) {
        List<Integer> target = Arrays.stream(input.split(""))
            .map(Integer::parseInt)
            .collect(Collectors.toUnmodifiableList());

        return new Balls(target);
    }

    static GameCommand mapToCommand(String input) {
        return GameCommand.withCommand(input);
    }
}