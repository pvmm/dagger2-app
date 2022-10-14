package pedro.sample.dagger2app

import dagger.Component
import dagger.Module
import dagger.Provides


@Module
class BeginModule {
    @Provides
    fun sayHello(): Greeting {
        return Greeting("friend!")
    }
}


@Module
class FinishModule {
    @Provides
    fun sayGoodbye(): Farewell {
        return Farewell("friend!")
    }
}


class Greeting(name: String) {
    val text = "Hello, $name"
}

class Farewell(name: String) {
    val text = "Goodbye, $name"
}


@Component(modules = [BeginModule::class, FinishModule::class])
interface EtiquetteComponent {
    fun inject(app: MainActivity)
}
