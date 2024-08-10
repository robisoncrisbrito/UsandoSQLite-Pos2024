package br.edu.utfpr.usandosqlite_pos2024

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.utfpr.usandosqlite_pos2024.database.DatabaseHandler
import br.edu.utfpr.usandosqlite_pos2024.databinding.ActivityMainBinding
import br.edu.utfpr.usandosqlite_pos2024.entity.Cadastro

class MainActivity : AppCompatActivity() { //fim da MainActivity

    private lateinit var binding : ActivityMainBinding
    private lateinit var banco : DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate( layoutInflater )
        setContentView(binding.root )

        setButtonListener()

        banco = DatabaseHandler(this )

        System.out.println( "onCreate() executado" )
    }

    private fun setButtonListener() {
        binding.btIncluir.setOnClickListener{
            btIncluirOnClick()
        }

        binding.btAlterar.setOnClickListener{
            btAlterarOnClick()
        }

        binding.btExcluir.setOnClickListener{
            btExcluirOnClick()
        }

        binding.btPesquisar.setOnClickListener{
            btPesquisarOnClick()
        }

        binding.btListar.setOnClickListener{
            btPListarOnClick()
        }
    }

    private fun btIncluirOnClick() {
        banco.insert( Cadastro( 0, binding.etNome.text.toString(), binding.etTelefone.text.toString() ) )
        Toast.makeText( this, "Sucesso!!!", Toast.LENGTH_LONG ).show()
    }

    private fun btAlterarOnClick() {
        banco.update( Cadastro( binding.etCod.text.toString().toInt(), binding.etNome.text.toString(), binding.etTelefone.text.toString() ) )
        Toast.makeText( this, "Sucesso!!!", Toast.LENGTH_LONG ).show()
    }

    private fun btExcluirOnClick() {
        banco.delete( binding.etCod.text.toString().toInt() )
        Toast.makeText( this, "Sucesso!!!", Toast.LENGTH_LONG ).show()
    }

    private fun btPesquisarOnClick() {
        val registro =  banco.find( binding.etCod.text.toString().toInt()  )

        if ( registro != null ) {
            binding.etNome.setText( registro.nome )
            binding.etTelefone.setText( registro.telefone )
        } else {
            Toast.makeText( this, "Registro não encontrado", Toast.LENGTH_LONG ).show()
        }
    }

    private fun btPListarOnClick() {
        val intent = Intent( this, ListarActivity::class.java )
        startActivity( intent )

    }

    override fun onStart() {
        super.onStart()
        System.out.println( "onStart() executado" )
    }

    override fun onResume() {
        super.onResume()
        System.out.println( "onResume() executado" )
    }

    override fun onPause() {
        super.onPause()
        System.out.println( "onPause() executado" )
    }

    override fun onStop() {
        super.onStop()
        System.out.println( "onStop() executado" )
    }

    override fun onDestroy() {
        super.onDestroy()
        System.out.println( "onDestroy() executado" )
    }

    override fun onRestart() {
        super.onRestart()
        System.out.println( "onDestroy() executado" )
    }

}