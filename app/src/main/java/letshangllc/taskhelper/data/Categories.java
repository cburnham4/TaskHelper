package letshangllc.taskhelper.data;

import letshangllc.taskhelper.R;
import letshangllc.taskhelper.classes.Category;

/**
 * Created by Carl on 10/29/2016.
 */

public class Categories {
    private static Category cleaning = new Category(0, R.drawable.cleaning_spray, "Cleaning");
    private static Category maintenance = new Category(1,R.drawable.driller,"Maintenance");
    private static Category transportation = new Category(2,R.drawable.car, "Transportation");
    private static Category errands = new Category(3,R.drawable.groceries,"Errands");
    private static Category education = new Category(4,R.drawable.pencil_case,"Education");
    private static Category support = new Category(5,R.drawable.float_device ,"Support");
    private static Category petCare = new Category(6,R.drawable.dog,"Pet Care");
    private static Category miscellaneous = new Category(7,R.drawable.notepad,"Miscellaneous");

    public static Category[] categories = new Category[]{cleaning, maintenance, transportation,
    errands, education, support, petCare, miscellaneous};
}
