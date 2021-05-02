package command.enums;

import command.Command;
import command.impl.get.MainPageCommand;
import command.impl.get.RegistrationPageCommand;
import command.impl.post.AuthorizationCommand;
import command.impl.post.RegistrationCommand;

public enum CommandInstance {

    MAIN_PAGE(new MainPageCommand()),
    REGISTRATION_PAGE(new RegistrationPageCommand()),
    REGISTRATION(new RegistrationCommand()),
    AUTHORIZATION(new AuthorizationCommand());

    private Command command;

    CommandInstance(Command command) {
        this.command = command;
    }

    public static Command commandOf(String commandName){
        for(CommandInstance instance:CommandInstance.values()){
            if (commandName.equalsIgnoreCase(instance.name())) {
                return instance.command;
            }
        }
        return null;
    }
}
