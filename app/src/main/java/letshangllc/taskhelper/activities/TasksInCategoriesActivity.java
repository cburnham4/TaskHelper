package letshangllc.taskhelper.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;

import letshangllc.taskhelper.R;
import letshangllc.taskhelper.adapters.RecyclerViewClickListener;
import letshangllc.taskhelper.adapters.TasksAdapter;
import letshangllc.taskhelper.classes.Task;

public class TasksInCategoriesActivity extends AppCompatActivity implements RecyclerViewClickListener{

    /* Recycle view variables */
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    /* Tasks Data */
    private ArrayList<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_in_categories);

        this.setupToolbar();
        this.setupList();
    }

    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Cleaning Tasks");

        if(toolbar != null){getSupportActionBar().setDisplayHomeAsUpEnabled(true);}
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setupList(){
        tasks = new ArrayList<>();
        tasks.add(new Task(0, "Clean Room", "Clean my bedroom and closet", "97221", new Date(), 01, true));
        tasks.add(new Task(0, "Clean Bathroom", "Clean my bedroom and closet", "97221", new Date(), 01, true));
        tasks.add(new Task(0, "Do Dishes", "Put up old dishes and clean the dirty ones", "97221", new Date(), 01, true));
        /* find the recycleview */
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_tasks_in_category);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        /* create an adapter passing in the data and this as the onClickListener */
        mAdapter = new TasksAdapter(tasks, this, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void recyclerViewListClicked(View v, int position) {
        /* Get the task */
        Task task = tasks.get(position);

        /* Create new intent */
        Intent intent = new Intent(this, TaskDetailsActivity.class);

        startActivity(intent);
    }
}
