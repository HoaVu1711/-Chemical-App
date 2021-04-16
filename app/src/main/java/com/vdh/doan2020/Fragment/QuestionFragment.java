package com.vdh.doan2020.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.vdh.doan2020.Adapter.GridAnwerAdapter;
import com.vdh.doan2020.DataBase.DatabaseAccess;
import com.vdh.doan2020.Model.Question;
import com.vdh.doan2020.R;
import com.vdh.doan2020.UI.Comment_activity;
import com.vdh.doan2020.UI.QuestionPageActivity;

import java.util.ArrayList;
import java.util.List;

public class QuestionFragment extends Fragment implements View.OnClickListener {
    private int pageNumber;
    TextView tvIndex, tvCauHoi;
    RadioButton rbA, rbB, rbC, rbD;
    RadioGroup radioGroup;
    List<Question> questionList;
    ImageButton btnComment;
    String checkAnswer;
    private View view;
    public static final String NUM_PAGE = "page";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_question, container, false);
        anhXa();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        QuestionPageActivity pageActivity = (QuestionPageActivity) getActivity();
        questionList = pageActivity.getQuestion();
        tvIndex.setText("Câu " + pageNumber);
        rbA.setText(questionList.get(pageNumber-1).getDapanA());
        rbB.setText(questionList.get(pageNumber-1).getDapanB());
        rbC.setText(questionList.get(pageNumber-1).getDapanC());
        rbD.setText(questionList.get(pageNumber-1).getDapanD());
        tvCauHoi.setText(questionList.get(pageNumber-1).getNoiDung());
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                questionList.get(pageNumber-1).setTraLoi(getChoiceAnswer(radioGroup.getCheckedRadioButtonId()));
            }
        });
    }

    public String getChoiceAnswer(int ID) {
        if (ID == R.id.rbA) {
            return "A";
        } else if (ID == R.id.rbB) {
            return "B";
        } else if (ID == R.id.rbC) {
            return "C";
        } else if (ID == R.id.rbD) {
            return "D";
        } else
            return null;
    }

    public void anhXa() {
        btnComment = view.findViewById(R.id.btnComment);
        btnComment.setOnClickListener(this);
        tvIndex = view.findViewById(R.id.tvCauHoi);
        tvCauHoi = view.findViewById(R.id.tvNoidung);
        radioGroup = view.findViewById(R.id.rg);
        rbA = view.findViewById(R.id.rbA);
        rbB = view.findViewById(R.id.rbB);
        rbC = view.findViewById(R.id.rbC);
        rbD = view.findViewById(R.id.rbD);
        btnComment = view.findViewById(R.id.btnComment);
        questionList = new ArrayList<>();
        btnComment.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnComment:
                Intent intent= new Intent(view.getContext(), Comment_activity.class);
                Bundle bundle= new Bundle();
                bundle.putInt("ID",questionList.get(pageNumber-1).getID());
                bundle.putString("NoiDung",questionList.get(pageNumber-1).getNoiDung());
                intent.putExtras(bundle);
                startActivity(intent);
        }

    }


    public String getCheckAnswer() {
        return checkAnswer;
    }

    public void setCheckAnswer(String checkAnswer) {
        this.checkAnswer = checkAnswer;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

}
