package devandroid.lucas.applistacurso.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.lucas.applistacurso.Model.Pessoa;
import devandroid.lucas.applistacurso.R;
import devandroid.lucas.applistacurso.controller.PessoaController;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;/*Salvara um determinado na forma de pares de valores-chave semelhantes a um Mapa*/
    public static final String NOME_PREFERENCES = "pref_listavip";

    PessoaController controller;

//    Pessoa pessoa;
//    Pessoa outraPessoa;
//
//    String dadosPessoa;
//    String dadosOutraPessoa;

    EditText editPrimeiroNome;
    EditText editSobreNome;
    EditText editNomeCurso;
    EditText editTelefoneContato;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;


    /*Instancia o lanyout(TELA)*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(NOME_PREFERENCES/*Nome do arquivo*/,0/*Modo de execulção*/);
        SharedPreferences.Editor listaVip = sharedPreferences.edit();/*Aplicação da edição*/

        controller = new PessoaController();

        controller.toString();

        Pessoa pessoa = new Pessoa(
                "Nathan",
                "Souza",
                "Android",
                "25 98795-9765");

        /*Associação ao XML pro JAVA*/
        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobreNome = findViewById(R.id.editSobreNome);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        /*Para ocupar o campo(Serve para o EditText)*/
        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobreNome.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());

        /*Associar um comando ao click deste botão*/
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimeiroNome.setText(null);
                editSobreNome.setText(null);
                editNomeCurso.setText(null);
                editTelefoneContato.setText(null);

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*E parecido com o JOptionPane*/
                Toast.makeText(MainActivity.this/*Está referenciando a propria classe */,
                        "Volte Sempre",
                        Toast.LENGTH_LONG/*Pede para demorar um tempo antes de execultar*/).show();

                finish();/*Fecha a aplicação*/
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pessoa NovaPessoa = new Pessoa(
                        editPrimeiroNome.getText().toString(),
                        editSobreNome.getText().toString(),
                        editNomeCurso.getText().toString(),
                        editTelefoneContato.getText().toString()
                );

                    Toast.makeText(
                            MainActivity.this,
                            "Foi criado com sucesso o usuario: \n\" " + NovaPessoa.getPrimeiroNome() + " " + NovaPessoa.getSobreNome() + " \" ",
                            Toast.LENGTH_LONG
                    ).show();

                    listaVip.putString/*Envia*/("PrimeiroNome",NovaPessoa.getPrimeiroNome());
                    listaVip.putString/*Envia*/("sobreNome",NovaPessoa.getSobreNome());
                    listaVip.putString/*Envia*/("nomeCurso",NovaPessoa.getCursoDesejado());
                    listaVip.putString/*Envia*/("telefoneContato",NovaPessoa.getTelefoneContato());

                    listaVip.apply();/*Salvamento*/

                    controller.salvar(NovaPessoa);
            }
        });

    }
}