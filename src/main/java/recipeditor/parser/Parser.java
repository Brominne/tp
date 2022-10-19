package recipeditor.parser;

import recipeditor.command.Command;
import recipeditor.command.AddCommand;
import recipeditor.command.ListCommand;
import recipeditor.command.InvalidCommand;
import recipeditor.command.ExitCommand;
import recipeditor.command.DeleteCommand;
import recipeditor.command.EditCommand;
import recipeditor.command.ViewCommand;


import recipeditor.recipe.RecipeList;
import recipeditor.ui.AddMode;
import recipeditor.ui.EditMode;
import recipeditor.ui.Ui;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Parser {
    private static Logger logger = Logger.getLogger("LOGS");

    public static Command parseCommand(String input) {
        String[] parsed = input.split(" ");
        String commandWord = parsed[0].toLowerCase();

        switch (commandWord) {
        case AddCommand.COMMAND_TYPE:
            return parseAddCommand();
        case ListCommand.COMMAND_TYPE:
            return new ListCommand();
        case ExitCommand.COMMAND_TYPE:
            return new ExitCommand();
        case DeleteCommand.COMMAND_TYPE:
        case EditCommand.COMMAND_TYPE:
            return parseEditCommand(parsed);
        case ViewCommand.COMMAND_TYPE:
            return parseListAlterCommand(parsed, commandWord);
        default:
            return new InvalidCommand();
        }

    }

    private static Command parseAddCommand() {
        AddMode add = new AddMode(); // Switch to Add Mode in here
        add.enterAddMode();
        add.exitAddMode();
        //Recipe addedRecipe = add.getRecipe();
        //Storage.loadRecipeToDataFile(addedRecipe);
        logger.log(Level.INFO, "Is the recipe valid? " + add.isValid);
        return new AddCommand(add.isValid, add.addedRecipe); // Pass validty and potential recipe to AddCommand
    }

    private static Command parseListAlterCommand(String[] parsed, String commandWord) {
        if (parsed.length == 2) {
            try {
                int index = Integer.parseInt(parsed[1]) - 1; // to account for 0-based indexing in recipelist
                if (commandWord.equals(ViewCommand.COMMAND_TYPE)) {
                    return new ViewCommand(index);
                }
                return new DeleteCommand(index);
            } catch (Exception e) {
                System.out.format("Exception: Wrong command Format%n"
                        + "Try the command in correct format: view/delete <index of task>%n");
                return new InvalidCommand();
            }
        }
        return new InvalidCommand();
    }

    private static Command parseEditCommand(String[] parsed) {
        EditMode edit = new EditMode();
        edit.enterEditMode(parsed[1]);
        edit.exitEditMode();
        return new EditCommand(RecipeList.getRecipeIndexFromTitle(parsed[1]), edit.getEditedRecipe());
    }

    //    private void checkForExcessArgument(String[] args, int length)
    //            throws ExcessArgumentException {
    //        if (args.length > length) {
    //            throw new ExcessArgumentException();
    //        }
    //    }
    
}
