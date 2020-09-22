package cu.sld.guiahlucia.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import com.sld.guiahlucia.R
import cu.sld.guiahlucia.model.DataModel
import kotlinx.android.synthetic.main.item_cars.view.*


class AutomobilesAdapter(
    private var dataList: List<DataModel>
) : RecyclerView.Adapter<AutomobilesAdapter.AutomobileVH>(), Filterable {

    var filteredList: List<DataModel> = dataList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutomobileVH {
        return AutomobileVH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_cars, parent, false)
        )
    }

    override fun getItemCount() = filteredList.size

    override fun onBindViewHolder(holder: AutomobileVH, position: Int) = holder.bind(filteredList[position])

    class AutomobileVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: DataModel) = with(itemView) {

            dpto.text = data.Dpto
            extencion.text = data.Extencion
            directo.text = data.Directo



            //setOnClickListener {
             //   Toast.makeText(itemView.context, "${data.Dpto} - ${data.Extencion}", Toast.LENGTH_SHORT).show()
            //}

        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {

            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()

                filteredList = when {
                    charString.isEmpty() -> dataList
                    else -> {
                        val internalFilteredList: MutableList<DataModel> = mutableListOf()
                        for (data in dataList) {
                            if (data.Dpto.contains(charString, ignoreCase = true)
                                || data.Extencion.contains(charString, ignoreCase = true)) {
                                internalFilteredList.add(data)
                            }
                        }
                        internalFilteredList
                    }
                }

                val filteredResults = FilterResults()
                filteredResults.values = filteredList
                return filteredResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                filteredList = p1?.values as List<DataModel>
                notifyDataSetChanged()
            }

        }
    }

}