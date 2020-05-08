package com.jiaty.demo.test.builderTest;

/**
 * @program: Practice
 * @description: 对象
 * @author: jiaty
 * @create: 2019-12-02 17:47
 **/

public class NutritionFacts {
    private final int servingSize; // (mL) required
    private final int servings;    // (per container) required
    private final int calories;    // (per serving) optional
    private final int fat;         // (g/serving) optional
    private final int sodium;      // (mg/serving) optional
    private final int carbohydrate; // (g/serving) optional
//    public NutritionFacts(int servingSize, int servings) {
//        this(servingSize, servings, 0);
//    }
//    public NutritionFacts(int servingSize, int servings, int calories) {
//        this(servingSize, servings, calories, 0);
//    }
//    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
//        this(servingSize, servings, calories, fat, 0);
//    }
//    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
//        this(servingSize, servings, calories, fat, sodium, 0);
//    }
//    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium,
//                          int carbohydrate) {
//        this.servingSize = servingSize; this.servings = servings;
//        this.calories = calories;
//        this.fat = fat;
//        this.sodium = sodium;
//        this.carbohydrate = carbohydrate;
//    }

    @Override
    public String toString() {
        return "NutritionFacts{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }

    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;
        // Optional parameters - initialized to default values
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrate;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {

        NutritionFacts cocaCola = new Builder(240, 8).calories(100).sodium(35).fat(10).carbohydrate(27).build();

        System.out.println(cocaCola);
    }
}