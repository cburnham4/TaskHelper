package letshangllc.taskhelper.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import letshangllc.taskhelper.R;
import letshangllc.taskhelper.adapters.CategoriesAdapter;
import letshangllc.taskhelper.adapters.RecyclerViewClickListener;

public class HomeActivity extends AppCompatActivity implements RecyclerViewClickListener{
    /* Recycle view variables */
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.setupCategoriesList();
        this.setupToolbar();
    }

    /* Setup Recycleview */
    private void setupCategoriesList(){
        /* find the recycleview */
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_categories);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        /* create an adapter passing in the data and this as the onClickListener */
        mAdapter = new CategoriesAdapter(this, this);
        mRecyclerView.setAdapter(mAdapter);
    }


    /* Set up Toolbar */
    private void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_task:
                /* Go to create a new Task */
                goToCreateTask();
                break;
            case R.id.action_profile:
                startActivity(new Intent(HomeActivity.this, EditProfileActivity.class));
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
        return true;
    }

    /* Go to CreateTaskActivity */
    private void goToCreateTask(){
        Intent intent = new Intent(HomeActivity.this, CreateTaskActivity.class);
        startActivity(intent);
    }

    @Override
    public void recyclerViewListClicked(View v, int position) {
        /* Go to the next activity */
        /* TODO send category */
        Intent intent = new Intent(this, TasksInCategoriesActivity.class);
        startActivity(intent);
    }
}
