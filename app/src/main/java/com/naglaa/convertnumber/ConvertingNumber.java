package com.naglaa.convertnumber;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConvertingNumber extends AppCompatActivity {
    EditText number;
    EditText result;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        number=findViewById(R.id.num);
        result=findViewById(R.id.res);
        button=findViewById(R.id.btn);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numStr = number.getText().toString();
                if (numStr.isEmpty()) {
                    Toast.makeText(ConvertingNumber.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    double cm = Double.parseDouble(numStr);
                    double inches = cm / 2.54;
                    result.setText(String.format("%.2f", inches));
                } catch (NumberFormatException e) {
                    Toast.makeText(ConvertingNumber.this, "Invalid number entered", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}