package com.example.android.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        // recycler - вью для оторбражения списков
        val recycler = findViewById<RecyclerView>(R.id.rv_goods)
        // adapter - это класс который из дата классов (классов бизнес логики делает вью классы - классы андроида)
        val goodsAdapter = GoodsAdapter { item ->
            Toast.makeText(this, "товар ${item.id}", Toast.LENGTH_LONG).show()
        }
        recycler.adapter = goodsAdapter
        // layoutManager - это класс который управляет схемой отображения
        recycler.layoutManager = LinearLayoutManager(this)
//        recycler.layoutManager = GridLayoutManager(this, 2)
//        StaggeredGridLayoutManager
        goodsAdapter.addData(getGoods())

    }

    // список товаров (из бека, базы данных, созданный пользователем)
    fun getGoods() = listOf<Good>(
        Good(1, "Товар 1", 12.2f, 1, "Полезное"),
        Good(2, "Товар 2", 12.2f, 2, "Полезное2"),
        Good(3, "Товар 3", 13.2f, 3, "Полезное3"),
        Good(4, "Товар 4", 14.2f, 4, "Полезное4"),
        Good(5, "Товар 5", 15.2f, 5, "Полезное5"),
        Good(6, "Товар 6", 16.2f, 6, "Полезное6"),
        Good(7, "Товар 7", 17.2f, 7, "Полезное7"),
        Good(11, "Товар 11", 11.2f, 11, "Полезное11"),
        Good(12, "Товар 12", 12.2f, 12, "Полезное12"),
        Good(13, "Товар 13", 13.2f, 13, "Полезное13"),
        Good(14, "Товар 14", 14.2f, 14, "Полезное14"),
        Good(15, "Товар 15", 15.2f, 15, "Полезное15"),
        Good(16, "Товар 16", 16.2f, 16, "Полезное16"),
        Good(17, "Товар 17", 17.2f, 17, "Полезное17"),
        Good(21, "Товар 21", 21.2f, 21, "Полезное21"),
        Good(22, "Товар 22", 22.2f, 22, "Полезное22"),
        Good(23, "Товар 23", 23.2f, 23, "Полезное23"),
        Good(24, "Товар 24", 24.2f, 24, "Полезное24"),
        Good(25, "Товар 25", 25.2f, 25, "Полезное25"),
        Good(26, "Товар 26", 26.2f, 26, "Полезное26"),
        Good(27, "Товар 27", 27.2f, 27, "Полезное27"),
    )

}


class GoodsAdapter(
    private val action: (Good) -> Unit // действие по элементу списка
) : RecyclerView.Adapter<GoodViewHolder>() {

    private val data = mutableListOf<Good>() // мутабельный список с данными

//    fun addItem(good: Good) {
//        data.add(good)
//        notifyItemInserted(data.lastIndex)
//    }

    // метод добавления данных
    fun addData(list: List<Good>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    // метод создания вьюхолдера (контейнер, который хранит вью)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodViewHolder {
        Log.d("Recycler", "onCreateViewHolder")

        val view =
            LayoutInflater.from(parent.context)  // получаем LayoutInflater - класс который может из файлов разметки создавать вью
                .inflate(R.layout.li_good, parent, false) // создаем вью
        return GoodViewHolder(view, action)
    }

    // метод который задает данные класса бизнес логики в холдер
    override fun onBindViewHolder(holder: GoodViewHolder, position: Int) {
        Log.d("Recycler", "onBindViewHolder")
        val item = data[position] // получаем нужный экземляр данных

        holder.bind(item) // выставляем их в холдер
    }

    // метод который говорит рецайклеру, сколько раз нужно вызывать onBindViewHolder
    // или сколько элементов в списке
    override fun getItemCount(): Int = data.size
}

// вьюхолдер - контейнер для вью
class GoodViewHolder(
    itemView: View,
    private val action: (Good) -> Unit  // действие по элементу списка
) : RecyclerView.ViewHolder(itemView) {

    private val tvName = itemView.findViewById<TextView>(R.id.tv_name)
    private val tvCategory = itemView.findViewById<TextView>(R.id.tv_category)
    private val checkBox = itemView.findViewById<CheckBox>(R.id.checkbox)

    // задает конкретные значения для этой вью
    fun bind(item: Good) {
        tvName.text = item.name
        tvCategory.text = item.category
        itemView.setOnClickListener { action(item) } // вызов экшена по клику

//        checkBox.setOnCheckedChangeListener(null)
//        checkBox.isChecked = item.isChecked
//        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
//            Log.d("checkbox", "${item.id} is checked")
//        }

    }

}


data class Good(
    val id: Long,
    val name: String,
    val price: Float,
    val count: Int,
    val category: String,
    val isChecked: Boolean = false
)