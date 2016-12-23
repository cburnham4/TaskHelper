package letshangllc.taskhelper.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

import letshangllc.taskhelper.R;
import letshangllc.taskhelper.classes.Task;

public class TaskDetailsActivity extends AppCompatActivity {
    private static final String TAG = TaskDetailsActivity.class.getSimpleName();

    /* Private Instance Variables */
    private Task task;

    /* Views */
    private TextView tvCategoryName, tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        getData();
        setupToolbar();
        findViews();
        setupViews();
    }

    private void getData(){
        task  = getIntent().getParcelableExtra(getString(R.string.send_task_extra));
    }

    /* Set up Toolbar */
    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(task.getName());

        if(toolbar != null){getSupportActionBar().setDisplayHomeAsUpEnabled(true);}
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /* Find views */
    private void findViews(){
        tvCategoryName = (TextView) findViewById(R.id.tvCategoryName);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
    }

    /* Setup Views */
    private void setupViews(){
        tvCategoryName.setText(String.format(Locale.getDefault(), "%s", task.getCategory().getName()));
        tvDescription.setText(String.format(Locale.getDefault(), "%s", task.getDescription()));

    }

    public void gotoMessagePoster(View view){
        Intent intent = new Intent(this, MessagingActivity.class);
        startActivity(intent);
    }
}
