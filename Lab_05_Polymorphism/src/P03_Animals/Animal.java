package P03_Animals;

public abstract class Animal {
    private String name;
    private String favoriteFood;

    public Animal(String name, String favoriteFood) {
        this.setName(name);
        this.setFavoriteFood(favoriteFood);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favouriteFood) {
        this.favoriteFood = favouriteFood;
    }

    public abstract String explainSelf();
}
