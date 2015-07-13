package com.example.aplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	// Criação dos objetos
    EditText editLogin;
    EditText editSenha;
    Button btnAcessar;

    // Variável para validar os dados do formulário
    Boolean camposValidados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vinculando os objetos aos seus IDs
        editLogin = (EditText) findViewById(R.id.editLogin);
        editSenha = (EditText) findViewById(R.id.editSenha);
        btnAcessar = (Button) findViewById(R.id.btnAcessar);

        // Programando o botÃ£o btnAcessar
        btnAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                camposValidados = true;

                // Valida o campo LOGIN
                if (!editLogin.getText().toString().equals("aula"))
                {
                    Toast.makeText(getApplication(),
                            "O campo LOGIN é obrigatório",
                            Toast.LENGTH_LONG).show();

                    // Atribuindo falso para camposValidados
                    camposValidados = false;
                }

                // Valida o campo senha
                if (!editSenha.getText().toString().equals("123"))
                {
                    Toast.makeText(getApplication(),
                            "O campo Senha é obrigatório",
                            Toast.LENGTH_LONG).show();

                    // Atribuindo falso para camposValidados
                    camposValidados = false;
                }

                // Carrega a tela Dashboard
                if(camposValidados)
                {
                    Toast.makeText(getApplication(),
                            "Usuário Autenticado com Sucesso!",
                            Toast.LENGTH_LONG).show();

                    // Muda de tela
                    Intent dashboard = new Intent(MainActivity.this,
                                                  DashboardActivity.class);
                    startActivity(dashboard);

                    // Remove a Activity Main da pilha
                    finish();
                }else{
                    Toast.makeText(getApplication(),
                            "Dados invalidos!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
