package letshangllc.taskhelper.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import letshangllc.taskhelper.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginWithFacebook(View view){
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }
}
