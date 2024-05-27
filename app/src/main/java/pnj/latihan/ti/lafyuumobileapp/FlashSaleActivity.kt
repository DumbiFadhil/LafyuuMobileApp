package pnj.latihan.ti.lafyuumobileapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pnj.latihan.ti.lafyuumobileapp.adapter.FlashSaleAdapter
import pnj.latihan.ti.lafyuumobileapp.model.Item

class FlashSaleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_sale)

        // Back button setup
        val backIcon: ImageView = findViewById(R.id.back_icon)
        backIcon.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        // Flash Sale RecyclerView setup
        val flashSaleRecyclerView: RecyclerView = findViewById(R.id.flash_sale_recycler_view)
        flashSaleRecyclerView.layoutManager = GridLayoutManager(this, 2)

        val flashSaleItems = listOf(
            Item("Nike Air Max 270 React ENG", "$299.43", R.drawable.img_productimage_1),
            Item("Nike Air Max 270 React ENG", "$299.43", R.drawable.img_productimage_2),
            Item("Nike Air Max 270 React ENG", "$299.43", R.drawable.img_productimage_3),
            Item("Nike Air Max 270 React ENG", "$299.43", R.drawable.img_productimage_4)
        )

        flashSaleRecyclerView.adapter = FlashSaleAdapter(this, flashSaleItems)
    }
}