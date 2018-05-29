package proyectofinal.dam.joaquin.listacompra.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Product (@PrimaryKey var id: Int = 0, var name: String = "", var listo: Boolean = false) : RealmObject()