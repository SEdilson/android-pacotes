package com.example.aluraviagens.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aluraviagens.R;
import com.example.aluraviagens.models.Pacote;
import com.example.aluraviagens.utils.DiasUtil;
import com.example.aluraviagens.utils.DrawableUtil;
import com.example.aluraviagens.utils.MoedaUtil;

import java.util.List;

public class ListaPacotesAdapter extends BaseAdapter {

    private final Context context;
    private final List<Pacote> pacotes;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View viewCriada = LayoutInflater
                .from(context)
                .inflate(R.layout.item_pacote, viewGroup, false);

        configuraPacote(position, viewCriada);
        return viewCriada;
    }

    private void configuraPacote(int position, View viewCriada) {
        Pacote pacote = pacotes.get(position);

        atribuiLocal(viewCriada, pacote);
        pegaImagemDoPacote(viewCriada, pacote);
        formataEValidaDias(viewCriada, pacote);
        formataPreco(viewCriada, pacote);
    }

    private void atribuiLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }

    private void pegaImagemDoPacote(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Drawable drawableImagemPacote = DrawableUtil.retornaDrawable(context, pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);
    }

    private void formataPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        String moedaBrasileira = MoedaUtil.converteParaReais(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void formataEValidaDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String diasEmTexto = DiasUtil.editaTextoDias(pacote.getDias());
        dias.setText(diasEmTexto);
    }
}
