package proyectofinal.dam.joaquin.listacompra

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import proyectofinal.dam.joaquin.listacompra.R.id.main__btn_action__new
import proyectofinal.dam.joaquin.listacompra.adapter.ProductAdapter
import proyectofinal.dam.joaquin.listacompra.model.Product
import android.support.v7.widget.LinearLayoutManager




class MainActivity : AppCompatActivity() {

    private lateinit var lista: MutableList<Product>
    private val adapter: ProductAdapter = ProductAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lista = mutableListOf(Product(0, "leche", false),
                Product(1, "falso", false),
                Product(2, "verdadero", true)
        )

        lista.sortBy { it.listo }
        adapter.setLista(lista)


        main__list__products.adapter = adapter
        main__list__products.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            main__btn_action__new -> {
                //TODO - crear producto nuevo en un nuevo activity o fragment y añadirlo a la lista
                lista.add(Product(0, "algo", false))
                adapter.notifyDataSetChanged()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }


    }
}
