package com.rodrigo.businesscard.ui


class BusinessCardAdapter :
    ListAdapter<BusinessCard, BusinessCardAdapter.viewHolder>diffcallback()) {

    var listener: (view) -> unit= {}

    override fun onCreatViewHolder(parent: ViewGroup, ViewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, attachToParent: false)

        return ViewHolder(binding)

        ]

        override fun onBindViewHolder(holder; ViewHolder, position: Int) {
            holder.bind(getItem(position))
        }

        inner class viewHolder(
        private val binding: ItenBusinessCardBinding
    ) : RecycleView.ViewHolder(binding.root) {
        fun bind(item: BusinessCard) {
            binding.tvNome.text= item.nome
            binding.tvTelefone.text= item.telefone
            binding.tvEmail.text= item.email
            binding.tvNomeEmpresa.text= item.empresa
            binding.mcvContent.setCardBackgroundcolor(color.parsecolor(item.fundoPersonalizado))
            binding.mcvContent.setOnClickListener ( it: view!
            listenerShare(it)

        }
    }

}

}


class Diffcallback: DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem== newItem
    override fun arecontentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
        oldItem.id == newItem.id

}
