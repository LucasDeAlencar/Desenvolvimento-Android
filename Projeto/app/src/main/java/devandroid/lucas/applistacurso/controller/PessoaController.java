package devandroid.lucas.applistacurso.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.lucas.applistacurso.Model.Pessoa;

public class PessoaController {

    @NonNull
    @Override
    public String toString() {

        return super.toString();
    }

    public void salvar(Pessoa pessoa) {
        Log.d("MVC_Controller","Salvo: " + pessoa.toString());

    }
}
