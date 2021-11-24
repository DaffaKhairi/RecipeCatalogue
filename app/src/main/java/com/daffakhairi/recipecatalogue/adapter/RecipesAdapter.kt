package com.daffakhairi.recipecatalogue.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daffakhairi.recipecatalogue.DetailActivity
import com.daffakhairi.recipecatalogue.data.Recipes
import com.daffakhairi.recipecatalogue.databinding.RowItemRecipeBinding

class RecipesAdapter(private val listRecipes: ArrayList<Recipes>) : RecyclerView.Adapter<RecipesAdapter.myViewHolder>() {

    inner class myViewHolder(val binding : RowItemRecipeBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = myViewHolder (
        RowItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    )

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.binding.apply {
            with(listRecipes[position]){
                tvNameRecipe.text = listRecipes[position].name
                tvCategory.text = listRecipes[position].category
                tvPrice.text = listRecipes[position].price
                Glide.with(imgRecipe.context).load(photo).into(imgRecipe)
            }
        }
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.DATA_RECIPES, listRecipes[position])
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listRecipes.size
}