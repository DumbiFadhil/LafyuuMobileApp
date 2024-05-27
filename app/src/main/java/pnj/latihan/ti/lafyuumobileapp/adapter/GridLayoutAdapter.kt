package pnj.latihan.ti.lafyuumobileapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pnj.latihan.ti.lafyuumobileapp.R
import pnj.latihan.ti.lafyuumobileapp.model.Item


class GridLayoutAdapter(private val itemList: List<Item>) :
    RecyclerView.Adapter<GridLayoutAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productImage: ImageView = view.findViewById(R.id.ProductImage)
        val productName: TextView = view.findViewById(R.id.ProductName)
        val productPrice: TextView = view.findViewById(R.id.ProductPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.productImage.setImageResource(item.imageId)
        holder.productName.text = item.name
        holder.productPrice.text = item.price
    }

    override fun getItemCount() = itemList.size
}