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

public class FolderActivity extends AppCompatActivity {
    ImageButton btnFolderPlus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFolderPlus = findViewById(R.id.btnFolderPlus);

        btnFolderPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(FolderActivity.this);
                dlg.setTitle("폴더 추가");
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
    }
}