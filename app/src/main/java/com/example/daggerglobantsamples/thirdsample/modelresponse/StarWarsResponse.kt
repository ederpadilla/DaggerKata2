package com.example.daggerglobantsamples.thirdsample.modelresponse

data class StarWarsResponse(
	val next: String? = null,
	val previous: Any? = null,
	val count: Int? = null,
	val results: List<ResultsItem?>? = null
)
