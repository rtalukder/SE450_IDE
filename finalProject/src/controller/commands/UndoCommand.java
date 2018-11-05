package controller.commands;

import model.persistence.CommandHistory;

public class UndoCommand implements ICommand {

    @Override
    public void run() {
        CommandHistory.undo();
    }

}
