package proyectofinal.dam.joaquin.listacompra

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import proyectofinal.dam.joaquin.listacompra.R.id.main__btn_action__new


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            main__btn_action__new -> {
                //TODO - crear producto nuevo en un nuevo activity o fragment y añadirlo a la lista
                main__label__demo.text = getString(R.string.demo_text)

                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }


    }
}
