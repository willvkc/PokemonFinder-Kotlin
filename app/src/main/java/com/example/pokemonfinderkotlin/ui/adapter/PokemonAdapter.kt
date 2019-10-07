import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonfinderkotlin.R
import com.example.pokemonfinderkotlin.data.model.ItemPokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_pokemon.view.*

class PokemonAdapter(
    private val pokemons: List<ItemPokemon>,
    val onItemClickListener: ((pokemon: ItemPokemon) -> Unit)
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(view, onItemClickListener)
    }

    override fun getItemCount() = pokemons.count()

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bindView(pokemons[position])
    }

    class PokemonViewHolder(view: View, private val onItemClickListener: ((pokemon: ItemPokemon) -> Unit)) :
        RecyclerView.ViewHolder(view) {
        private val nameTextView = view.nameTextView
        private val thumbImageView = view.thumbImageView

        fun bindView(pokemon: ItemPokemon) {
            nameTextView.text = pokemon.name
            Picasso.get().load(pokemon.thumbnailImage).into(thumbImageView)
            itemView.setOnClickListener {
                onItemClickListener.invoke(pokemon)
            }

        }
    }


}