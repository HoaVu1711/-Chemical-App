package com.vdh.doan2020.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vdh.doan2020.Model.Diem;
import com.vdh.doan2020.Model.NguyenToHoaHoc;
import com.vdh.doan2020.Model.Question;
import com.vdh.doan2020.Model.QuestionHuuCo;
import com.vdh.doan2020.Model.QuestionVoCo;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;
    private List<QuestionVoCo> questionVoCoList;
    private  List<QuestionHuuCo>questionHuuCoList;
    private  List<Question>questionList;
    private DatabaseAccess(Context context)
    {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }


    public void close() {
        if (database != null) {
            this.database.close();
        }
    }
    public List<Question>getQuestions(){
        questionList = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM NganHangCauHoi", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Integer ID=cursor.getInt(4);
            String dapanA=cursor.getString(0);
            String dapanB=cursor.getString(1);
            String dapanC=cursor.getString(2);
            String dapanD=cursor.getString(3);
            String ketQua =cursor.getString(5);
            String noiDung=cursor.getString(6);
            Integer phanLoai=cursor.getInt(7);
            Question question= new Question(dapanA,dapanB,dapanC,dapanD,ID,ketQua,noiDung,phanLoai);
            questionList.add(question);
            cursor.moveToNext();
        }
        cursor.close();
        return questionList;
    }
    public void deleteQuestion(){
        database.execSQL("delete from "+"NganHangCauHoi");

    }
    public void insertQuestion(){
        ContentValues contentValues = new ContentValues();
        DatabaseReference mData = FirebaseDatabase.getInstance().getReference();
        mData.child("NGanHangCauHoi").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snap: snapshot.getChildren()){
                    Question question=snap.getValue(Question.class);
                    contentValues.put("DapanA",question.getDapanA());
                    contentValues.put("DapanB",question.getDapanB());
                    contentValues.put("DapanC",question.getDapanC());
                    contentValues.put("DapanD",question.getDapanD());
                    contentValues.put("ID",question.getID());
                    contentValues.put("KetQua",question.getKetQua());
                    contentValues.put("NoiDung",question.getNoiDung());
                    contentValues.put("PhanLoai",question.getPhanLoai());
                    database.insert("NganHangCauHoi",null,contentValues);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public  void insertDiem(String thoigian, String diem){
        ContentValues values= new ContentValues();
        values.put("ThoiGian",thoigian);
        values.put("Diem",diem);
        database.insert("Diem",null,values);
    }
    public List<Diem> getDiem() {
        List<Diem>diemList = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Diem", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String ThoiGian=cursor.getString(0);
            String Diem=cursor.getString(1);
            Diem diem= new Diem(ThoiGian,Diem);
            diemList.add(diem);
            cursor.moveToNext();
        }
        cursor.close();
        return diemList;
    }
    public List<QuestionVoCo> getQuestionVoColist() {
        questionVoCoList = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM VoCoQuestions", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Integer ID=cursor.getInt(0);
            String dapanA=cursor.getString(1);
            String dapanB=cursor.getString(2);
            String dapanC=cursor.getString(3);
            String dapanD=cursor.getString(4);
            String ketQua =cursor.getString(5);
            String noiDung=cursor.getString(6);
            QuestionVoCo voCo= new QuestionVoCo(ID,dapanA,dapanB,dapanC,dapanD,ketQua,noiDung);
            questionVoCoList.add(voCo);
            cursor.moveToNext();
        }
        cursor.close();
        return questionVoCoList;
    }
    public List<QuestionHuuCo> getQuestionHuuColist() {
        questionHuuCoList = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM HuuCoQuestions", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Integer ID=cursor.getInt(0);
            String dapanA=cursor.getString(1);
            String dapanB=cursor.getString(2);
            String dapanC=cursor.getString(3);
            String dapanD=cursor.getString(4);
            String ketQua =cursor.getString(5);
            String noiDung=cursor.getString(6);
            QuestionHuuCo huuCo= new QuestionHuuCo(ID,dapanA,dapanB,dapanC,dapanD,ketQua,noiDung);
            questionHuuCoList.add(huuCo);
            cursor.moveToNext();
        }
        cursor.close();
        return questionHuuCoList;
    }

    public List<NguyenToHoaHoc> getNguyenToHoaHoc(){
        List<NguyenToHoaHoc>list= new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT * FROM NguyenToHoaHoc",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            NguyenToHoaHoc nguyenToHocHoc= new NguyenToHoaHoc(cursor.getString(1),cursor.getString(2),cursor.getFloat(3),cursor.getInt(5),cursor.getString(6));
            list.add(nguyenToHocHoc);
            cursor.moveToNext();
        }
        cursor.close();
        return  list;
    }
    public List<NguyenToHoaHoc> phanLoaiNguyenToHoaHoc(String phanLoai){
        List<NguyenToHoaHoc>list= new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT * FROM NguyenToHoaHoc WHERE PhanLoai ='"+phanLoai+"'",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            NguyenToHoaHoc nguyenToHocHoc= new NguyenToHoaHoc(cursor.getString(1),cursor.getString(2),cursor.getFloat(3),cursor.getInt(5),cursor.getString(6));
            list.add(nguyenToHocHoc);
            cursor.moveToNext();
        }
        cursor.close();
        return  list;
    }
}
