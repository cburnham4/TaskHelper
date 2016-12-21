package letshangllc.taskhelper.classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Carl on 11/15/2016.
 */

public class Task implements Parcelable{
    private int id;
    private String name;
    private String description;
    private String zipCode;
    private Date postedTime;
    private Category category;
    private int postUserId;
    private boolean isPublic;

    public Task(int id, String name, String description, String zipCode, Date postedTime,
                Category category, int postUserId, boolean isPublic) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.zipCode = zipCode;
        this.postedTime = postedTime;
        this.category = category;
        this.postUserId = postUserId;
        this.isPublic = isPublic;
    }

    protected Task(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
        zipCode = in.readString();
        category = (Category) in.readParcelable(Category.class.getClassLoader());
        postedTime = (Date) in.readSerializable();
        postUserId = in.readInt();
        isPublic = in.readByte() != 0;
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Date getPostedTime() {
        return postedTime;
    }

    public int getPostUserId() {
        return postUserId;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isPublic() {
        return isPublic;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(zipCode);
        parcel.writeParcelable(category, 0);

        parcel.writeSerializable(postedTime);
        parcel.writeInt(postUserId);
        parcel.writeByte((byte) (isPublic ? 1 : 0));
    }
}
