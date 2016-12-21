package letshangllc.taskhelper.classes;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Carl on 10/29/2016.
 */

public class Category implements Parcelable{
    private int id;
    private int icon;
    private String name;

    public Category(int id, int icon, String name) {
        this.id = id;
        this.icon = icon;
        this.name = name;
    }

    protected Category(Parcel in) {
        id = in.readInt();
        icon = in.readInt();
        name = in.readString();
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(icon);
        parcel.writeString(name);
    }
}
