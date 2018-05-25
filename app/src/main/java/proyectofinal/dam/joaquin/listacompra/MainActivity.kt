package proyectofinal.dam.joaquin.listacompra

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import proyectofinal.dam.joaquin.listacompra.R.id.main__btn_action__new
import proyectofinal.dam.joaquin.listacompra.model.Product


class MainActivity : AppCompatActivity() {

    private lateinit var lista: MutableList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lista = mutableListOf(Product(0, "leche", false),
                Product(1, "leche", false),
                Product(2, "leche", false)
        )

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            main__btn_action__new -> {
                //TODO - crear producto nuevo en un nuevo activity o fragment y añadirlo a la lista
                lista.add(Product((Math.random()*100+1).toInt(), "algo", false))
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }


    }
}
