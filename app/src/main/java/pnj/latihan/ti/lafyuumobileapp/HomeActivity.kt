package pnj.latihan.ti.lafyuumobileapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import pnj.latihan.ti.lafyuumobileapp.adapter.CarouselAdapter
import pnj.latihan.ti.lafyuumobileapp.adapter.CategoryAdapter
import pnj.latihan.ti.lafyuumobileapp.adapter.GridLayoutAdapter
import pnj.latihan.ti.lafyuumobileapp.adapter.HorizontalLayoutAdapter
import pnj.latihan.ti.lafyuumobileapp.model.Category
import pnj.latihan.ti.lafyuumobileapp.model.Item

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val fav = findViewById<ImageView>(R.id.favorite_icon)
        fav.setOnClickListener {
            val favorite = Intent(this, FavoriteActivity::class.java)
            startActivity(favorite)
        }

        // Bottom Navigation setup
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Handle home navigation
                    true
                }
                R.id.navigation_explore -> {
                    // Handle explore navigation
                    true
                }
                R.id.navigation_cart -> {
                    // Handle cart navigation
                    true
                }
                R.id.navigation_offer -> {
                    // Handle offer navigation
                    true
                }
                R.id.navigation_account -> {
                    // Handle account navigation
                    val logout = Intent(this, LoginActivity::class.java)
                    startActivity(logout)
                    finish()
                    true
                }
                else -> false
            }
        }

        // Carousel setup
        val carouselViewPager: ViewPager2 = findViewById(R.id.carousel_view_pager)
        val carouselItems = listOf(1, 2, 3)  // Dummy data to create 3 identical items
        carouselViewPager.adapter = CarouselAdapter(carouselItems)

        // Category RecyclerView
        val categoryRecyclerView: RecyclerView = findViewById(R.id.category_recycler_view)
        categoryRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val categories = listOf(
            Category("Man Shirt", R.drawable.img_arrowdown_light_blue_a200),
            Category("Dress", R.drawable.img_dressicon),
            Category("Man Work Equipment", R.drawable.img_bag),
            Category("Woman Bag", R.drawable.img_thumbsup),
            Category("Man Shoes", R.drawable.img_arrowright),
            Category("High Heels", R.drawable.img_vector)
        )

        categoryRecyclerView.adapter = CategoryAdapter(categories)

        // Flash Sale RecyclerView
        val flashSaleRecyclerView: RecyclerView = findViewById(R.id.flash_sale_recycler_view)
        flashSaleRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val flashSaleItems = listOf(
            Item("FS - Nike Air Max 270", "$299.43", R.drawable.img_productimage_1),
            Item("FS - QUILTED MAXI CROSS", "$299.43", R.drawable.img_productimage_2),
            Item("FS - Nike Air Max 270", "$299.43", R.drawable.img_productimage_3)
        )

        flashSaleRecyclerView.adapter = HorizontalLayoutAdapter(flashSaleItems)

        // Navigate to Flash Sale Activity on "See More" click
        val seeMoreFlashSale: TextView = findViewById(R.id.see_more_flash_sale)
        seeMoreFlashSale.setOnClickListener {
            val intent = Intent(this, FlashSaleActivity::class.java)
            startActivity(intent)
        }

        // Mega Sale RecyclerView
        val megaSaleRecyclerView: RecyclerView = findViewById(R.id.mega_sale_recycler_view)
        megaSaleRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val megaSaleItems = listOf(
            Item("MS - Nike Air Max 270", "$299.43", R.drawable.img_productimage_4),
            Item("MS - QUILTED MAXI CROSS", "$299.43", R.drawable.img_productimage_5),
            Item("MS - Nike Air Max 270", "$299.43", R.drawable.img_productimage_6)
        )

        megaSaleRecyclerView.adapter = HorizontalLayoutAdapter(megaSaleItems)

        // Recommended Product RecyclerView
        val recommendedRecyclerView: RecyclerView = findViewById(R.id.recommended_recycler_view)
        recommendedRecyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columns

        val recommendedItems = listOf(
            Item("Nike Air Max 270", "$299.43", R.drawable.img_productimage_1),
            Item("Nike Air Max 270", "$299.43", R.drawable.img_productimage_2),
            Item("Nike Air Max 270", "$299.43", R.drawable.img_productimage_3)
        )

        recommendedRecyclerView.adapter = GridLayoutAdapter(recommendedItems)
    }
}