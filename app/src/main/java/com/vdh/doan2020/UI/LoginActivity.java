package com.vdh.doan2020.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.vdh.doan2020.Model.User;
import com.vdh.doan2020.R;
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnDangNhap, btnDangki;
    private ProgressBar prLoad;
    private FirebaseAuth mAuth;
    private String mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        anhXa();
    }
    private void anhXa() {
        edtEmail=findViewById(R.id.email);
        edtPassword=findViewById(R.id.password);
        btnDangNhap=findViewById(R.id.dangnhap);
        btnDangki=findViewById(R.id.dangki);
        prLoad=findViewById(R.id.loading);
        btnDangki.setOnClickListener(this);
        btnDangNhap.setOnClickListener(this);
    }
    public void dangKi(){
        String email=edtEmail.getText().toString();
        String password=edtPassword.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    User user= new User(email,password);
                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(LoginActivity.this,"Dang ki thanh cong",Toast.LENGTH_LONG).show();
                        }
                    });

                }
                else {
                    Toast.makeText(LoginActivity.this,"Dang ki that bai",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
    public void dangNhap(){
        String email=edtEmail.getText().toString();
        String password=edtPassword.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
              if(task.isSuccessful()){
                  edtEmail.getText().clear();
                  edtPassword.getText().clear();
                  prLoad.setVisibility(View.GONE);
                  Intent intent= new Intent(LoginActivity.this,MainActivity.class);
                  startActivity(intent);
              }
              else {
                  Toast.makeText(LoginActivity.this,"Dang nhap that bai",Toast.LENGTH_LONG).show();
              }
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.dangki:
                dangKi();
                break;
            case R.id.dangnhap:
                dangNhap();
                break;
            default:
                break;
        }
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }
}