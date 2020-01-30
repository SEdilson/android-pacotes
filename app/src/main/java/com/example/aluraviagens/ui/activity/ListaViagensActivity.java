package com.example.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aluraviagens.R;
import com.example.aluraviagens.dao.PacoteDAO;
import com.example.aluraviagens.models.Pacote;
import com.example.aluraviagens.ui.adapter.ListaPacotesAdapter;

import java.util.List;

import static com.example.aluraviagens.ui.activity.PacoteKeys.PACOTE_KEY;

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
        configuraListenerDoPacote(listaPacotes);
    }

    private void configuraListenerDoPacote(ListView lista) {
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Pacote pacoteRetornado = (Pacote) adapterView.getItemAtPosition(position);
                abrePacoteSelecionado(pacoteRetornado);
            }
        });
    }

    private void abrePacoteSelecionado(Pacote pacote) {
        Intent intent = new Intent(this, ResumoPacoteActivity.class);
        intent.putExtra(PACOTE_KEY, pacote);
        startActivity(intent);
    }
}