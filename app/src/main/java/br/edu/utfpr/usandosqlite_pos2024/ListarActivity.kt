package br.edu.utfpr.usandosqlite_pos2024

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.edu.utfpr.usandosqlite_pos2024.databinding.ActivityListarBinding

class ListarActivity : AppCompatActivity() {
    private lateinit var binding : ActivityListarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListarBinding.inflate( layoutInflater )
        setContentView(binding.root)

        val registros = listOf<String>( "Brasil", "Argentina", "Paraguai", "Uruguai" ) //fonte

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, registros )//meio de campo
        binding.lvPrincipal.adapter = adapter
    }
}