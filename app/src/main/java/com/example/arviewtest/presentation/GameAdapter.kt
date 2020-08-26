package com.example.arviewtest.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.arviewtest.R
import com.example.arviewtest.data.Game
import kotlinx.android.synthetic.main.item_game.view.*

class GameAdapter : ListAdapter<Game, GameAdapter.GameViewHolder>(GameDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return GameViewHolder(inflater.inflate(R.layout.item_game, parent, false))
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val item = getItem(position)
    }

    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val channels = itemView.channels
        val name = itemView.game_name
        val viewers = itemView.viewers
        val gameLogo = itemView.game_logo
    }

    class GameDiffCallback : DiffUtil.ItemCallback<Game>() {
        override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
            return oldItem.gameId == newItem.gameId
        }

        override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
            return oldItem == newItem
        }
    }
}