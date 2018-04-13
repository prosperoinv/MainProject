package id.simplify.prosperoinv;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText un, pwd;
    Button btn, su;
    ProgressBar progressBar;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         auth = FirebaseAuth.getInstance();
        //inisiasi untuk atribut login
        //testing push
        un = (EditText)findViewById(R.id.username);
        pwd = (EditText) findViewById(R.id.password);
        btn = (Button)findViewById(R.id.login);
        su = (Button) findViewById(R.id.signup);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }
    public void daftar (View view){
        String email = un.getText().toString().trim();
        String password = pwd.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        //create user

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(Login.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(Login.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(Login.this, Login.class));
                            finish();
                        }}});}

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
    //public void cancel (View view){
        //finish();
    //}

}

