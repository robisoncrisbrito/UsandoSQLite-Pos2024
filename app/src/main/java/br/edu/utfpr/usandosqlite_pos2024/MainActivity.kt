package br.edu.utfpr.usandosqlite_pos2024

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.utfpr.usandosqlite_pos2024.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var banco : SQLiteDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate( layoutInflater )
        setContentView(binding.root )

        setButtonListener()

        banco = SQLiteDatabase.openOrCreateDatabase(
            this.getDatabasePath( "dbfile.sqlite" ),
            null
        )

        banco.execSQL( "CREATE TABLE IF NOT EXISTS cadastro (_id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, telefone TEXT ) ")
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

    }

    private fun btAlterarOnClick() {

    }

    private fun btExcluirOnClick() {

    }

    private fun btPesquisarOnClick() {

    }

    private fun btPListarOnClick() {

    }




}