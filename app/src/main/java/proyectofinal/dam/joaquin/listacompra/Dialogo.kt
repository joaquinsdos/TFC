package proyectofinal.dam.joaquin.listacompra

import android.support.v4.app.DialogFragment
import android.R.string.cancel
import android.app.Dialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import kotlinx.android.synthetic.main.dialog_new_product.*


class Dialogo: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(activity!!.applicationContext)
        val inflater = activity!!.layoutInflater

        builder.setView(inflater.inflate(R.layout.dialog_new_product, null))
                .setPositiveButton("Aceptar", { dialog, _ ->
                    Log.i("TAG", "algo del dialogo " + dialog__txt__name.text.toString() )
                    dialog.cancel()
                })

        return builder.create()
    }
}