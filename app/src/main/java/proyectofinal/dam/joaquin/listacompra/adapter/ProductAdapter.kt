package proyectofinal.dam.joaquin.listacompra.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_producs.view.*
import proyectofinal.dam.joaquin.listacompra.R
import proyectofinal.dam.joaquin.listacompra.model.Product


class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ViewHolder>(), View.OnClickListener {
    private var lista: MutableList<Product> = mutableListOf()
    private lateinit var listener: View.OnClickListener

    override fun onClick(v: View?) {

        listener.onClick(v)

    }

    fun setOnClickListener(listener: View.OnClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_producs, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista, position, this, this)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun setLista(lista: MutableList<Product>) {
        this.lista = lista
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(lista: MutableList<Product>, pos: Int, listener: View.OnClickListener, productAdapter: ProductAdapter) = with(itemView) {
            list__checkbox__comprado.setOnClickListener(listener)
            list__checkbox__comprado.setOnCheckedChangeListener { _, isChecked ->
                lista[pos].listo = isChecked
            }
            list__checkbox__comprado.isChecked = lista[pos].listo
            list__checkbox__comprado.text = lista[pos].name

            list__btn__delete.setOnClickListener {
                lista.removeAt(layoutPosition)
                productAdapter.notifyItemRemoved(layoutPosition)

            }

        }
    }
}