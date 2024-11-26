import com.training.extensions.WeatherExtension
import org.gradle.api.Project

val Project.weather: WeatherExtension
    get() = extensions.getByType(WeatherExtension::class.java)

fun Project.weather(configuration: WeatherExtension.() -> Unit) {
    weather.apply(configuration)
}