package letshangllc.taskhelper.classes;

import java.util.Date;

/**
 * Created by Carl on 11/15/2016.
 */

public class Task {
    private int id;
    private String name;
    private String description;
    private String zipCode;
    private Date postedTime;
    private int postUserId;
    private boolean isPublic;

    public Task(int id, String name, String description, String zipCode, Date postedTime, int postUserId, boolean isPublic) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.zipCode = zipCode;
        this.postedTime = postedTime;
        this.postUserId = postUserId;
        this.isPublic = isPublic;
    }

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

    public boolean isPublic() {
        return isPublic;
    }
}
