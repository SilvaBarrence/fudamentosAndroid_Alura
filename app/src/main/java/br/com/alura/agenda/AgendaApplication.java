package br.com.alura.agenda;

import android.app.Application;

import br.com.alura.agenda.DAO.AlunoDAO;
import br.com.alura.agenda.model.Aluno;

@SuppressWarnings("WeakerAccess")
public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosTeste();
    }

    private void criaAlunosTeste() {
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Usuario teste 1", "1199999999", "teste1@gmail.com"));
        dao.salva(new Aluno("Usuario teste 2", "1188888888", "teste2@gmail.com"));
    }
}
