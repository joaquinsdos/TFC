package proyectofinal.dam.joaquin.listacompra.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import proyectofinal.dam.joaquin.listacompra.model.Product
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.row_producs.view.*
import proyectofinal.dam.joaquin.listacompra.R


class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private var lista: MutableList<Product> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_producs, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(lista[position])

    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun setLista(lista: MutableList<Product>){
        this.lista =lista
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Product) = with(itemView) {
            list__checkbox__comprado.isChecked=item.listo
            list__checkbox__comprado.text=item.name
            list__checkbox__comprado.setOnCheckedChangeListener { _, isChecked ->
                item.listo=isChecked
            }
        }
    }
}