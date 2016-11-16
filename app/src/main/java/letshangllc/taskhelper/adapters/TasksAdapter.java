package letshangllc.taskhelper.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import letshangllc.taskhelper.R;
import letshangllc.taskhelper.classes.Task;


/**
 * Created by Carl on 11/15/2016.
 */

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder> {
    private Context context;

    /* Listen for item clicks */
    private static RecyclerViewClickListener mListener;

    private ArrayList<Task> tasks;

    private SimpleDateFormat simpleDateFormat;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        /* Views that are in cardview */
        public TextView tvTaskName;
        public TextView tvTaskDescription;
        public TextView tvDistance;
        public TextView tvDateTime;
        public CardView cardView;

        public ViewHolder(View view) {
            super(view);
            tvTaskName = (TextView) view.findViewById(R.id.tv_task_name);
            tvTaskDescription = (TextView) view.findViewById(R.id.tv_task_description);
            tvDistance = (TextView) view.findViewById(R.id.tv_distance);
            tvDateTime = (TextView) view.findViewById(R.id.tv_date_time);

            cardView = (CardView) view.findViewById(R.id.cardview_task);

            /* Set an onclick listener on the card view */
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.recyclerViewListClicked(v, getLayoutPosition());
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public TasksAdapter(ArrayList<Task> tasks, final Context context, RecyclerViewClickListener itemClickListener) {
        this.context = context;
        mListener = itemClickListener;
        this.tasks = tasks;
        simpleDateFormat = new SimpleDateFormat("EEE, MMM d", Locale.getDefault());
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_task, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Task task = tasks.get(position);
        holder.tvTaskName.setText(task.getName());
        holder.tvTaskDescription.setText(task.getDescription());
        holder.tvDistance.setText("7.3 mi");
        holder.tvDateTime.setText(simpleDateFormat.format(task.getPostedTime()));


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
