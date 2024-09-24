package com.example.ej3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuPruebas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_pruebas);

        // Obtener el nombre pasado desde la actividad anterior
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");

        // Configurar el saludo en el TextView
        TextView saludoTextView = findViewById(R.id.textView);
        if (nombre != null && !nombre.isEmpty()) {
            saludoTextView.setText("Hola " + nombre);
        } else {
            saludoTextView.setText("Hola Usuario");
        }

        Button pruebas = findViewById(R.id.simulacross);
        pruebas.setOnClickListener(v -> {
            Intent simulacrosIntent = new Intent(MenuPruebas.this, Simulacros.class);
            startActivity(simulacrosIntent);
        });

        Button tipss = findViewById(R.id.tips);
        tipss.setOnClickListener(v -> {
            Intent tip1Intent = new Intent(MenuPruebas.this, tip1.class);
            startActivity(tip1Intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
