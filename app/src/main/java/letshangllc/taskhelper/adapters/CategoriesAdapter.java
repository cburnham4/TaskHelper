package letshangllc.taskhelper.adapters;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import letshangllc.taskhelper.R;
import letshangllc.taskhelper.classes.Category;
import letshangllc.taskhelper.data.Categories;

/**
 * Created by Carl on 10/29/2016.
 */

public class CategoriesAdapter  extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {
    private Context context;

    /* Listen for item clicks */
    private static RecyclerViewClickListener mListener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        /* Views that are in cardview */
        public TextView tvCategoryName;
        public ImageView imgCategoryIcon;
        public CardView cardView;

        public ViewHolder(View view) {
            super(view);
            tvCategoryName = (TextView) view.findViewById(R.id.tv_category_name);
            imgCategoryIcon = (ImageView) view.findViewById(R.id.img_category_icon);
            cardView = (CardView) view.findViewById(R.id.cardview_category);

            /* Set an onclick listener on the card view */
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.recyclerViewListClicked(v, getLayoutPosition());
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CategoriesAdapter(final Context context,
                          RecyclerViewClickListener itemClickListener) {
        this.context = context;
        mListener = itemClickListener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_category, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder,int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Category category = Categories.categories[position];
        holder.imgCategoryIcon.setImageResource(category.getIcon());
        holder.tvCategoryName.setText(category.getName());


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return Categories.categories.length;
    }
}

