package app.recharge;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText _login, _password;
    Button _connect;
    String correctpassword = "123456";
    String login_envoi = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _login = findViewById(R.id.login);
        _password = findViewById(R.id.password);
        _connect = findViewById(R.id.connect);

        _connect.setOnClickListener(view -> {
            login_envoi = _login.getText().toString();
            if (_password.getText().toString().equals(correctpassword)){
                Intent i = new Intent(MainActivity.this, RechargeActivity.class);
                i.putExtra(RechargeActivity.login_recu, login_envoi);
                startActivity(i);
            }
            else {
                Toast.makeText(MainActivity.this, "Identifiants incorrectes", Toast.LENGTH_LONG).show();
            }
        });
    }
}