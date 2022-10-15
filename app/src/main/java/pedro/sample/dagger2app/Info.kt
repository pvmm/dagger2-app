package pedro.sample.dagger2app

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Named


const val UNSPECIFIED = "Unspecified"


@Module
open class BeginModule {
    @Provides
    open fun sayHello(): Greeting {
        return Greeting("friend")
    }

    @Provides @Named(UNSPECIFIED)
    fun sayHello2(): Greeting {
        return Greeting("stranger")
    }
}


@Module
class FinishModule {
    @Provides
    fun sayGoodbye(): Farewell {
        return Farewell("friend")
    }
}


open class Greeting(name: String) {
    val text = "Hello, $name!"
}


class Farewell(name: String) {
    val text = "Goodbye, $name!"
}


@Component(modules = [BeginModule::class, FinishModule::class])
interface EtiquetteComponent {
    fun inject(app: MainActivity)
}
