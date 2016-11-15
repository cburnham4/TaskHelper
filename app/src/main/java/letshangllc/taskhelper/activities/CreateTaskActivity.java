package letshangllc.taskhelper.activities;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;

import letshangllc.taskhelper.R;
import letshangllc.taskhelper.classes.Category;
import letshangllc.taskhelper.data.Categories;
import letshangllc.taskhelper.helpers.DateTimeHelper;

public class CreateTaskActivity extends AppCompatActivity {
    /* VIEWS */
    private EditText etTaskName, etTaskDecription, etTaskLocation;
    private Spinner spinnerCategories;
    private Button btnFromDate, btnFromTime, btnToDate, btnToTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        this.setupToolbar();
        this.findViews();
        this.setupViews();
    }

    /* Setup Toolbar */
    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(toolbar != null){
            /* Todo add confirmation dialog */
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_clear_white_24dp);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    /* Find Views */
    private void findViews(){
        etTaskName = (EditText) findViewById(R.id.et_task_name);
        etTaskDecription = (EditText) findViewById(R.id.et_task_description);
        etTaskLocation = (EditText) findViewById(R.id.et_task_location);

        spinnerCategories = (Spinner) findViewById(R.id.spinner_categories);

        btnFromDate = (Button) findViewById(R.id.btn_from_date);
        btnFromTime = (Button) findViewById(R.id.btn_from_time);
        btnToDate = (Button) findViewById(R.id.btn_to_date);
        btnToTime = (Button) findViewById(R.id.btn_to_time);
    }

    /* Setup Views */
    private void setupViews(){
        /* Set up spinner */
        ArrayAdapter<Category> adapterCategory = new ArrayAdapter<Category>(this,
                android.R.layout.simple_spinner_dropdown_item, Categories.categories);

        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategories.setAdapter(adapterCategory);

        /* Setup On Click Button */
        Calendar calendar = Calendar.getInstance();
        btnFromDate.setText(DateTimeHelper.getFormattedDate(calendar));
        btnToDate.setText(DateTimeHelper.getFormattedDate(calendar));
        btnFromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker(true);
            }
        });
        btnToDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker(false);
            }
        });
        btnFromTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePicker(true);
            }
        });
        btnToTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePicker(false);
            }
        });
    }

    /* Show Date Picker Dialog */
    private void showDatePicker(final boolean isFrom){
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {

                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                if(isFrom){
                    btnFromDate.setText(DateTimeHelper.getFormattedDate(calendar));
                }else{
                    btnToDate.setText(DateTimeHelper.getFormattedDate(calendar));
                }
            }

        };

        new DatePickerDialog(this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show();

    }

    private void showTimePicker(final boolean isFrom){
        TimePickerDialog timePickerDialog = new TimePickerDialog(CreateTaskActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                String time = DateTimeHelper.getFormattedTime(selectedHour, selectedMinute);
                if(isFrom){
                    btnFromTime.setText(time);
                }else{
                    btnToTime.setText(time);
                }
            }
        }, 12, 0, false);//Yes 24 hour time


        //timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_create_task_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                /* Go to create a new Task */
                saveTask();
                break;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
        return true;
    }

    private void saveTask(){
        /* Save the task on the server */
        String taskName = etTaskName.getText().toString().trim();
        String taskDescription = etTaskDecription.getText().toString().trim();
        String taskLocation = etTaskLocation.getText().toString().trim();
        finish();
    }
}
