package com.example.aluraviagens.ui.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aluraviagens.R;
import com.example.aluraviagens.dao.PacoteDAO;
import com.example.aluraviagens.models.Pacote;
import com.example.aluraviagens.ui.adapter.ListaPacotesAdapter;

import java.util.List;

public class ListaViagensActivity extends AppCompatActivity {

    private static final String PACOTES_TITULO_APPBAR = "Pacotes";
    private PacoteDAO dao = new PacoteDAO();
    private List<Pacote> pacotes = dao.lista();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_viagens);

        setTitle(PACOTES_TITULO_APPBAR);

        configuraPacotes(pacotes);
    }

    private void configuraPacotes(List<Pacote> pacotes) {
        ListView listaPacotes = findViewById(R.id.lista_viagens_listview);
        listaPacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }
}
