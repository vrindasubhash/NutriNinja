package use_case.generate_meal;

public class GenerateMealOutputData {

    public Object from;
    public Object to;
    public Object count;
    public Object _links;

    public Hits[] hits;

    public Hits[] getMeals() {
        return hits;
    }


    public class Hits{
        public Recipe recipe;
        public Recipe getRecipe() {
            return recipe;
        }

    }

    public class Recipe{

        private String label; //Recipe name
        private String image; //Image URL
        private String source; //Source name
        private String url; //Source URL

        private double calories;
        private double yield; //servings

        private String[] healthLabels;
        private String[] mealType;
        private String[] dishType;


        public String getLabel(){
            return label;
        }
        public String getImage() {
            return image;
        }

        public String getSource() {
            return source;
        }

        public String getUrl() {
            return url;
        }

        public double getCalories() {
            return calories;
        }

        public double getServings() {
            return yield;
        }
        public String[] getHealthLabels() {
            return healthLabels;
        }
        public String[] getMealType() {
            return mealType;
        }

        public String[] getDishType() {
            return dishType;
        }

        public TotalNutrients getTotalNutrients() {
            return totalNutrients;
        }

        private TotalNutrients totalNutrients;

        public class TotalNutrients{
            private Nutrients PROCNT; //protein
            private Nutrients FAT;
            private Nutrients CHOCDF; //Carbs


            public Nutrients getProtein() {
                return PROCNT;
            }

            public Nutrients getFat() {
                return FAT;
            }

            public Nutrients getCarb() {
                return CHOCDF;
            }


            public class Nutrients {
                private String label;
                private double quantity;
                private String unit;

                public String getLabel() {
                    return label;
                }

                public double getQuantity() {
                    return quantity;
                }

                public String getUnit() {
                    return unit;
                }
            }
        }
    }
}
