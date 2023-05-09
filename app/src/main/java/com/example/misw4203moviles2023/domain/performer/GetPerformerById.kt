package com.example.misw4203moviles2023.domain.performer

import com.example.misw4203moviles2023.data.PerformerRepository
import com.example.misw4203moviles2023.data.model.PerformerModel

class GetPerformerById {
    private val repository = PerformerRepository()

    suspend operator fun invoke(id: Int): PerformerModel = repository.getPerformerById(id)
}
