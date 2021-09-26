package controller.command;

import controller.command.impl.Inc;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {

    private final Map<String, Command> repository = new HashMap();

    CommandProvider() {
        repository.put("inc", new Inc());
    }

}
