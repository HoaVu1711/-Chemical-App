package com.vdh.doan2020.UI;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.ViewPager;

import com.vdh.doan2020.Adapter.GridAnwerAdapter;
import com.vdh.doan2020.Adapter.QuestionManagerAdapter;
import com.vdh.doan2020.Adapter.ShowAnswerCorrectAdapter;
import com.vdh.doan2020.DataBase.DatabaseAccess;
import com.vdh.doan2020.Model.Question;
import com.vdh.doan2020.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class QuestionPageActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_countdown;
    private ViewPager viewPager;
    private Button btnCheckAnswer;
    private GridAnwerAdapter gridAnwerAdapter;
    private QuestionManagerAdapter adapter;
    private ShowAnswerCorrectAdapter showAnswerCorrectAdapter;
    private ImageButton btnComment;
    DatabaseAccess access;
    SharedPreferences sharedPreferences;
    private Button btnThoat, btnHoanThanh;
    private List<Question> questionList;
    private  List<Question>questionListTB;
    private  List<Question>questionListKha;
    private  List<Question>questionListGioi;
    private    CountDownAsyncTask countDownAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_page);
        tv_countdown = findViewById(R.id.tv_countdown);
        btnCheckAnswer = findViewById(R.id.btncheck);
        questionList=new ArrayList<>();
        plQuestionPackage();
        createSetQuestion();
        initView();
        btnCheckAnswer.setOnClickListener(this);
    }
    public void initView() {
        btnComment = findViewById(R.id.btnComment);
        btnCheckAnswer = findViewById(R.id.btncheck);
        viewPager = findViewById(R.id.vp_question);
        tv_countdown=findViewById(R.id.tv_countdown);
        countDownAsyncTask = new CountDownAsyncTask();
        countDownAsyncTask.execute(2700);
        adapter=new QuestionManagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        countDownAsyncTask.cancel(true);
    }

    public String PhanLoaiHocSinh(float diem){
        String PhanLoai=null;
        if(diem<=3){
            PhanLoai= "Yeu";
        }
        else if(3<diem&&diem<6.5){
            PhanLoai= "TrungBinh";
        }
        else if(6.5<diem&&diem<9.4){
            PhanLoai="Kha";
        }
        else {
            PhanLoai="Gioi";
        }
        return PhanLoai;
    }
    public void createSetQuestion(){
        Collections.shuffle(questionListTB);
        Collections.shuffle(questionListKha);
        Collections.shuffle(questionListGioi);
        List<Question>tempList=new ArrayList<>();
        sharedPreferences=getSharedPreferences("PhanLoaiHocSinh",MODE_PRIVATE);
        String PhanLoai=sharedPreferences.getString("PhanLoaiHocSinh","");
        if(PhanLoai.equals("TrungBinh")){
            tempList=questionListTB.subList(0,9);
            questionList.addAll(tempList);
            tempList=questionListKha.subList(0,12);
            questionList.addAll(tempList);
            tempList=questionListGioi.subList(0,9);
            questionList.addAll(tempList);
            Collections.shuffle(questionList);
        }
        else if(PhanLoai.equals("Kha")){
            tempList=questionListTB.subList(0,5);
            questionList.addAll(tempList);
            tempList=questionListKha.subList(0,15);
            questionList.addAll(tempList);
            tempList=questionListGioi.subList(0,10);
            questionList.addAll(tempList);
            Collections.shuffle(questionList);
        }
        else if(PhanLoai.equals("Gioi")) {
            tempList=questionListTB.subList(0,5);
            questionList.addAll(tempList);
            tempList=questionListKha.subList(0,12);
            questionList.addAll(tempList);
            tempList=questionListGioi.subList(0,13);
            questionList.addAll(tempList);
        }
        else if(PhanLoai.equals("Yeu")){
            tempList=questionListTB.subList(0,15);
            questionList.addAll(tempList);
            tempList=questionListKha.subList(0,12);
            questionList.addAll(tempList);
            tempList=questionListGioi.subList(0,3);
            questionList.addAll(tempList);
        }
        else {
            tempList=questionListTB.subList(0,9);
            questionList.addAll(tempList);
            tempList=questionListKha.subList(0,12);
            questionList.addAll(tempList);
            tempList=questionListGioi.subList(0,9);
            questionList.addAll(tempList);
            Collections.shuffle(questionList);
        }

    }

    public void plQuestionPackage(){
        questionListTB=new ArrayList<>();
        questionListKha=new ArrayList<>();
        questionListGioi=new ArrayList<>();
        access=DatabaseAccess.getInstance(this);
        access.open();
        List<Question>list=access.getQuestions();
        for(Question question:list){
            if(question.getPhanLoai()==1){
                questionListTB.add(question);
            }
            else  if(question.getPhanLoai()==2){
                questionListKha.add(question);
            }
            else {
                questionListGioi.add(question);
            }
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btncheck:
                Dialog dialog = new Dialog(this,R.style.Dialog);
                dialog.setContentView(R.layout.check_listanwer_dialog);
                btnThoat=dialog.findViewById(R.id.btnthoat);
                btnHoanThanh=dialog.findViewById(R.id.btnhoanthanh);
                TextView tvKetQua=dialog.findViewById(R.id.tv_ketqua);
                gridAnwerAdapter = new GridAnwerAdapter(view.getContext(),questionList);
                GridView gridView = dialog.findViewById(R.id.gw_listanswer);
                gridView.setAdapter(gridAnwerAdapter);
                adapter.notifyDataSetChanged();
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        viewPager.setCurrentItem(i);
                        dialog.dismiss();
                    }
                });
                btnThoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                btnHoanThanh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        float diemPhanLoai=0;
                        int dem=0;
                      for(int i=0;i<30;i++){
                          if(questionList.get(i).getTraLoi().equals(questionList.get(i).getKetQua())){
                              if(questionList.get(i).getPhanLoai()==1){
                                  diemPhanLoai+=1*0.2;
                              }
                              else if(questionList.get(i).getPhanLoai()==2){
                                  diemPhanLoai+=1*0.5;
                              }
                              else{
                                  diemPhanLoai+=1*0.8;
                              }
                              dem++;
                          }
                      }
                      showAnswerCorrectAdapter=new ShowAnswerCorrectAdapter(view.getContext(),questionList);
                      gridView.setAdapter(showAnswerCorrectAdapter);
                      tvKetQua.setText("Bạn trả lời đúng "+dem+" Câu");
                      String PhanLoai=PhanLoaiHocSinh(diemPhanLoai);
                      sharedPreferences=getSharedPreferences("PhanLoaiHocSinh",MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("Level",PhanLoai);
                        editor.commit();
                        Calendar calendar=Calendar.getInstance();
                        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
                        String thoigian=simpleDateFormat.format(calendar.getTime())+"";
                        access.open();
                        access.insertDiem(thoigian,dem+"");
                    }
                });
                dialog.show();
        }
    }

    public List<Question>getQuestion(){
        return questionList;
    }

    public class CountDownAsyncTask extends AsyncTask<Integer, Integer, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected Void doInBackground(Integer... integers) {
            int time = integers[0];
            while (time > 0) {
                time--;
                if(isCancelled()){
                    break;
                }
                publishProgress(time);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            String minute = String.valueOf(values[0] / 60);
            String second = String.valueOf(values[0] % 60);
            tv_countdown.setText(minute + ":" + second);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}