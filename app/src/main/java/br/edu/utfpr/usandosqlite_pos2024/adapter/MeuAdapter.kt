package br.edu.utfpr.usandosqlite_pos2024.adapter

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import br.edu.utfpr.usandosqlite_pos2024.R
import br.edu.utfpr.usandosqlite_pos2024.entity.Cadastro

class MeuAdapter(val context : Context, val cursor : Cursor) : BaseAdapter() {
    override fun getCount(): Int {
        return cursor.count
    }

    override fun getItem(position: Int): Any {
        cursor.moveToPosition( position )
        val cadastro = Cadastro(
            cursor.getInt(  0 ),
            cursor.getString( 1 ),
            cursor.getString( 2 )
        )
        return cadastro
    }

    override fun getItemId(position: Int): Long {
        cursor.moveToPosition( position )
        return cursor.getLong( 0 )
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService( Context.LAYOUT_INFLATER_SERVICE ) as LayoutInflater
        val v = inflater.inflate( R.layout.elemento_lista, null )

        val tvNomeElementoLista = v.findViewById<TextView>( R.id.tvNomeElementoLista )
        val tvTelefoneElementoLista = v.findViewById<TextView>( R.id.tvTelefoneElementoLista )

        cursor.moveToPosition( position )

        tvNomeElementoLista.setText( cursor.getString( 1 ) )
        tvTelefoneElementoLista.setText( cursor.getString( 2 ) )

        return v
    }
}