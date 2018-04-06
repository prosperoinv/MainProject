package id.simplify.prosperoinv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText un, pwd;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //inisiasi untuk atribut login
        //testing push
        un = (EditText)findViewById(R.id.username);
        pwd = (EditText) findViewById(R.id.password);
        btn = (Button)findViewById(R.id.login);
    }
    public void masuk (View view) {
        final String usname = un.getText().toString();
        String psswd = pwd.getText().toString();

        if (usname.equals("admin") && psswd.equals("admin")){
            Toast.makeText(Login.this, "Login Berhasil",
                    Toast.LENGTH_LONG).show();
            Intent next = new Intent(this, dummy.class);
            startActivity(next);

        }
        else {
            Toast.makeText(Login.this, "Login Gagal",
                    Toast.LENGTH_LONG).show();

        }

    }
    public void cancel (View view){
        finish();
    }

}

