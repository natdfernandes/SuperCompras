package com.example.supercompras

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class SuperComprasViewModel : ViewModel() {
    private val _listaDeItens = MutableStateFlow<List<ItemCompra>>(emptyList())
    val listaDeItens: StateFlow<List<ItemCompra>> = _listaDeItens

    fun adicionarItem(item: ItemCompra){
        _listaDeItens.update { lista ->
            lista + item
        }
    }
    fun removerItem(item: ItemCompra){
        _listaDeItens.update { lista ->
            lista - item
        }
    }
    fun editarItem(itemEditado: ItemCompra, novotexto: String){
        _listaDeItens.update { lista ->
            lista.map{ itemAtual ->
                if (itemAtual == itemEditado){
                    itemAtual.copy(texto = novotexto)
                }else {
                    itemAtual
                }
            }
        }
    }

    fun mudarStatus(itemSelecionado: ItemCompra){
        _listaDeItens.update{lista ->
            lista.map{ itemMap ->
                if (itemSelecionado == itemMap){
                    itemSelecionado.copy(foiComprado = !itemSelecionado.foiComprado)
                }else{
                    itemMap
                }
            }
        }
    }
}