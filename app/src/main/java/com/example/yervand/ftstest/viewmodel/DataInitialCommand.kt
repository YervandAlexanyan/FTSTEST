package com.example.yervand.ftstest.viewmodel

import com.example.yervand.ftstest.db.repository.sqlite.FTSDataRepository
import com.example.yervand.ftstest.db.repository.realm.RealmRepository
import com.example.yervand.ftstest.viewmodel.base.implementation.BaseCommand

class DataInitialCommand(private val viewModel: SearchViewModel, private val repository: FTSDataRepository, private val realmRepository: RealmRepository) : BaseCommand() {
    override fun execute(obj: Any?) {
        val result = realmRepository.all()
        repository.insert(result)
        viewModel.codexItems?.addAll(result)
    }
}