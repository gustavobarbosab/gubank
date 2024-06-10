package com.github.gustavobarbosab.androidcourse.ui.common.transition

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.tween
import androidx.navigation.NavBackStackEntry


fun AnimatedContentTransitionScope<NavBackStackEntry>.slideIntoContainerToLeft() =
    standardSlideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left)

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideIntoContainerToRight() =
    standardSlideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right)

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideOutOfContainerToLeft() =
    standardSlideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left)

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideOutOfContainerToRight() =
    standardSlideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right)

fun AnimatedContentTransitionScope<NavBackStackEntry>.standardSlideIntoContainer(
    slideDirection: AnimatedContentTransitionScope.SlideDirection
) = slideIntoContainer(
    animationSpec = tween(400, easing = EaseIn),
    towards = slideDirection
)

fun AnimatedContentTransitionScope<NavBackStackEntry>.standardSlideOutOfContainer(
    slideDirection: AnimatedContentTransitionScope.SlideDirection
) = slideOutOfContainer(
    animationSpec = tween(400, easing = EaseOut),
    towards = slideDirection
)