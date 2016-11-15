package letshangllc.taskhelper.classes;

/**
 * Created by Carl on 10/29/2016.
 */

public class Category {
    private int id;
    private int icon;
    private String name;

    public Category(int id, int icon, String name) {
        this.id = id;
        this.icon = icon;
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return name;
    }
}
