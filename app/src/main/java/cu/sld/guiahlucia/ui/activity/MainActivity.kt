package cu.sld.guiahlucia.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import com.sld.guiahlucia.R
import cu.sld.guiahlucia.model.DataModel
import cu.sld.guiahlucia.ui.adapter.AutomobilesAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: AutomobilesAdapter
    private val mItemsList: ArrayList<DataModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        initItems()

        mItemsList.shuffle()

        mAdapter = AutomobilesAdapter(mItemsList)
        list.adapter = mAdapter

    }

    private fun initItems() {
        mItemsList.add(DataModel("Informática", "4272", Directo = "24481654"))
        mItemsList.add(DataModel("Informática NODO", "4270",null))
        mItemsList.add(DataModel("Informática NODO", "4270",null))
        mItemsList.add(DataModel("Informática NODO", "4270",null))
        mItemsList.add(DataModel("Informática NODO", "4270",null))
        mItemsList.add(DataModel("Informática NODO", "4270",null))
        mItemsList.add(DataModel("Informática NODO", "4270",null))
        mItemsList.add(DataModel("Informática NODO", "4270",null))
        mItemsList.add(DataModel("Informática NODO", "4270",null))
        mItemsList.add(DataModel("Informática NODO", "4270",null))
        mItemsList.add(DataModel("VD Admon", "4270",null))
        mItemsList.add(DataModel("Direccion", "4270",null))
        mItemsList.add(DataModel("Puesto de Mando", "4270",null))
        mItemsList.add(DataModel("Admision", "4270",null))
        mItemsList.add(DataModel("Estadistica", "4270",null))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        val menuItem = menu?.findItem(R.id.search)
        val searchView: SearchView = menuItem?.actionView as SearchView

        performSearch(searchView)

        return super.onCreateOptionsMenu(menu)
    }

    private fun performSearch(searchView: SearchView) {

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //Log.d("TAG", "Text $newText")
                mAdapter.filter.filter(newText)

                return true
            }


        })

    }

}