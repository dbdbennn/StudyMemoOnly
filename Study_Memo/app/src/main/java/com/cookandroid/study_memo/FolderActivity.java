package com.cookandroid.study_memo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FolderActivity extends AppCompatActivity {
    ImageButton btnFolderPlus, btnCategoryPlus;
    EditText category_name, folder_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFolderPlus = findViewById(R.id.btnFolderPlus);
        btnCategoryPlus = findViewById(R.id.btnCategoryPlus);
        category_name = findViewById(R.id.category_name);
        folder_name = findViewById(R.id.folder_name);

        btnFolderPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(FolderActivity.this);
                dlg.setTitle("폴더 추가");
                dlg.setIcon(R.drawable.folder_plus);
                final View dlgView = (View)View.inflate(FolderActivity.this, R.layout.folder_name_dialog, null); //dlg.xml을 java로 가져온 거임.
                dlg.setView(dlgView);
                dlg.setPositiveButton("생성", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "생성됐습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "취소됐습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });

        btnCategoryPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(FolderActivity.this);
                dlg.setTitle("카테고리 추가");
                dlg.setIcon(R.drawable.category);
                final View dlgView = (View)View.inflate(FolderActivity.this, R.layout.category_name_dialog, null); //dlg.xml을 java로 가져온 거임.
                dlg.setView(dlgView);
                dlg.setPositiveButton("생성", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String dirPath = "sdcard/myMemo/"+category_name;
                        File file = new File(dirPath);
                        if(!file.exists())
                            file.mkdir();
                        Toast.makeText(getApplicationContext(), "생성됐습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "취소됐습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });


    }
}