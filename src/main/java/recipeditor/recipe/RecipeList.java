package recipeditor.recipe;

import java.util.ArrayList;

public class RecipeList {
    private static ArrayList<Recipe> recipes = new ArrayList<>();

    private RecipeList(ArrayList<Recipe> load) {
        recipes = new ArrayList<>();
        recipes.addAll(load);
    }

    public static Recipe getRecipe(int index) throws IndexOutOfBoundsException {
        return recipes.get(index);
    }

    public static void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public static void deleteRecipe(int index) throws IndexOutOfBoundsException {
        recipes.remove(index);
    }

    public static void editRecipe(int index, Recipe newRecipe) {
        recipes.set(index, newRecipe);
    }

    public static Recipe getRecipeFromTitle(String recipleTitle) {
        for (Recipe r : recipes) {
            if (r.getTitle().equalsIgnoreCase(recipleTitle)) {
                return r;
            }
        }
        return null;
    }

    public static int getRecipeIndexFromTitle(String recipeTitle) {
        int i = 0;
        for (Recipe r : recipes) {
            if (r.getTitle().equalsIgnoreCase(recipeTitle)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static ArrayList<String> findRecipeTitles(char flag, String findInput) {
        switch (flag) {
        case 'r':
            return findRecipeTitlesFromRecipeTitle(findInput);
        case 'i':
            return findRecipeTitlesFromIngredientName(findInput);
        default:
            return new ArrayList<>();
        }
    }

    public static ArrayList<String> findRecipeTitlesFromRecipeTitle(String findInput) {
        ArrayList<String> foundRecipeTitlesList = new ArrayList<>();
        for (Recipe r : recipes) {
            if (r.getTitle().contains(findInput)) {
                foundRecipeTitlesList.add(r.getTitle());
            }
        }
        return foundRecipeTitlesList;
    }

    public static ArrayList<String> findRecipeTitlesFromIngredientName(String findInput) {
        ArrayList<String> foundRecipeTitlesList = new ArrayList<>();
        for (Recipe r : recipes) {
            ArrayList<Ingredient> recipeIngredients = r.getIngredients();
            for (Ingredient i : recipeIngredients) {
                if (i.getName().contains(findInput)) {
                    foundRecipeTitlesList.add(r.getTitle());
                }
            }
        }
        return foundRecipeTitlesList;
    }

    public static int getSize() {
        return recipes.size();
    }
}
