package com.vdh.doan2020.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ThrowOnExtraProperties;
import com.google.firebase.database.ValueEventListener;
import com.vdh.doan2020.Adapter.CommentAdapter;
import com.vdh.doan2020.DataBase.DatabaseAccess;
import com.vdh.doan2020.Fragment.QuestionFragment;
import com.vdh.doan2020.Model.BinhLuan;
import com.vdh.doan2020.Model.Question;
import com.vdh.doan2020.Model.User;
import com.vdh.doan2020.R;

import java.util.ArrayList;
import java.util.List;

public class Comment_activity extends AppCompatActivity {
    private List<Question> questionList;
    private TextView tvNoiDungCauHoi;
    private DatabaseAccess access;
    private RecyclerView recyclerView;
    private EditText edtConment;
    private CommentAdapter adapter;
    private List<BinhLuan>list;
    private String nameChild;
    private DatabaseReference mData;
    QuestionFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_activity);
        anhXa();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        mData = FirebaseDatabase.getInstance().getReference();
        adapter = new CommentAdapter(Comment_activity.this, list);
        Bundle bundle = getIntent().getExtras();
        nameChild = "Cau" + bundle.getInt("ID");
        getData(nameChild);
        String noiDung = bundle.getString("NoiDung");
        tvNoiDungCauHoi.setText(noiDung);
        edtConment.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                List<User>userList= new ArrayList<>();
                FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
                String userID=user.getUid();
                if(user!=null){
                    List<String>profileUser =new ArrayList<>();
                    mData.child("Users").child(userID).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for(DataSnapshot snap: snapshot.getChildren()){
                                String user=snap.getValue(String.class);
                                profileUser.add(user);
                            }
                            BinhLuan binhLuan= new BinhLuan(edtConment.getText().toString(),profileUser.get(0));
                            mData.child("BinhLuan").child(nameChild).push().setValue(binhLuan);
                            edtConment.getText().clear();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                else {
                    Toast.makeText(Comment_activity.this,"Ban chua chua dang ki tai khoan",Toast.LENGTH_LONG).show();
                }

                return false;
            }
        });
    }
    public void getData(String namechild) {
        mData.child("BinhLuan").child(namechild).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot snap : snapshot.getChildren()) {
                    BinhLuan binhLuan=snap.getValue(BinhLuan.class);
                    list.add(binhLuan);
                }
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void anhXa() {
        list = new ArrayList<>();
        fragment = new QuestionFragment();
        recyclerView = findViewById(R.id.rv_comment);
        recyclerView.setHasFixedSize(true);
        tvNoiDungCauHoi = findViewById(R.id.tv_noidungCauhoi);
        edtConment = findViewById(R.id.edt_entercomment);
    }
}