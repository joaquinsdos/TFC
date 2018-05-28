package proyectofinal.dam.joaquin.listacompra

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_new_product.*
import proyectofinal.dam.joaquin.listacompra.R.id.main__btn_action__new
import proyectofinal.dam.joaquin.listacompra.adapter.ProductAdapter
import proyectofinal.dam.joaquin.listacompra.model.Product


class MainActivity : AppCompatActivity() {

    private lateinit var lista: MutableList<Product>
    private val adapter: ProductAdapter = ProductAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lista = mutableListOf(Product(0, "leche", false),
                Product(1, "falso", false),
                Product(2, "verdadero", true),
                Product(1, "falso", false),
                Product(2, "verdadero", true),
                Product(1, "falso", false),
                Product(2, "verdadero", true),
                Product(1, "falso", false),
                Product(2, "verdadero", true),
                Product(1, "falso", false),
                Product(2, "verdadero", true),
                Product(1, "falso", false),
                Product(2, "verdadero", true),
                Product(1, "falso", false),
                Product(2, "verdadero", true),
                Product(1, "falso", false),
                Product(2, "verdadero", true),
                Product(1, "falso", false),
                Product(2, "verdadero", true),
                Product(1, "falso", false),
                Product(2, "verdadero", true)
        )
        setupAdapter()
        setupRecycler()
        actualizarLista()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            main__btn_action__new -> {
                //TODO - crear producto nuevo en un nuevo activity o fragment y añadirlo a la lista
                val dialogo = Dialogo()
                dialogo.show(supportFragmentManager, "nuevo")

                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun setupRecycler() {
        main__list__products.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        main__list__products.adapter = adapter
    }

    private fun setupAdapter() {
        adapter.setLista(lista)
    }

    private fun actualizarLista() {
        lista.sortBy { it.listo }
        adapter.notifyDataSetChanged()
    }


    fun onCreateDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Dialog")
        builder.setView(this.layoutInflater.inflate(R.layout.dialog_new_product, null))
        builder.setPositiveButton("OK", { lalala, _ ->
            lista.add(Product(0, dialog__txt__name.text.toString(), false))
            actualizarLista()
        })
        builder.setNegativeButton("Cancel", { dialogInterface: DialogInterface, _: Int ->
            dialogInterface.cancel()
        })
        builder.show()
    }

}
