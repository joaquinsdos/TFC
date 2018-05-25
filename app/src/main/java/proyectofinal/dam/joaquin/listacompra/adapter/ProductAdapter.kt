package proyectofinal.dam.joaquin.listacompra.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import proyectofinal.dam.joaquin.listacompra.model.Product
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.row_producs.view.*
import proyectofinal.dam.joaquin.listacompra.R


class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private val lista: MutableList<Product> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_producs, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(lista[position])

    }

    override fun getItemCount(): Int {
        return lista.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Product) = with(itemView) {
            list__checkbox__comprado.isChecked=item.listo
        }
    }
}