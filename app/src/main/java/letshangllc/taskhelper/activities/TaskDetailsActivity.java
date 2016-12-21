package letshangllc.taskhelper.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import letshangllc.taskhelper.R;

public class TaskDetailsActivity extends AppCompatActivity {
    private static final String TAG = TaskDetailsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        getData();
    }

    private void getData(){

    }
}
