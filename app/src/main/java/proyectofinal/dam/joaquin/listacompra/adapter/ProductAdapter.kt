package proyectofinal.dam.joaquin.listacompra.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.realm.Realm
import kotlinx.android.synthetic.main.row_producs.view.*
import proyectofinal.dam.joaquin.listacompra.R
import proyectofinal.dam.joaquin.listacompra.model.Product


class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    private var lista: MutableList<Product> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_producs, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista, this)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun setLista(lista: MutableList<Product>) {
        this.lista = lista
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val realm: Realm = Realm.getDefaultInstance()

        fun bind(lista: MutableList<Product>, productAdapter: ProductAdapter) = with(itemView) {
            list__checkbox__comprado.setOnClickListener {
                lista.sortBy { it.listo }
                productAdapter.notifyDataSetChanged()
            }

            list__checkbox__comprado.setOnCheckedChangeListener { _, isChecked ->

                realm.beginTransaction()
                lista[layoutPosition].listo = isChecked
                realm.copyToRealmOrUpdate(lista[layoutPosition])
                realm.commitTransaction()
            }

            list__checkbox__comprado.isChecked = lista[layoutPosition].listo
            list__checkbox__comprado.text = lista[layoutPosition].name

            list__btn__delete.setOnClickListener {
                if (layoutPosition != -1) {
                    realm.executeTransaction {
                        lista[layoutPosition].deleteFromRealm()
                        lista.removeAt(layoutPosition)
                    }
                    productAdapter.notifyItemRemoved(layoutPosition)
                }

            }

        }
    }
}