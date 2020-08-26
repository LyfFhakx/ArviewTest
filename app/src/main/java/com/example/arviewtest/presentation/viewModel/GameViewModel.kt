package com.example.arviewtest.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arviewtest.data.Game
import com.example.arviewtest.data.network.Api
import com.example.arviewtest.domain.GameRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class GameViewModel(
    private val api: Api,
    private val gameRepository: GameRepository
) : ViewModel() {

    val _Games = MutableLiveData<List<Game>>()
    val allGames = mutableListOf<Game>()
    val displayedGames: LiveData<List<Game>> = _Games

    fun initialise() {
        viewModelScope.launch(context = IO) {
            val response = api.getGames()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                displayGames(body)
            } else {
                Log.e("BeerListViewModel", "Service call failed: $response")
            }
        }
    }

    private fun displayGames(body:List<Game>){
        allGames += body.sortedBy { it.name }
        _Games.postValue(allGames)
    }
}