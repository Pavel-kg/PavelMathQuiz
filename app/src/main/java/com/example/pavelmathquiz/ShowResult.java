package com.example.pavelmathquiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import android.widget.Spinner;
import android.widget.TextView;

import com.example.pavelmathquiz.model.Quiz;
import com.example.pavelmathquiz.model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class ShowResult extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private static final int REQUEST_CODE1 = 1;

    ListView lvListView;
    EditText editTextRegister;
    TextView textViewScore;
    Button btnBack, btnShow;
    String spinnerSource[]={"All", "Right", "Wrong", "Sort A", "Sort D"};
    ArrayAdapter<Quiz> listAdapter;
    ArrayList<Quiz> listOfQuizes;
    Spinner spinnerSort;
    RadioButton radioBtnAll, radioBtnWrong, radioBtnRight, radioBtnAsc, radioBtnDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        initialize();
    }

    public void initialize() {
        spinnerSort = findViewById(R.id.spinnerSort);
        spinnerSort.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, spinnerSource);
        spinnerSort.setAdapter(adapter);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("intentExtra");
        Serializable bundleContent = bundle.getSerializable("bundleContent");
        lvListView = findViewById(R.id.lvListView);
        editTextRegister = findViewById(R.id.editTextRegister);
        textViewScore = findViewById(R.id.textViewScore);
        btnShow = findViewById(R.id.btnShow);
        btnShow.setOnClickListener(this);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        spinnerSort.setVisibility(View.GONE);
        listOfQuizes = new ArrayList<>();
        listOfQuizes = (ArrayList<Quiz>) bundleContent;
        listAdapter = new ArrayAdapter<Quiz>(this, android.R.layout.simple_list_item_1, listOfQuizes);
        lvListView.setAdapter(listAdapter);

        radioBtnAll = findViewById(R.id.radioBtnAll);
        radioBtnWrong = findViewById(R.id.radioBtnWrong);
        radioBtnRight = findViewById(R.id.radioBtnRight);
        radioBtnAsc = findViewById(R.id.radioBtnAsc);
        radioBtnDesc = findViewById(R.id.radioBtnDesc);
        totalScore();
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.btnBack:
                if (editTextRegister.getText().toString().equals("")) {
                    editTextRegister.setText("incognito");
                }
           User user = new User(editTextRegister.getText().toString(), textViewScore.getText().toString(), listOfQuizes);
           Intent intent = new Intent();
           intent.putExtra("user", user);
           setResult(RESULT_OK, intent);
            finish();
           break;

            case R.id.btnShow:
                show();
                break;
        }
    }
    public void totalScore() {
       int count = 0;
       for (Quiz quiz : listOfQuizes) {
          if (quiz.getScore() > 0)
             count++;
        }
    textViewScore.setText(((100 * count) / listOfQuizes.size()) + " %");
    }


    public void show() {
        ArrayList<Quiz> tempList = new ArrayList<>();
        if (radioBtnAll.isChecked()) {
            listAdapter = new ArrayAdapter<Quiz>(this, android.R.layout.simple_list_item_1, listOfQuizes);
            lvListView.setAdapter(listAdapter);
        }

        if (radioBtnRight.isChecked())  {
            for (Quiz quiz : listOfQuizes) {
                if (quiz.getScore() == 1)
                    tempList.add(quiz);
            }
            listAdapter = new ArrayAdapter<Quiz>(this, android.R.layout.simple_list_item_1, tempList);
            lvListView.setAdapter(listAdapter);
        }

        if (radioBtnWrong.isChecked()) {
            for (Quiz quiz : listOfQuizes) {
                if (quiz.getScore() == 0)
                    tempList.add(quiz);
            }
            listAdapter = new ArrayAdapter<Quiz>(this, android.R.layout.simple_list_item_1, tempList);
            lvListView.setAdapter(listAdapter);

        }
        if (radioBtnAsc.isChecked()) {

                Collections.sort(listOfQuizes);

           listAdapter = new ArrayAdapter<Quiz>(this, android.R.layout.simple_selectable_list_item, listOfQuizes);
           lvListView.setAdapter(listAdapter);
        }
        if (radioBtnDesc.isChecked()) {
            Collections.sort(listOfQuizes, Collections.reverseOrder());
            listAdapter = new ArrayAdapter<Quiz>(this, android.R.layout.simple_selectable_list_item, listOfQuizes);
            lvListView.setAdapter(listAdapter);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ArrayList<Quiz> tempList = new ArrayList<>();
        switch (spinnerSource[i]) {
            case "All":
                listAdapter = new ArrayAdapter<Quiz>(this, android.R.layout.simple_list_item_1, listOfQuizes);
                lvListView.setAdapter(listAdapter);
                break;
           case "Right":
             for (Quiz quiz : listOfQuizes) {
                    if (quiz.getScore() == 1)
                     tempList.add(quiz);
                }
             listAdapter = new ArrayAdapter<Quiz>(this, android.R.layout.simple_list_item_1, tempList);
                lvListView.setAdapter(listAdapter);
                break;
           case "Wrong":
                for (Quiz quiz : listOfQuizes) {
                    if (quiz.getScore() == 0)
                        tempList.add(quiz);
                }
                listAdapter = new ArrayAdapter<Quiz>(this, android.R.layout.simple_list_item_1, tempList);
                lvListView.setAdapter(listAdapter);
                break;
           case "Sort A":
               Collections.sort(listOfQuizes);
                listAdapter = new ArrayAdapter<Quiz>(this, android.R.layout.simple_selectable_list_item, listOfQuizes);
                lvListView.setAdapter(listAdapter);
                break;

          case "Sort D":
                Collections.sort(listOfQuizes, Collections.reverseOrder());
                listAdapter = new ArrayAdapter<Quiz>(this, android.R.layout.simple_spinner_dropdown_item, listOfQuizes);
                lvListView.setAdapter(listAdapter);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }


}
