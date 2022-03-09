package app.recharge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RechargeActivity extends AppCompatActivity {
    public static String login_recu = "";
    TextView _loginRecu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);

        _loginRecu = findViewById(R.id.loginRecu);

        Intent i = getIntent();
        _loginRecu.setText(i.getStringExtra(login_recu));
    }
}