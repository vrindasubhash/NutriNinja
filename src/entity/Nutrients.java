package entity;

public class Nutrients {
    private int calories;
    private int fat;
    private int protein;
    private int carbs;

    public Nutrients(int calories, int fat, int protein, int carbs) {
        this.calories = calories;
        this.fat = fat;
        this.protein = protein;
        this.carbs = carbs;
    }

    public int getCalories() {
        return calories;
    }

    public int getFat() {
        return fat;
    }

    public int getProtein() {
        return protein;
    }

    public int getCarbs() {
        return carbs;
    }
}
