package pedro.sample.dagger2app

import dagger.Component
import javax.inject.Inject


@Component
interface MagicBox {
    fun inject(app: MainActivity)
}


class Info @Inject constructor() {
    val text = "Hello Dagger 2"
}