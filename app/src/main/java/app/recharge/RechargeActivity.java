package app.recharge;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RechargeActivity extends AppCompatActivity {
    public static String login_recu = "";
    TextView _loginRecu;
    EditText _txtsaisie, _txtcode;
    TextView _infoligne, _lblcode, _txtcommande, _txtconsult;
    Button _btncommande, _btnconsult;
    String code;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);

        _loginRecu = findViewById(R.id.loginRecu);

        _txtsaisie = findViewById(R.id.txtsaisie);
        _txtcode = findViewById(R.id.txtcode);
        _txtcommande = findViewById(R.id.txtcommande);
        _txtconsult = findViewById(R.id.txtconsult);
        _btncommande = findViewById(R.id.btncommande);
        _btnconsult = findViewById(R.id.btnconsult);
        _infoligne = findViewById(R.id.infoligne);
        _lblcode = findViewById(R.id.lblcode);

        Intent i = getIntent();
        _loginRecu.setText(i.getStringExtra(login_recu));

        _txtsaisie.setOnFocusChangeListener((v, b) -> {
            if (!b){
                if (Integer.parseInt(_txtsaisie.getText().toString()) >= 90000000 &
                        Integer.parseInt(_txtsaisie.getText().toString()) <= 99999999) {
                    _infoligne.setText("Votre ligne est: Tunisie Telecom");
                    _lblcode.setText("Entrer votre code de recharge: (13 chiffres)");
                    _txtconsult.setText("*122#");
                    _infoligne.setTextColor(Color.BLUE);
                    _txtcommande.setBackgroundColor(Color.BLUE);
                    _txtcommande.setTextColor(Color.WHITE);
                    _txtconsult.setBackgroundColor(Color.BLUE);
                    _txtconsult.setTextColor(Color.WHITE);
                    _txtcode.setOnFocusChangeListener((v2, b2) -> {
                        code = _txtcode.getText().toString();
                        _txtcommande.setText("*123*"+code+"#");
                    });
                }
                else if (Integer.parseInt(_txtsaisie.getText().toString()) >= 20000000 &
                        Integer.parseInt(_txtsaisie.getText().toString()) <= 29999999) {
                    _infoligne.setText("Votre ligne est: OoRedoO");
                    _lblcode.setText("Entrer votre code de recharge: (14 chiffres)");
                    _txtconsult.setText("*100#");
                    _infoligne.setTextColor(Color.RED);
                    _txtcommande.setBackgroundColor(Color.RED);
                    _txtcommande.setTextColor(Color.WHITE);
                    _txtconsult.setBackgroundColor(Color.RED);
                    _txtconsult.setTextColor(Color.WHITE);
                    _txtcode.setOnFocusChangeListener((v2, b2) -> {
                        code = _txtcode.getText().toString();
                        _txtcommande.setText("*101*"+code+"#");
                    });
                }
                else {
                    _infoligne.setText("Votre ligne est: Orange");
                    _lblcode.setText("Entrer votre code de recharge: (14 chiffres)");
                    _txtconsult.setText("*101#");
                    _infoligne.setTextColor(Color.parseColor("#ff7f00"));
                    _txtcommande.setBackgroundColor(Color.parseColor("#ff7f00"));
                    _txtcommande.setTextColor(Color.BLACK);
                    _txtconsult.setBackgroundColor(Color.parseColor("#ff7f00"));
                    _txtconsult.setTextColor(Color.BLACK);
                    _txtcode.setOnFocusChangeListener((v2, b2) -> {
                        code = _txtcode.getText().toString();
                        _txtcommande.setText("*100*"+code+"#");
                    });
                }
            }
        });
    }
}