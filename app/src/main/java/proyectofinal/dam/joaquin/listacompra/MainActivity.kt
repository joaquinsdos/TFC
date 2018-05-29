package proyectofinal.dam.joaquin.listacompra

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import io.realm.Realm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_new_product.view.*
import proyectofinal.dam.joaquin.listacompra.R.id.main__btn_action__new
import proyectofinal.dam.joaquin.listacompra.adapter.ProductAdapter
import proyectofinal.dam.joaquin.listacompra.model.Product


class MainActivity : AppCompatActivity() {

    private var lista: MutableList<Product> = mutableListOf()
    private val adapter: ProductAdapter = ProductAdapter()
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        realm = Realm.getDefaultInstance()
        val results: RealmResults<Product> = realm.where(Product::class.java).findAll()
        lista.addAll(results)
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
                newProductDialog()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun newProductDialog() {
        val dialogView: View = layoutInflater.inflate(R.layout.dialog_new_product, null, false)
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Nuevo elemento")
        builder.setView(dialogView)
                .setPositiveButton("Aceptar", { dialog, id ->

                    realm.beginTransaction()
                    var nuevoID = realm.where(Product::class.java).max("id")
                    if (nuevoID == null) {
                        nuevoID = 0
                    }
                    val product = realm.createObject(Product::class.java, nuevoID.toInt() + 1)

                    product.name = dialogView.dialog__txt__name.text.toString()
                    lista.add(0, product)
                    realm.copyToRealm(product)
                    realm.commitTransaction()
                    actualizarLista()
                    dialog.dismiss()
                })
        builder.create().show()
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
}
