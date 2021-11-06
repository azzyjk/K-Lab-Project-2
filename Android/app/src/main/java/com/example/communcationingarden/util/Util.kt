package com.example.communcationingarden.util

fun Int.toDistanceText(): String {
	return "${(this.toDouble() / 1000)}km"
}