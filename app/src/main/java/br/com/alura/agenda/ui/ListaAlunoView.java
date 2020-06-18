package br.com.alura.agenda.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;

import br.com.alura.agenda.DAO.AlunoDAO;
import br.com.alura.agenda.model.Aluno;
import br.com.alura.agenda.ui.adapter.ListaAlunoAdapter;

public class ListaAlunoView {

    private final ListaAlunoAdapter adapter;
    private final AlunoDAO dao;
    private final Context context;

    public ListaAlunoView(Context context) {
        this.context = context;
        this.adapter = new ListaAlunoAdapter(this.context);
        dao = new AlunoDAO();
    }

    public void confirmaRemocao(@NonNull final MenuItem item) {
        new AlertDialog
                .Builder(context)
                .setTitle("Remover aluno")
                .setMessage("Tem certeza que deseja remover o aluno?")
                .setPositiveButton("Sim", (dialog, which) -> {
                    AdapterView.AdapterContextMenuInfo menuInfo =
                            (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
                    remove(alunoEscolhido);
                })
                .setNegativeButton("Não", null)
                .show();
    }


    public void atualizaAluno() {
        adapter.atualiza(dao.todos());
    }


    private void remove(Aluno aluno) {
        dao.remove(aluno);
        adapter.remove(aluno);
    }


    public void configuraAdapter(ListView listaDeAlunos) {
        listaDeAlunos.setAdapter(adapter);
    }
}
