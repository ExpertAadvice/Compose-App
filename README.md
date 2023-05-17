# Compose-App

```
Things you must remember while transfer xml projects to Compose =>

Add these Files in app-level build.gradle -> {
        buildscript {
            ext {
                compose_version = '1.0.5'
            }
            repositories {
                google()
                mavenCentral()
            }
            dependencies {
                classpath "com.android.tools.build:gradle:7.0.3"
                classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31"
            }
        }
}

Add these Files in app-level build.gradle -> {
        buildFeatures {
            viewBinding true
            compose true
        }
        composeOptions {
            kotlinCompilerExtensionVersion compose_version
            kotlinCompilerVersion '1.5.10'
        }
        Dependencies for Compose ->
            implementation "androidx.compose.ui:ui:$compose_version"
            implementation "androidx.compose.material:material:$compose_version"
            implementation "androidx.compose.ui:ui-tooling-preview:$compose_version"
            androidTestImplementation "androidx.compose.ui:ui-test-junit4:$compose_version"
}


Interoperability Compose <=> XML {
    override fun onCreateView(inflater: LayoutInflater, 
                        container: ViewGroup?,savedInstanceState: Bundle?
        ): View {
        _binding = FragmentMyBinding.inflate(inflater, container, false)
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                AndroidView(
                    factory = {
                        TextView(it)
                    }
                ) { textView ->
                    textView.apply {
                        text = "This is an XML view in a composable"
                        setTextColor(Color.BLACK)
                        textSize = 20f
                        gravity = Gravity.CENTER
                    }
                }
            }
        }
    }
}

XML :-    <androidx.compose.ui.platform.ComposeView
                android:id="@+id/composeView"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                app:layout_constraintVertical_chainStyle="packed"
                app:layout_constraintBottom_toTopOf="@+id/textView"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintHorizontal_bias="0.5"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toTopOf="parent" />

====================================================================================================
```
    
