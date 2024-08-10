package br.edu.utfpr.usandosqlite_pos2024

import android.R
import android.database.Cursor
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.utfpr.usandosqlite_pos2024.adapter.MeuAdapter
import br.edu.utfpr.usandosqlite_pos2024.database.DatabaseHandler
import br.edu.utfpr.usandosqlite_pos2024.databinding.ActivityListarBinding

class ListarActivity : AppCompatActivity() {

    private lateinit var binding : ActivityListarBinding
    private lateinit var banco : DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListarBinding.inflate( layoutInflater )
        setContentView(binding.root)

        banco = DatabaseHandler( this )

        val registros = banco.cursorList() //fonte  tem que ter selecionado o campo _id, com exatamente este nome

        val adapter = MeuAdapter( this, registros )
        binding.lvPrincipal.adapter = adapter //destino
    }
}