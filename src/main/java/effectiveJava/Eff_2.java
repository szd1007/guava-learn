package effectiveJava;

/**
 * 2. 构造器参数较多时考虑使用构建器[builder]
 * <p>
 * 优点：
 * - 避免使用重叠构造器【同名参数个数不同，参数少的构造器加默认参数调用参数多的构造器】避免代码难以阅读
 * - 避免使用javaBeans方式，无参构造器生成实例，然后调用set方法【构造过程会导致对象处于不一致状态，无法保证线程安全】
 */
@SuppressWarnings("all")
public class Eff_2 {
    public static void main(String[] args) {
        NutritionFacts.Builder builder = new NutritionFacts.Builder(1, 3);
        builder.sodium(33).calories(134).build();
    }
}
@SuppressWarnings("all")
 class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // Required parameters private final int servingSize; private final int servings;
        //必备参数，里面再声明一遍变量应该就是为了使外部final可以多次使用
        private final int servingSize;
        private final int servings;
        //可选参数 给默认值
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        @EfLanguagePoints("构造函数首先保证必须声明的参数初始化，后面就可以选择性设置值了")
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

        @EfLanguagePoints("最后才返回这个对象，保证线程安全")
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
}


class NutritionFacts2 {
    private final int servingSize; // (mL) required private final int servings; // (per container) required
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate; // (g/serving) optional

    @EfLanguagePoints("重叠构造器，  会造成客户端代码难以维护")
    public NutritionFacts2(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFacts2(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts2(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    // (per serving) optional // (g/serving) optional
    // (mg/serving) optional
    public NutritionFacts2(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFacts2(int servingSize, int servings,
                           int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}