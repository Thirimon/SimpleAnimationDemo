package com.example.simpleanimationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateInt
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simpleanimationdemo.ui.theme.SimpleAnimationDemoTheme

@OptIn(ExperimentalAnimationApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleAnimationDemoTheme {
               Column(modifier = Modifier.fillMaxSize()) {
                   var isVisible by remember{ mutableStateOf(false) }
                   var isRound by remember{ mutableStateOf(false) }
                   Button(onClick =
                   { isVisible= !isVisible
                       isRound= !isRound
                   }) {
                       Text(text = "Toggle")
                   }
                   AnimatedContent(
                       targetState = isVisible,
                       modifier = Modifier
                           .fillMaxWidth()
                           .weight(1f),
                       content={isVisible ->
                           if(isVisible){
                               Box(modifier=Modifier.background(Color.Green))
                           }
                           else{
                               Box(modifier=Modifier.background(Color.Red))
                           }
                       },
                       transitionSpec = {
                           slideInHorizontally(initialOffsetX =
                           { if(isVisible) it else -it }) with
                                   slideOutHorizontally(
                               targetOffsetX = { if(isVisible) -it else it })

                       }
                   )
//                   val transition= updateTransition(targetState = isRound,label = null)
//                   val borderRadius by transition.animateInt(
//                       transitionSpec = { tween(2000) },
//                       label = "borderRadius",
//                       targetValueByState = {
//                           isRound ->
//                           if(isRound) 100 else 0
//                       }
//                   )
//                   val color by transition.animateColor(
//                       transitionSpec = { tween(1000) },
//                       label = "color",
//                       targetValueByState = {isRound -> if(isRound) Color.Green else Color.Red}
//                   )
//                   val borderRadius by animateIntAsState(
//                       targetValue = if(isRound) 40 else 20,
//                      //animationSpec = tween(durationMillis = 2000, delayMillis = 300, easing = LinearEasing)
//                       //animationSpec = spring(dampingRatio = Spring.DampingRatioHighBouncy,
//                       //    stiffness = Spring.StiffnessLow)
//                   )
//                   val transition= rememberInfiniteTransition()
//                   val color by transition.animateColor(
//                       initialValue = Color.Red,
//                       targetValue =Color.Yellow ,
//                       animationSpec = infiniteRepeatable(
//                           animation = tween(2000),
//                           repeatMode = RepeatMode.Reverse
//                       )
//                   )
//                   Box(
//                       Modifier
//                           .size(200.dp)
//                           .background(color))
//                  AnimatedVisibility(visible = isVisible,
//                      enter= slideInHorizontally() + fadeIn(),
//                      exit= slideOutHorizontally()+ fadeOut(),
//                      modifier=Modifier.fillMaxWidth().weight(1f)
//                      ) {
//                      Box(Modifier.background(Color.Magenta))
//                  }
               }

                    }
                }
            }
        }




