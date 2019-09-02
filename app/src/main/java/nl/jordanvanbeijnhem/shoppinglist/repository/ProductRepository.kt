package nl.jordanvanbeijnhem.shoppinglist.repository

import android.content.Context
import nl.jordanvanbeijnhem.shoppinglist.dao.ProductDao
import nl.jordanvanbeijnhem.shoppinglist.database.ShoppingListRoomDatabase
import nl.jordanvanbeijnhem.shoppinglist.model.Product

class ProductRepository(context: Context) {

    private val productDao: ProductDao

    init {
        val database = ShoppingListRoomDatabase.getDatabase(context)
        productDao = database!!.productDao()
    }

    suspend fun getAllProducts(): List<Product> = productDao.getAllProducts()

    suspend fun insertProduct(product: Product) = productDao.insertProduct(product)

    suspend fun deleteProduct(product: Product) = productDao.deleteProduct(product)

    suspend fun deleteAllProducts() = productDao.deleteAllProducts()
}