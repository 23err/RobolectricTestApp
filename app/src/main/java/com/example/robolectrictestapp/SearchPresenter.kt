package com.example.robolectrictestapp

internal class SearchPresenter internal constructor(
    private val viewContract: ViewSearchContract,
    private val repository: GitHubRepository
) : PresenterSearchContract, GitHubRepositoryCallback {
}

