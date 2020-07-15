package com.memento.simpleeditor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final History history = new History();
    private SimpleEditor editor = new SimpleEditor();

    private Button undoChangeBtn;
    private EditText simpleEditor;

    private boolean undoAction = false;

    // https://www.it-swarm.dev/pt/android/evento-chave-do-android-edittext-delete-backspace/972162018/

    private View.OnClickListener undoChangeBtnListener = new View.OnClickListener() {
        public void onClick(View v) {
            try {
                undoAction = true;
                editor.restore(history.pop());
                simpleEditor.setText(editor.getContent());
                simpleEditor.setSelection(editor.getContent().length());

                Log.i("History size", String.valueOf(history.size()));
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        undoChangeBtn = (Button) findViewById(R.id.btnUndoChange);
        simpleEditor = (EditText) findViewById(R.id.simpleEditor);

        history.push(editor.createState());

        simpleEditor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // TODO
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int count, int i2) {
                if (undoAction) {
                    undoAction = false;
                } else {
                    if (charSequence.length() - 1 >= 0) {
                        char keyPressed = charSequence.charAt(charSequence.length() - 1);
                        editor.setContent(charSequence.toString());

                        if (keyPressed == ' ') {
                            String[] list = editor.getContent().split(" ");

                            for (String item: list) {
                                history.push(editor.createState());
                                System.out.println("History registered");
                            }
                        }
                    } else {
                        history.push(editor.createState());
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // TODO
            }
        });

        undoChangeBtn.setOnClickListener(undoChangeBtnListener);
    }
}