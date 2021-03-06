package app.recharge;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RechargeActivity extends AppCompatActivity {
    public static String login_recu = "";
    TextView _loginRecu;
    EditText _txtsaisie, _txtcode;
    TextView _infoligne, _lblcode, _txtcommande, _txtconsult;
    Button _btncommande, _btnconsult;
    String code, cmd_envoi, code_envoi;
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
                if (Integer.parseInt(_txtsaisie.getText().toString()) >= 90000000 &&
                        Integer.parseInt(_txtsaisie.getText().toString()) <= 99999999) {
                    _infoligne.setText("Votre ligne est: Tunisie Telecom");
                    _lblcode.setText("Entrer votre code de recharge: (13 chiffres)");
                    _txtconsult.setText("*122#");
                    _infoligne.setTextColor(Color.BLUE);
                    _txtcommande.setBackgroundColor(Color.BLUE);
                    _txtcommande.setTextColor(Color.WHITE);
                    _txtconsult.setBackgroundColor(Color.BLUE);
                    _txtconsult.setTextColor(Color.WHITE);
                    _txtcode.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            code = _txtcode.getText().toString();
                            _txtcommande.setText("*123*"+code+"#");
                        }
                        @Override
                        public void afterTextChanged(Editable editable) { }
                    });
                }
                else if (Integer.parseInt(_txtsaisie.getText().toString()) >= 20000000 &&
                        Integer.parseInt(_txtsaisie.getText().toString()) <= 29999999) {
                    _infoligne.setText("Votre ligne est: OoRedoO");
                    _lblcode.setText("Entrer votre code de recharge: (14 chiffres)");
                    _txtconsult.setText("*100#");
                    _infoligne.setTextColor(Color.RED);
                    _txtcommande.setBackgroundColor(Color.RED);
                    _txtcommande.setTextColor(Color.WHITE);
                    _txtconsult.setBackgroundColor(Color.RED);
                    _txtconsult.setTextColor(Color.WHITE);
                    _txtcode.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            code = _txtcode.getText().toString();
                            _txtcommande.setText("*101*"+code+"#");
                        }
                        @Override
                        public void afterTextChanged(Editable editable) { }
                    });
                }
                else if (Integer.parseInt(_txtsaisie.getText().toString()) >= 30000000 &&
                        Integer.parseInt(_txtsaisie.getText().toString()) <= 59999999) {
                    _infoligne.setText("Votre ligne est: Orange");
                    _lblcode.setText("Entrer votre code de recharge: (14 chiffres)");
                    _txtconsult.setText("*101#");
                    _infoligne.setTextColor(Color.parseColor("#ff7f00"));
                    _txtcommande.setBackgroundColor(Color.parseColor("#ff7f00"));
                    _txtcommande.setTextColor(Color.BLACK);
                    _txtconsult.setBackgroundColor(Color.parseColor("#ff7f00"));
                    _txtconsult.setTextColor(Color.BLACK);
                    _txtcode.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            code = _txtcode.getText().toString();
                            _txtcommande.setText("*100*"+code+"#");
                        }
                        @Override
                        public void afterTextChanged(Editable editable) { }
                    });
                }
                else if (TextUtils.isEmpty(_txtsaisie.getText())){
                    Toast.makeText(RechargeActivity.this, "Saisir un num??ro !", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(RechargeActivity.this, "V??rifier votre saisie !", Toast.LENGTH_LONG).show();
                }
            }
        });
        _btncommande.setOnClickListener(view -> {
            cmd_envoi = _txtcommande.getText().toString();
            Intent i1 = new Intent(Intent.ACTION_DIAL);
            i1.setData(Uri.parse("tel:" + Uri.encode(cmd_envoi)));
            startActivity(i1);
        });
        _btnconsult.setOnClickListener(view -> {
            code_envoi = _txtconsult.getText().toString();
            Intent i2 = new Intent(Intent.ACTION_DIAL);
            i2.setData(Uri.parse("tel:" + Uri.encode(code_envoi)));
            startActivity(i2);
        });
    }
}