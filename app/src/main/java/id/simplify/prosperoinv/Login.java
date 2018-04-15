package id.simplify.prosperoinv;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import id.simplify.prosperoinv.model.User;

public class Login extends AppCompatActivity {
    EditText un, pwd;
    Button btn, su;
    ProgressBar progressBar;
    FirebaseAuth auth;
    DatabaseReference dbUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         auth = FirebaseAuth.getInstance();
         dbUser = FirebaseDatabase.getInstance().getReference("user");
        //inisiasi untuk atribut login
        //testing push
        un = (EditText)findViewById(R.id.username);
        pwd = (EditText) findViewById(R.id.password);
        btn = (Button)findViewById(R.id.login);
        su = (Button) findViewById(R.id.signup);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }
    public void daftar (View view){
        final String email = un.getText().toString().trim();
        final String password = pwd.getText().toString().trim();

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
                    @SuppressLint("RestrictedApi")
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(Login.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                     if (task.isSuccessful()) {
                            @SuppressLint("RestrictedApi") String id = auth.getUid();
                            String[] username = email.split("@");
                            Integer roles =1;
                         User user = new User(id, username[0], email);
                         //writeNewUser(id,username[0],email);
                         //dbUser.child("users").child(id).setValue(user);
                            dbUser.child(id).setValue(user);
                            Intent i = new Intent(Login.this,dummy.class);
                            startActivity(i);
                     } else {

                        }}});}


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser!=null){
            sendToMain();
        }
    }

    private void writeNewUser(String id, String username, String email) {
        User user = new User(id, username, email);
        dbUser.child("users").child(id).setValue(user);
    }
    private void sendToMain() {
        Intent mainIntent = new Intent(Login.this,dummy.class);
        startActivity(mainIntent);
    }

       public void masuk (View view) {
        final String email = un.getText().toString();
        final String password = pwd.getText().toString();

        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(Login.this, "SignInWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {

                            FirebaseUser user = auth.getCurrentUser();
                            Intent intent = new Intent(Login.this, dummy.class);
                            startActivity(intent);

                            }else {
                            Toast.makeText(Login.this, "Username atau Password salah", Toast.LENGTH_SHORT)
                                    .show();
                        }

                        }});}
                    }





    //public void cancel (View view){
        //finish();
    //}



