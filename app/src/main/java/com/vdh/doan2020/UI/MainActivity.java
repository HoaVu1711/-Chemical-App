package com.vdh.doan2020.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vdh.doan2020.DataBase.DatabaseAccess;
import com.vdh.doan2020.Fragment.BangTuanHoanFragment;
import com.vdh.doan2020.Fragment.DiemFragment;
import com.vdh.doan2020.Fragment.LyThuyetFragment;
import com.vdh.doan2020.Fragment.QuestionPackageFragment;
import com.vdh.doan2020.Model.Question;
import com.vdh.doan2020.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    DatabaseAccess access;
    List<Question>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        access=DatabaseAccess.getInstance(this);
        access.open();
        list=access.getQuestions();
        updateQuestion();
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,BangTuanHoanFragment.getINSTANCE()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment=null;
                switch (item.getItemId()){
                    case R.id.item_home:
                         selectedFragment= new BangTuanHoanFragment();
                        break;
                    case R.id.item_lythuyet:
                        selectedFragment=new LyThuyetFragment();
                        break;
                    case R.id.item_baitap:
                        selectedFragment=new QuestionPackageFragment();
                        break;
                    case R.id.item_diem:
                        selectedFragment=new DiemFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                return true;
            }
        });
    }
    public void updateQuestion(){
        DatabaseReference mData= FirebaseDatabase.getInstance().getReference();
        mData.child("NGanHangCauHoi").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Question> listServer=new ArrayList<>();
                for(DataSnapshot snapshot1: snapshot.getChildren()){
                    listServer.add(snapshot1.getValue(Question.class));
                }
                int sizeOld=list.size();
                int sizeNew=listServer.size();
                if(sizeNew>sizeOld){
                    LoadQuestionTask loadQuestionTask= new LoadQuestionTask();
                    loadQuestionTask.execute();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public class LoadQuestionTask extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            if(isNetworkConnected()) {
                access.open();
                access.deleteQuestion();
                access.insertQuestion();
            }
            return null;
        }
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}